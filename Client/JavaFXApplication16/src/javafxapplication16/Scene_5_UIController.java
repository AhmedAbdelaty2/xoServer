/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author moham
 */
public class Scene_5_UIController extends VBox implements Initializable{
String username;
public static String enemy;
          public static DataInputStream dis ;
          public static PrintStream ps;
    private Stage stage;
private Scene scene;
private Parent root;
Alert alert;
Alert refuse;
static String  sympol;

static String result;


private String names;
private String []onlinenames;
private int onlinecount;
int x=0;
int y=0;

String state1,state2;
@FXML
AnchorPane anchorPane;
@FXML
    private Button refresh;
@FXML
    private ListView<Pane> listview;

 @FXML
    private AnchorPane onlinepeoplepan;
    @FXML
    private Button exitButton;

    @FXML
    private Label nameLabel;

    @FXML
 
    void exit(ActionEvent event) {

    }
public void initialize(URL url, ResourceBundle rb) {

username=scene3controller.username;
nameLabel.setText(username);
 try
                {
                    
                    dis = new DataInputStream(controller1.mySocket.getInputStream ());
                    ps = new PrintStream(controller1.mySocket.getOutputStream ());
                  
                     ps.println("names");
                    names=dis.readLine();
                   

                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }

onlinepeople(names);
th.start();

     
}

public  Thread th= new Thread(new Runnable()
{
public void run()
{
while(true){


try{
System.out.println("in the try");




result=dis.readLine();
}
 catch(IOException ex)
{
                    System.out.println("addd7a");
 }
System.out.println("from server"+result);


String state=result.split("\\*")[0];
System.out.println(state);
switch (state){
case "start":
Platform.runLater(new Runnable() {
            @Override public void run() {
               try{
sympol="O";
tothegame();
}catch(IOException e){}
        
            }
        });
break;
case "refused":
    Platform.runLater(new Runnable() {
            @Override public void run() {
    refuse = new Alert(Alert.AlertType.INFORMATION," PLAYER REFUSED TO PLAY");
                refuse.show();
        
            }
        });
    break;
case "request":
    invitation(result.split("\\*")[1]);


    break;
/*case "onlinepeople":
System.out.println(result);
 Platform.runLater(new Runnable() {
            @Override public void run() {
               onlinepeople(result);
            }
        });
    
System.out.println("case");
    break;*/
default:
    System.out.println("default");







 
        
                    }


}}
});
void invitation(String s){
Platform.runLater(new Runnable() {
            @Override public void run() {
                alert = new Alert(Alert.AlertType.CONFIRMATION, s+" want to play!");
                //alert.show();
        Optional<ButtonType> result = alert.showAndWait();
        if(!result.isPresent()){
}
            // alert is exited, no button has been pressed.
        else if(result.get() == ButtonType.OK){
th.suspend();
ps.println("reply*ok");
th.resume();
enemy=s;
try{
System.out.println("to the game");
sympol="X";
tothegame();
System.out.println("to the game");
}catch(IOException e){System.out.println("error");}



}
             //oke button is pressed
        else if(result.get() == ButtonType.CANCEL){
th.suspend();
ps.println("reply*refused");
th.resume();
alert.close();

}
    // cancel button is pressed

            }
        });


}

@FXML
    void refresh(ActionEvent event) throws IOException {
th.suspend();
       ps.println("names");
       names=dis.readLine();
       onlinepeople(names);
th.resume();
    }
@FXML
  void tomenue(ActionEvent event) throws IOException {
th.suspend();
 root = FXMLLoader.load(getClass().getResource("Scene_3_UI.fxml"));
stage=(Stage)exitButton.getScene().getWindow();
scene=new Scene(root);
stage.setScene(scene);
stage.show();

}
Pane p =new Pane();
public void onlinepeople(String s){
                y=0;
                 //listview =new ListView<Pane>;

                listview.getItems().clear();


                //System.out.println(s);
                onlinecount=(s.split("\\*")).length;
                onlinenames=new String [onlinecount];

                onlinenames=names.split("\\*");


                for(Integer i=1;i<onlinecount;i++){
                if(onlinenames[i].equals(username))
                   { 

                continue;
                }
                else{ 
                Font font = Font.font("Courier New", FontWeight.BOLD, 19);


                Label label=new Label(onlinenames[i]);

                label.setMinWidth(100.0);
                Button b=new Button("invite");
                b.setMinWidth(200.0);

                b.setLayoutX(0);
                b.setLayoutY(y);
                b.setFont(font);
                label.setFont(font);
                        label.setLayoutX(250);
                        label.setLayoutY(y);
                b.setId(i.toString());

                p.getChildren().add(label);

                p.getChildren().add(b);

                       y=y+50;

                b.setOnAction((event) -> {String msg= "multi*"+username+"*"+label.getText();

                enemy=label.getText();


                ps.println(msg);
                });
                }






                    listview.getItems().add(p);
                   }


}
void tothegame() throws IOException{
th.suspend();
root = FXMLLoader.load(getClass().getResource("lol.fxml"));
               stage=(Stage)refresh.getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();
}

}

