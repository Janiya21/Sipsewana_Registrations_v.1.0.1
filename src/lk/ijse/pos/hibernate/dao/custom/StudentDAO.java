package lk.ijse.pos.hibernate.dao.custom;

import lk.ijse.pos.hibernate.dao.SuperDAO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.util.List;

public interface StudentDAO extends SuperDAO {

    public List<Student> getAll() throws Exception;
    public int getLastStudent();
    public boolean addStudent(List<Student_Program> stp);
    public Student getStudentObject(int hql);
}
