package lk.ijse.pos.hibernate.dao.custom.impl;

import lk.ijse.pos.hibernate.dao.custom.StudentDAO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

    public int getLastStudent() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.createNativeQuery("SELECT * FROM Student ORDER BY id DESC", Student.class).setMaxResults(1).uniqueResult();

        session.getTransaction().commit();

        return student.getId();
    }

    @Override
    public Student getStudentObject(String hql){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, hql);

        session.getTransaction().commit();

        return student;
    }
}
