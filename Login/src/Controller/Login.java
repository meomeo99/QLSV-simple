package Controller;

import data.Read;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import module.User;

import javax.lang.model.element.Name;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public abstract class Login implements Initializable {
    @FXML
    TextField userr;
    @FXML
    PasswordField passwordd;
    @FXML
    Label loginn;
    @FXML
    public Button closee;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
    public boolean testUser(User user) throws IOException {
        List<User> list = Read.readListUser();
        for (User user2 : list) {
            if (user2.getUser().equals(user.getUser()) && user2.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public void login(ActionEvent event) throws IOException {
        Main main = new Main();
        if(testUser(new User(userr.getText(),passwordd.getText()))) {
            main.changeScene("/view/Login.fxml");
        } else {
            loginn.setVisible(true);
        }
    }
    public void cancel(ActionEvent event) {
        Stage stage = (Stage) closee.getScene().getWindow();
        stage.close();
    }
}