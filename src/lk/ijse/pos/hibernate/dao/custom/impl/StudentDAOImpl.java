package lk.ijse.pos.hibernate.dao.custom.impl;

import lk.ijse.pos.hibernate.dao.custom.StudentDAO;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
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

            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean addStudent(Student_Program entity) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Object merge = session.merge(entity);
        session.getTransaction().commit();
        return merge !=null;
    }
}
