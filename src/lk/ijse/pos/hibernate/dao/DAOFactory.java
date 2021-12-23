package lk.ijse.pos.hibernate.dao;

import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOType daoType){
        switch (daoType){
            case PROGRAM:
                return (T) new ProgramDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();

            default:
                return null;
        }
    }
}
