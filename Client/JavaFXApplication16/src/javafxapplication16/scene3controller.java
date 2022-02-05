/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static javafxapplication16.Scene_5_UIController.dis;
import static javafxapplication16.Scene_5_UIController.ps;


public   class scene3controller implements Initializable{
//private    Socket mySocket;
          private  DataInputStream dis ;
          private  PrintStream ps;
 private Stage stage;
       private Scene scene;
      private Parent root;
       static String  username; 
String state1,state2;
       
@FXML
  Label name;
@FXML
 Label points;

String newscore;

public void initialize(URL url, ResourceBundle rb) {
 try
                {
                    
                    dis = new DataInputStream(controller1.mySocket.getInputStream ());
                    ps = new PrintStream(controller1.mySocket.getOutputStream ());
                  
                  
                     ps.println("newscore");
                    newscore=dis.readLine();
                ps.println("newscore");
                    newscore=dis.readLine();
            ps.println("newscore");
                    newscore=dis.readLine();
                   

                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }

        points.setText(newscore);
System.out.println(newscore);
try{state1=((controller1.replyMsg).split("\\*")[0]);}
    catch (Exception ex){state1="";}
try{state2=((registercontroller.replyMsgreg).split("\\*")[0]);}
    catch (Exception ex){state2="";}

      if(state1.equals("ldone"))
        {  username = controller1.replyMsg.split("\\*")[1];
          //String userpoints = controller1.replyMsg.split("\\*")[2];
            String userpoints =newscore;

                 name.setText(username); 
                points.setText(userpoints);
      }
  if(state2.equals("done"))
        {  username = registercontroller.username;
          String userpoints = newscore;
                 name.setText(username); 
                points.setText(userpoints);
      }
 /*try
                {
                    //controller1.mySocket = new Socket(InetAddress.getLocalHost(), 5005);
                    dis = new DataInputStream(controller1.mySocket.getInputStream ());
                    ps = new PrintStream(controller1.mySocket.getOutputStream ());
                    //th1 = new Thread(this);
                   

                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
*/
    }
public void displayName(String username) throws IOException {


	}
public void exit(ActionEvent event) throws IOException {
 ps.println("exit*"+username+"*");

System.exit(0);

}

public void toonline(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("Scene_6_UI.fxml"));
               stage=(Stage)name.getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();

}
@FXML
 void playWithComputerAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_5_UI.fxml"));
        stage=(Stage)name.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
  
}