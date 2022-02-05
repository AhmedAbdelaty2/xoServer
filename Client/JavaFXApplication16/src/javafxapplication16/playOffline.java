package javafxapplication16;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class playOffline {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label Label1;

    @FXML
    private Button goBack;

    @FXML
    private Button playWithComputer;

    @FXML
    private Button playWithFriend;

    @FXML
    void goBackAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_1_UI.fxml"));
        stage=(Stage)Label1.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void playWithComputerAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_5_UI.fxml"));
        stage=(Stage)Label1.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void playWithFriendAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_4_UI.fxml"));
        stage=(Stage)Label1.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setStageAndSetupListeners(Stage stage) {
    }
 }

//