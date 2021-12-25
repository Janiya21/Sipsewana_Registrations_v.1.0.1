package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.ProgramBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    ProgramDAOImpl programDAO = DAOFactory.getInstance().getDAO(DAOType.PROGRAM);

    @Override
    public List<ProgramDTO> getCourseIds(){
        List<Program> programIds = programDAO.getProgramIds();
        ArrayList<ProgramDTO> idList= new ArrayList<>();

        for (Program pr : programIds){
            idList.add(new ProgramDTO(
                    pr.getProgramId(),
                    pr.getFee()
            ));
        }
        return idList;
    }

    @Override
    public List<ProgramDTO> getAllPrograms(){
        List<Program> programs = programDAO.getProgramIds();
        ArrayList<ProgramDTO> prList= new ArrayList<>();

        for (Program pr : programs){
            prList.add(new ProgramDTO(
                    pr.getProgramId(),
                    pr.getProgram(),
                    pr.getDuration(),
                    pr.getFee()
            ));
        }
        return prList;

    }

    @Override
    public Program getProgramObject(String obj){
        return programDAO.getProgramObject(obj);
    }

    @Override
    public boolean addProgram(Program program){
        return programDAO.addProgram(program);
    }

    @Override
    public String generateId() {
        return programDAO.generateId();
    }
}
