package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.StudentBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.dto.Student_ProgramDTO;
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
    public boolean addStudentProgram(Student stu, List<Program> pro, String date){
        return studentDAO.addStudentProgram(stu,pro,date);
    }

    @Override
    public List<Student_ProgramDTO> getStuPro(int stu_id){
        List<Student_Program> relevantStuPro = studentDAO.getRelevantStuPro(stu_id);
        List<Student_ProgramDTO> spd = new ArrayList<>();

        for (Student_Program sp : relevantStuPro) {
            spd.add(new Student_ProgramDTO(sp.getId(),sp.getProgram(),sp.getStudent(),sp.getReg_date()));
        }

        return spd;
    }

    @Override
    public boolean deleteStudent(List<Student_ProgramDTO> stu){
        List<Student_Program> st = new ArrayList<>();

        for (Student_ProgramDTO sp : stu) {
            st.add(new Student_Program(sp.getId(),sp.getStuId(),sp.getProgramId(),sp.getRegDate()));
        }
        return studentDAO.deleteStudent(st);
    }
}
