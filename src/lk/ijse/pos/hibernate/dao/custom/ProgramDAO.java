package lk.ijse.pos.hibernate.dao.custom;

import lk.ijse.pos.hibernate.dao.SuperDAO;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;

import java.util.List;

public interface ProgramDAO extends SuperDAO {
    public List<Program> getProgramIds();
    public List<Program> getAllPrograms();
    public boolean addProgram(Program entity);
    public String generateId();
    public Program getProgramObject(String hql);
}
