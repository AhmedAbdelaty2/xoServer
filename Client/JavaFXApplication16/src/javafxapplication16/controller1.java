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
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;




public class controller1  implements Initializable/*,Runnable*/{

@FXML
private TextField username;
    @FXML
    private PasswordField password;
@FXML
    private Label check;
    @FXML
    private Button login;
@FXML
    private Button register ;
String replyMsg;
   public    Socket mySocket;
   public DataInputStream dis ;
   public PrintStream ps;
    private Stage stage;
private Scene scene;
private Parent root;
Thread th1;
@Override
    public void initialize(URL url, ResourceBundle rb) {

    }
 @FXML
public void login(ActionEvent event) throws IOException {
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
String uname=username.getText();
String pass=password.getText();
ps.println("signIn"+"."+uname+"."+pass);
//th1.start();
replyMsg = dis.readLine();
//System.out.println(replyMsg);
switch (replyMsg){
        case "ldone":
           { System.out.println("true");
            //switchtoscene3();
            break;
           }
        case "dublicated":
        {
        check.setText("dublicated!");
        username.setText("");
        password.setText("");
        break;
        }
        case "wrong":
    {
        check.setText("Invalid Username or Password!");
        username.setText("");
        password.setText("");
        break;
    }


 }           

}

public void register(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("Scene_2_UI.fxml"));
stage=(Stage)((Node)event.getSource()).getScene().getWindow();
scene=new Scene(root);
stage.setScene(scene);
stage.show();

            
}

 
    
}
