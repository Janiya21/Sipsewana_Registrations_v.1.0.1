package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.StudentBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public List<StudentDTO> getAll() {
        List<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        for (Student student : all) {
            dtoList.add(new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getAddress(),
                    student.getTel()
            ));
        }
        return dtoList;

    }

    @Override
    public boolean addStudent(List<Student_Program> stp){
        return studentDAO.addStudent(stp);
    }

    public boolean addStudentProgram(Student stu, List<Program> pro, String date){
        return studentDAO.addStudentProgram(stu,pro,date);
    }

    @Override
    public int getLastStudent() {
        return studentDAO.getLastStudent();
    }

    public Student getStudentObject(String hql) {
        return studentDAO.getStudentObject(hql);
    }
}
