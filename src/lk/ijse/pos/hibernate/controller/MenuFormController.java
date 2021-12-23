package lk.ijse.pos.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuFormController {

    public JFXButton btnRegistration;
    public JFXButton btnViewDetails;
    public JFXButton btnAddProgram;

    public void registerStudentOnAction(ActionEvent actionEvent) throws IOException {
        loadNext("RegStudent");
    }

    public void addProgramOnAction(ActionEvent actionEvent) throws IOException {
        loadNext("AddProgram");
    }

    public void viewDetailsOnAction(ActionEvent actionEvent) throws IOException {
        loadNext("StudentDetails");
    }

    private void loadNext(String name) throws IOException {
        Stage stage = (Stage) btnAddProgram.getScene().getWindow();
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/"+name+".fxml")));
        primaryStage.setTitle("Register Window");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
