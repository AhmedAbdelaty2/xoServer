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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author moham
 */
public class registercontroller {
        private    Socket mySocket;
          private DataInputStream dis ;
          private PrintStream ps;


        private Stage stage;
       private Scene scene;
      private Parent root;
       static String replyMsgreg;
static String username;
String hmail;
       int flag;
           @FXML
       public  TextField regusername;
         @FXML
       private TextField regemail;
         @FXML
       private TextField regpass;
        @FXML
       private TextField cregpass;
       @FXML
           private Label check1;




       public void submit(ActionEvent event) throws IOException {
                try
                {
                    mySocket = new Socket(InetAddress.getLocalHost(), 5005);
                    dis = new DataInputStream(mySocket.getInputStream ());
                    ps = new PrintStream(mySocket.getOutputStream ());
                    //th1 = new Thread(this);
                   

                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
               

                if(((regpass.getText()).equals(cregpass.getText()))&&(!(regemail.getText().equals(""))) &&(!(regusername.getText().equals("")))&& (!(regpass.getText().equals("")))&& (!(cregpass.getText().equals(""))))
                {   try{hmail=((regemail.getText()).split("\\@")[1]);}
                    catch (Exception ex){hmail="";}

                        if(hmail.equals("gmail.com"))
                             {      ps.println("signUp"+"*"+regusername.getText()+"*"+regemail.getText()+"*"+ regpass.getText());
                                    replyMsgreg= dis.readLine();
                                    if(replyMsgreg.equals("done"))
                                        {
                                            username=regusername.getText();
                                            toplay();
                                        }                 
                                    else{check1.setText("Repeated Username or Password!");}
                             }
                       else{check1.setText("invalid email");}
                }
                else{check1.setText("check inputs");}
       }
      /* public void tologin() throws IOException {

                root = FXMLLoader.load(getClass().getResource("Scene_1_UI.fxml"));
               stage=(Stage)check1.getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();



       }*/
       public void toplay() throws IOException {
                root = FXMLLoader.load(getClass().getResource("Scene_3_UI.fxml"));
               stage=(Stage)check1.getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();



       }
    
}
