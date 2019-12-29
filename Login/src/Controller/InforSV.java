package Controller;

import data.Read;
import data.Write;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import module.Student;
import module.StudentFormat;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class InforSV implements Initializable {
    @FXML
    TableView<StudentFormat> tablee;
    @FXML
    TableColumn<StudentFormat, Integer> noC;
    @FXML
    TableColumn<StudentFormat, Integer> idC;
    @FXML
    TableColumn<StudentFormat, String> nameC;
    @FXML
    TableColumn<StudentFormat, Integer> ageC;
    @FXML
    TableColumn<StudentFormat, Date> birthdayC;
    @FXML
    TableColumn<StudentFormat, String> classC;
    @FXML
    TableColumn<StudentFormat, String> addressC;
    @FXML
    TextField findd;
    @FXML
    ToggleGroup findGr;
    private ObservableList<StudentFormat> studentList;  // observableList
    List<Student> list = new ArrayList<>();

    public List<StudentFormat> getList() throws IOException {
        list = Read.readListStudent();
        List<StudentFormat> li = new ArrayList<>();
        for (Student student : list) {
            li.add(new StudentFormat(student.getNo(), student.getId(), student.getName(), student.getAge(), student.getAddress(), student.getClasss(), student.getBirthday()));
        }
        return li;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        try {
            studentList = FXCollections.observableArrayList(getList());
            noC.setCellValueFactory(new PropertyValueFactory<StudentFormat, Integer>("no"));
            idC.setCellValueFactory(new PropertyValueFactory<StudentFormat, Integer>("id"));
            nameC.setCellValueFactory(new PropertyValueFactory<StudentFormat, String>("Name"));
            ageC.setCellValueFactory(new PropertyValueFactory<StudentFormat, Integer>("age"));
            classC.setCellValueFactory(new PropertyValueFactory<StudentFormat, String>("class"));
            addressC.setCellValueFactory(new PropertyValueFactory<StudentFormat, String>("address"));
            birthdayC.setCellValueFactory(new PropertyValueFactory<StudentFormat, Date>("birthday"));
            tablee.setItems(studentList);
            tablee.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findStudent(ActionEvent event) throws IOException {
        RadioButton selectedRadioButton = (RadioButton) findGr.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        List<StudentFormat> temp = new ArrayList<>();
        String find = findd.getText();
        switch (toogleGroupValue) {
            case "By ID": {
                temp = getList();
                temp = temp.stream()
                        .filter(student -> student.getId() == Integer.parseInt(find))
                        .collect(Collectors.toList());
                studentList = FXCollections.observableArrayList(temp);
                tablee.setItems(studentList);
                tablee.refresh();
                break;
            }
            case "By Name": {
                temp = getList();
                temp = temp.stream()
                        .filter(student -> student.getName().equals(find))
                        .collect(Collectors.toList());
                studentList = FXCollections.observableArrayList(temp);
                tablee.setItems(studentList);
                tablee.refresh();
                break;
            }
            case "By Class": {
                temp = getList();
                temp = temp.stream()
                        .filter(student -> student.getClass().equals(find))
                        .collect(Collectors.toList());
                studentList = FXCollections.observableArrayList(temp);
                tablee.setItems(studentList);
                tablee.refresh();
                break;
            }
            default:
                break;
        }
    }

    public void reloadList(ActionEvent event) throws IOException {
        List<StudentFormat> temp = getList();
        studentList = FXCollections.observableArrayList(temp);
        tablee.setItems(studentList);
        tablee.refresh();
    }

    public void editSt(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/EditInfor.fxml"));
        Parent EditView;
        try {
            EditView = loader.load();
            Scene scene = new Scene(EditView);
            InforSV controller = loader.getController();
            StudentFormat selected = tablee.getSelectionModel().getSelectedItem();
            controller.setValue(selected, "edit");
            stage.setScene(scene);
            stage.setTitle("New Student");
            stage.showAndWait();
            tablee.refresh();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void setValue(StudentFormat selected, String edit) {
    }

    public void neww(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/EditInfor.fxml"));
        Parent EditView;
        try {
            EditView = loader.load();
            Scene scene = new Scene(EditView);
            InforSV controller = loader.getController();
            controller.setAction("add");
            stage.setScene(scene);
            stage.show();
            tablee.refresh();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setAction(String add) {
    }

    public void delete(ActionEvent event) throws IOException {
        List<Student> list = Read.readListStudent();
        StudentFormat selected = tablee.getSelectionModel().getSelectedItem();
        list.remove(selected.getNo() - 1);
        Write.wrieData(list);
        List<StudentFormat> temp = getList();
        studentList = FXCollections.observableArrayList(temp);
        tablee.setItems(studentList);
        tablee.refresh();
    }
    public void logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }
}