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
    public List<Student_Program> getRelevantStuPro(int stu_id);
    public boolean deleteStudent(List<Student_Program> stu);
    public boolean updateStudent(Student student, List<Program> program, String date);
    public Student getStudentObject(int hql);
    public boolean addStudentProgram(Student stu, List<Program> pro, String date);
}
