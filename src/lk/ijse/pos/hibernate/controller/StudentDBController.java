package lk.ijse.pos.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.entity.Student_Program;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class StudentDBController {

    @FXML
    private TableView<StudentDTO> studentView;

    @FXML
    private TableColumn<StudentDTO, ?> colId;

    @FXML
    private TableColumn<StudentDTO, ?> colName;

    @FXML
    private TableColumn<StudentDTO, ?> colEmail;

    @FXML
    private TableColumn<StudentDTO, ?> colPayMethod;

    @FXML
    private TableColumn<StudentDTO, ?> colAddress;

    @FXML
    private TableColumn<StudentDTO, ?> colTelNo;

    @FXML
    private JFXTextField studentId;

    @FXML
    private JFXButton searchStudentBtn;

    @FXML
    private JFXButton dltStudBtn;

    @FXML
    private JFXButton refreshBtn;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField searchStuId;

    @FXML
    private JFXButton btnClear;

    private final ObservableList<StudentDTO> tmList = FXCollections.observableArrayList();
    StudentBOImpl customerBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize() throws Exception {
        setTableData();
    }

    private void setTableData() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colPayMethod.setCellValueFactory(new PropertyValueFactory("method"));
        colTelNo.setCellValueFactory(new PropertyValueFactory("tel"));

        List<StudentDTO> all = customerBOImpl.getAll();
        for(StudentDTO dto : all) {
            StudentDTO tm = new StudentDTO(
                    dto.getId(),
                    dto.getName(),
                    dto.getEmail(),
                    dto.getAddress(),
                    dto.getTel(),
                    dto.getMethod()
            );
            tmList.add(tm);
        }
        studentView.setItems(tmList);
    }

    @FXML
    void backFromDb(ActionEvent event) throws IOException {
        loadNext("MenuForm");
    }

    @FXML
    void btnAdd(ActionEvent event) {
        /*Student stu1 = new Student();
        Student_Program sp1 = new Student_Program("sp-001",)*/
    }

    @FXML
    void dltStudent(ActionEvent event) {

    }

    @FXML
    void refreshStudent(ActionEvent event) {

    }

    @FXML
    void searchStudent(ActionEvent event) {

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

}
