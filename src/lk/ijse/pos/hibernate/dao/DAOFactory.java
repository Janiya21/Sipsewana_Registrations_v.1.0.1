package lk.ijse.pos.hibernate.dao;

import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory==null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case PROGRAM:
                return new ProgramDAOImpl();
            case STUDENT:
                return  new StudentDAOImpl();
            default:
                return null;
        }
    }
}
