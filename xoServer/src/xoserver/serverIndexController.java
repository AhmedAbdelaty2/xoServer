/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package xoserver;

import java.io.IOException;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class serverIndexController {
    private Stage stage;
       private Scene scene;
      private Parent root;  

    @FXML
    private Button exitButton;

    @FXML
    private Button openServerButton;

    @FXML
    void closeApplication(ActionEvent event) {
System.exit(0);
    }

    @FXML
    void openServer(ActionEvent event) throws IOException {
               root = FXMLLoader.load(getClass().getResource("Server_2.fxml"));
               stage=(Stage)openServerButton.getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();
    }

}