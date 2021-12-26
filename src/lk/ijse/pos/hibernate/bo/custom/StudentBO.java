package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAll();
    public int getLastStudent();
    public boolean addStudent(List<Student_Program> stp);
    public Student getStudentObject(String valueOf);
}
