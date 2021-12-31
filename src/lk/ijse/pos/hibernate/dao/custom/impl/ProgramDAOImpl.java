package lk.ijse.pos.hibernate.dao.custom.impl;

import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    private final SessionFactory sessionFactory;

    public ProgramDAOImpl(){
        this.sessionFactory = FactoryConfiguration.getSessionFactory();
    }

    @Override
    public List<Program> getProgramIds(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Program> list = session.createNativeQuery("SELECT * FROM Program", Program.class).list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public Program getProgramObject(String hql){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Program program = session.get(Program.class, hql);

        session.getTransaction().commit();

        return program;
    }

    public List<Program> getProgramList(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Program> query = session.createQuery("SELECT sp.program FROM Student_Program sp WHERE sp.student.id = :stu_id", Program.class);
        query.setParameter("stu_id", id);
        List<Program> list = query.list();

        session.getTransaction().commit();

        return list;
    }

    @Override
    public List<Program> getAllPrograms(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Program> list = session.createNativeQuery("SELECT * FROM Program", Program.class).list();

        session.getTransaction().commit();

        return list;
    }

    @Override
    public boolean addProgram(Program entity) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(entity);
        session.getTransaction().commit();
        return save !=null;
    }

    @Override
    public String generateId() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Program program = session.createNativeQuery("SELECT * FROM Program ORDER BY programId DESC", Program.class).setMaxResults(1).uniqueResult();
        return program.getProgramId();
    }
}
