package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;

import java.util.List;

public interface ProgramBO extends SuperBO {
    public List<ProgramDTO> getAllPrograms();
    public boolean addProgram(ProgramDTO program);
    public String generateId();
    public ProgramDTO getProgramObject(String obj);
}
