package Controller;


import data.Read;
import data.Write;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import module.Student;
import module.StudentFormat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    @FXML
    TextField id;
    @FXML
    TextField name;
    @FXML
    TextField age;
    @FXML
    TextField address;
    @FXML
    TextField classs;
    @FXML
    DatePicker birthday;
    @FXML
    Button closeButton;
    @FXML
    Label loginn;
    StudentFormat temp;
    String ac;

    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    public void setValue(StudentFormat student, String action) {
        temp = student;
        id.setText(Integer.toString(student.getId()));
        name.setText(student.getName());
        birthday.setValue(LOCAL_DATE(student.getBirthday()));
        age.setText(Integer.toString(student.getAge()));
        address.setText(student.getAddress());
        classs.setText(student.getClasss());
        ac = action;
    }

    public void setAction(String action) {
        ac = action;
        loginn.setText("Add Student");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    public void submitEdit(ActionEvent event) throws IOException {
        if (ac.equals("edit")) {
            edit();
        }
     //   Main main = new Main();
       // main.changeScene("/FMXL/sample.fxml");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void cancelEdit(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }


    public void edit() throws IOException {
        LocalDate localDate = birthday.getValue();
        List<Student> list = Read.readListStudent();
        String[] date = localDate.toString().split("-");
        Student s = new Student(temp.getNo(), Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(age.getText()),

                new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]), Integer.parseInt(date[2])), address.getText(),classs.getText());
        list.remove(temp.getNo() - 1);
        list.add(temp.getNo() - 1, s);
        Write.wrieData(list);
    }
}