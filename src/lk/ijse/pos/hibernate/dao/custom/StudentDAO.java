package lk.ijse.pos.hibernate.dao.custom;

import lk.ijse.pos.hibernate.dao.SuperDAO;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDAO {

    public List<Student> getAll() throws Exception;
}
