package lk.ijse.pos.hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.custom.impl.ProgramBOImpl;
import lk.ijse.pos.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.util.ArrayList;
import java.util.List;

public class AddOldStudentController {
    @FXML
    private JFXComboBox<Student> cmbStudentIds;

    @FXML
    private JFXTextField txtStudentId;

    ProgramBOImpl programBOImpl = (ProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);
    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    @FXML
    void getStudentIdsOnAction(ActionEvent event) {

    }

    @FXML
    void programIdOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {
        StudentDAOImpl sp = new StudentDAOImpl();
        Student studentObject = sp.getStudentObject(59);

        ProgramDAOImpl pb = new ProgramDAOImpl();
        Program programObject = pb.getProgramObject("p-001");

        List<Program> programList = pb.getProgramList(59);
        programList.add(programObject);

        sp.updateStudent(studentObject,programList,"2021-09-21");
    }
}
