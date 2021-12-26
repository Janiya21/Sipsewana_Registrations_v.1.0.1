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
import lk.ijse.pos.hibernate.view.tm.Program_fee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private TableView<Program_fee> tblDetails;

    @FXML
    public TableColumn<Program_fee,?> colFee;

    @FXML
    private TableColumn<Program_fee, ?> colCourseId;

    @FXML
    private JFXComboBox<String> cmbCourse;

    @FXML
    private Button btnAdd;

    List<Program> prList = new ArrayList<>();
    ObservableList<Program_fee> allList = FXCollections.observableArrayList();
    HashMap<String, Double> ids_fee = new HashMap<String, Double>();
    private double tot = 0;

    ProgramBOImpl programBOImpl = (ProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);
    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize(){
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("ProgramId"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        loadIds();

    }

    private void loadIds(){
        ObservableList<String> idObs = FXCollections.observableArrayList();

        List<ProgramDTO> allIds_fee = programBOImpl.getAllPrograms();

        for (ProgramDTO p : allIds_fee) {
            idObs.add(p.getProgramId());
            ids_fee.put(p.getProgramId(),p.getFee());
        }

        cmbCourse.setItems(idObs);
    }

    public void goBackOnAction(ActionEvent actionEvent) throws IOException {
        loadNext("MenuForm");
    }

    public void goNextOnAction(ActionEvent actionEvent) {

        List<ProgramDTO> allProgDetails = new ArrayList<>();
        List<Program> programList = new ArrayList<>();

        Student student1 = new Student();
        student1.setName(txtName.getText());
        student1.setDob(String.valueOf(txtDateOfBirth.getValue()));
        student1.setEmail(txtMail.getText());
        student1.setAddress(txtAddress.getText());
        student1.setTel(txtTelephone.getText());

        for (Program pr : prList) {
            allProgDetails.add(new ProgramDTO(pr.getProgramId(),pr.getProgram(),pr.getDuration(),pr.getFee()));
        }

        for (ProgramDTO ap : allProgDetails) {
            programList.add(new Program(ap.getProgramId(),ap.getProgram(),ap.getDuration(),ap.getFee()));
        }

        if(studentBOImpl.addStudentProgram(student1,programList,"2021-01-21")){
            new Alert(Alert.AlertType.CONFIRMATION,"Program Added Done").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Program Not Added!").show();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        setData(String.valueOf(cmbCourse.getValue()));

        Program programObject = programBOImpl.getProgramObject(cmbCourse.getValue());
        prList.add(programObject);

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

    public void setData(String id){
        double program_fee = ids_fee.get(id);

        Program_fee pf = new Program_fee(id,program_fee);
        allList.add(pf);
        tblDetails.setItems(allList);

        tot+=program_fee;
        lblTotal.setText(String.valueOf(tot));
    }

}
