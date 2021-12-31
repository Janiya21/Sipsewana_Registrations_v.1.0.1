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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.custom.impl.ProgramBOImpl;
import lk.ijse.pos.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.pos.hibernate.dto.ProgramDTO;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Program;
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
    private TableView<ProgramDTO> tblProgramDetails;

    @FXML
    private TableColumn<ProgramDTO, ?> colProgramId;

    @FXML
    private TableColumn<ProgramDTO, ?> colProgramName;

    @FXML
    private TableColumn<ProgramDTO, ?> colFee;

    @FXML
    private Label lblTotal;

    @FXML
    private JFXButton btnClear;

    private ObservableList<ProgramDTO> programObsList = FXCollections.observableArrayList();
    private final ObservableList<StudentDTO> tmList = FXCollections.observableArrayList();
    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
    ProgramBOImpl programBOImpl = (ProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);

    private StudentDTO selectedStudent  = null;

    public void initialize() throws Exception {
        setTableData();

        studentView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            selectedStudent=newValue ;
            setProgramData(newValue.getId());

        }));

        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("program"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private void setTableData() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("tel"));

        List<StudentDTO> all = studentBOImpl.getAll();
        for(StudentDTO dto : all) {
            StudentDTO tm = new StudentDTO(
                    dto.getId(),
                    dto.getName(),
                    dto.getEmail(),
                    dto.getAddress(),
                    dto.getTel()
            );
            tmList.add(tm);
        }
        studentView.setItems(tmList);
    }

    private void setProgramData(int stuId){
        programObsList.clear();

        List<ProgramDTO> programList = programBOImpl.getProgramList(stuId);
        for (ProgramDTO pDTO : programList) {
            programObsList.add(new ProgramDTO(pDTO.getProgramId(),pDTO.getProgram(),pDTO.getDuration(),pDTO.getFee()));
        }
        setTotal();
        tblProgramDetails.setItems(programObsList);
    }

    private void setTotal(){
        double tot =0;
        for (ProgramDTO programDTO : programObsList) {
            tot+=programDTO.getFee();
            System.out.println(tot);
        }
        lblTotal.setText(String.valueOf(tot));
    }

    @FXML
    void backFromDb(ActionEvent event) throws IOException {
        loadNext("MenuForm");
    }

    @FXML
    void dltStudent(ActionEvent event) {

        Student_Program stuPro = studentBOImpl.getStuPro(selectedStudent.getId());

        deleteStudent(stuPro);
    }

    private void deleteStudent(Student_Program student){
        studentBOImpl.deleteStudent(student);
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
