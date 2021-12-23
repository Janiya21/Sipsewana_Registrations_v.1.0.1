package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAll();
}
