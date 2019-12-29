package Controller;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

    public static Stage rootStage;

    @Override
    public void start(Stage primaryStage) {
        rootStage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            rootStage.setTitle("Login");
            rootStage.setScene(new Scene(root));
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        rootStage.setHeight(550);
        rootStage.setWidth(825);
        rootStage.getScene().setRoot(pane);
    }
    public void popupScene(String fxml,String namePopup) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(pane);
            Stage popupStage = new Stage();
            popupStage.setScene(scene);
            popupStage.setTitle(namePopup);
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
