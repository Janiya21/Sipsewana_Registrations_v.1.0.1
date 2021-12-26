package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAll();
    public boolean addStudentProgram(Student stu, List<Program> pro, String date);
}
