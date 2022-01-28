 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public   class scene3controller implements Initializable{
private    Socket mySocket;
          private DataInputStream dis ;
          private PrintStream ps;
 private Stage stage;
       private Scene scene;
      private Parent root;
String state1,state2;
       
@FXML
  Label name;
@FXML
 Label points;



public void initialize(URL url, ResourceBundle rb) {
try{state1=((controller1.replyMsg).split("\\*")[0]);}
    catch (Exception ex){state1="";}
try{state2=((registercontroller.replyMsgreg).split("\\*")[0]);}
    catch (Exception ex){state2="";}

      if(state1.equals("ldone"))
        { String username = controller1.replyMsg.split("\\*")[1];
          String userpoints = controller1.replyMsg.split("\\*")[2];
                 name.setText(username); 
                points.setText(userpoints);
      }
  if(state2.equals("done"))
        { String username = registercontroller.username;
          String userpoints = "0";
                 name.setText(username); 
                points.setText(userpoints);
      }

    }
public void displayName(String username) throws IOException {


	}
public void exit(ActionEvent event) throws IOException {

System.exit(0);

}

  
}
