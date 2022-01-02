package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.ProgramBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    ProgramDAOImpl programDAO = (ProgramDAOImpl) DAOFactory.getInstance().getDAO(DAOType.PROGRAM);

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
    public ProgramDTO getProgramObject(String obj){

        Program po = programDAO.getProgramObject(obj);
        return new ProgramDTO(po.getProgramId(),po.getProgram(),po.getDuration(),po.getFee());
    }

    @Override
    public boolean addProgram(ProgramDTO program){
        Program pr = new Program(program.getProgramId(),program.getProgram(),program.getDuration(),program.getFee());
        return programDAO.addProgram(pr);
    }

    @Override
    public String generateId() {
        return programDAO.generateId();
    }

    public List<ProgramDTO> getProgramList(int id){
        List<Program> programList = programDAO.getProgramList(id);
        List<ProgramDTO> programDTOS = new ArrayList<>();
        for (Program p : programList) {
            programDTOS.add(new ProgramDTO(p.getProgramId(),p.getProgram(),p.getDuration(),p.getFee()));
        }
        return programDTOS;
    }
}
