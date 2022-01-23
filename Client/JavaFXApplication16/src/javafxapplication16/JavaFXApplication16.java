/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author moham
 */
public class JavaFXApplication16 extends Application {
    
    @Override
    public  void start(Stage stage) throws Exception {
     
 Parent root = FXMLLoader.load(getClass().getResource("Scene_1_UI.fxml"));
        
        Scene scene = new Scene(root,660,400);
      
        stage.setScene(scene);
        stage.show();
    
    }

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
        launch(args);
    }
    
}
