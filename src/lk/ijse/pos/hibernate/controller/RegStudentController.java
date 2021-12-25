package lk.ijse.pos.hibernate.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.custom.impl.ProgramBOImpl;
import lk.ijse.pos.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.dto.Student_ProgramDTO;
import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class RegStudentController {

    @FXML
    public Label lblDate;

    @FXML
    public Label lblTime;

    @FXML
    public Label lblTotal;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXDatePicker txtDateOfBirth;

    @FXML
    private JFXTextField txtMail;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private JFXTextArea txtAddress;

    @FXML
    private Label lblId;

    @FXML
    private TableView<Student_ProgramDTO> tblDetails;

    @FXML
    public TableColumn<Student_ProgramDTO,?> colFee;

    @FXML
    private TableColumn<Student_ProgramDTO, ?> colCourseId;

    @FXML
    private JFXComboBox<String> cmbCourse;

    @FXML
    private Button btnAdd;

    ObservableList<Student_ProgramDTO> allList = FXCollections.observableArrayList();
    ProgramBOImpl programBOImpl = (ProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);
    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize(){
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("ProgramId"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        loadIds();

    }

    private void loadIds(){
        List<ProgramDTO> allIds = programBOImpl.getCourseIds();
        ObservableList<String> idObs = FXCollections.observableArrayList();
        for (ProgramDTO p : allIds) {
            idObs.add(p.getProgramId());
        }
        cmbCourse.setItems(idObs);
    }

    public void goBackOnAction(ActionEvent actionEvent) throws IOException {
        loadNext("MenuForm");
    }

    public void goNextOnAction(ActionEvent actionEvent) {

        Student student1 = new Student();
        student1.setName("Dissanayaka");
        student1.setDob("2021-01-21");
        student1.setEmail("J@33");
        student1.setAddress("Colombo");
        student1.setTel("0112509821");

        Program p2 = programBOImpl.getProgramObject("p-001");

        Student_Program sp1 = new Student_Program(student1,p2,"2021-01-21");

        if(studentBOImpl.addStudent(sp1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Program Added Done").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Program Not Added!").show();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        setData();
    }

    private void loadNext(String name) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/"+name+".fxml")));
        primaryStage.setTitle("Register Window");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setData(){
        String cId = String.valueOf(cmbCourse.getValue());

        /*Student_ProgramDTO sp = new Student_ProgramDTO(id,cId);*/
        allList.add(sp);
        tblDetails.setItems(allList);
    }

}
