package lk.ijse.pos.hibernate.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.custom.impl.ProgramBOImpl;
import lk.ijse.pos.hibernate.dao.custom.ProgramDAO;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.dto.Student_ProgramDTO;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class RegStudentController {

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
    private TableColumn<Student_ProgramDTO, ?> colStuId;

    @FXML
    private TableColumn<Student_ProgramDTO, ?> colCourseId;

    @FXML
    private JFXComboBox<String> cmbCourse;

    @FXML
    private Button btnAdd;

    ObservableList<Student_ProgramDTO> allList = FXCollections.observableArrayList();
    ProgramBOImpl programBOImpl = (ProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);

    public void initialize(){
        colStuId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("ProgramId"));

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
        String id = lblId.getText();
        String cId = String.valueOf(cmbCourse.getValue());

        Student_ProgramDTO sp = new Student_ProgramDTO(id,cId);
        allList.add(sp);
        tblDetails.setItems(allList);
    }

}
