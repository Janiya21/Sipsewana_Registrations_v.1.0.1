package lk.ijse.pos.hibernate.dao.custom.impl;

import com.mysql.cj.x.protobuf.MysqlxExpr;
import lk.ijse.pos.hibernate.dao.custom.StudentDAO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    public StudentDAOImpl(){
        this.sessionFactory = FactoryConfiguration.getSessionFactory();
    }

    @Override
    public List<Student> getAll() {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<Student> list = session.createNativeQuery("SELECT * FROM student",Student.class).list();

            session.getTransaction().commit();
            session.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addStudent(List<Student_Program> stp) {
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Student_Program student_program : stp) {
            session.save(student_program);
        }

        transaction.commit();

        return true;
    }


    public boolean addStudentProgram(Student stu, List<Program> pro, String date){
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student_Program> stp = new ArrayList<>();

        for(Program pr : pro){
            stp.add(new Student_Program(stu,pr,date));
        }

        for(Student_Program stu_pro : stp){
            session.saveOrUpdate(stu_pro);
        }

        transaction.commit();
        return true;
    }

    @Override
    public int getLastStudent() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.createNativeQuery("SELECT * FROM Student ORDER BY id DESC", Student.class).setMaxResults(1).uniqueResult();

        session.getTransaction().commit();

        return student.getId();
    }

    @Override
    public Student getStudentObject(int hql){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, hql);
        session.getTransaction().commit();

        return student;
    }

    public List<Student_Program> getRelevantStuPro(int stu_id){
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery<Student_Program> nativeQuery = session.createNativeQuery("SELECT * FROM Student_Program WHERE student_id = :id", Student_Program.class);
        nativeQuery.setParameter("id",stu_id);

        List<Student_Program> list = nativeQuery.list();

        for (Student_Program student_program : list) {
            System.out.println("id : " + student_program.getId());
        }

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public boolean deleteStudent(List<Student_Program> stu) {
        for (Student_Program student_program : stu) {
            System.out.println("id fuck : " + student_program.getId());
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int id = 0;

        for (Student_Program student_program : stu) {

            /* session.delete(student_program); -> Error- CASCADE should off in this situation */

            session.createQuery("DELETE FROM Student_Program sp WHERE sp.id =:id").
                    setParameter("id", student_program.getId()).executeUpdate();

            id = student_program.getStudent().getId();

            System.out.println("Delete Query Done");
        }

        session.createQuery("DELETE FROM Student s WHERE s.id = :id").
                setParameter("id", id).executeUpdate();

        transaction.commit();

        return true;
    }

    @Override
    public boolean updateStudent(Student student, List<Program> program, String date){
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("UPDATE Student_Program sp SET sp.student.programList = :proList WHERE sp.student = :sId").
                setParameter("proList", program).setParameter("sId",student).executeUpdate();

        transaction.commit();
        return true;
    }
}
