package lk.ijse.pos.hibernate.util;

import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){

        StandardServiceRegistry sReg=new StandardServiceRegistryBuilder().loadProperties("lk/ijse/pos/hibernate/hibernate.properties").build();

        Metadata mData=new MetadataSources(sReg).addAnnotatedClass(Program.class).addAnnotatedClass(Student.class).addAnnotatedClass(Student_Program.class).
                getMetadataBuilder().build();

        return mData.getSessionFactoryBuilder().build();

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
