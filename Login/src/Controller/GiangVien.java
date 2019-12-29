package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GiangVien implements Initializable {
    @FXML
    public void studentmanage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login2.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }
    @FXML
    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(root);
        Stage NewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
