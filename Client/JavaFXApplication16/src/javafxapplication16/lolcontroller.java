package javafxapplication16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import static javafxapplication16.Scene_5_UIController.dis;
import static javafxapplication16.Scene_5_UIController.enemy;
import static javafxapplication16.Scene_5_UIController.ps;
import static javafxapplication16.Scene_5_UIController.result;
import static javafxapplication16.Scene_5_UIController.sympol;
import javax.lang.model.element.Element;


public class lolcontroller implements Initializable{

    public static DataInputStream dis ;
    public static PrintStream ps;
   
    @FXML
    private Label scoreX;
    @FXML
    private Label symbol;

    @FXML
    private Label scoreO;

    @FXML
    private Button restartGame;

    @FXML
    private Button backtologin;

    @FXML
    private Button playAgain;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn7;

    @FXML
    private Button btn6;

    @FXML
    private Button btn8;
    Alert alert;
    Alert refuse;
private Stage stage;
private Scene scene;
private Parent root;

    @FXML
    private Pane onGameEndPane;
    private int Xcount=0;
    private int Ocount=0;
    @FXML
    private Label onGameEndLabel;
 @FXML
    private Label player1;

    @FXML
    private Label player2;
    @FXML
    String username;
    public boolean boardWin = false;
    gameController Check = new gameController();
    Alert alert1;
    String server;
    private String b0;
    private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String b6;
    private String b7;
    private String b8;
String reply;
    boolean yourturn;
    public int[] btnused={0,0,0,0,0,0,0,0,0};
    int count;
    public ArrayList<Button>btnGroup = new ArrayList<>();


    public void initialize(URL url, ResourceBundle rb) {

playAgain.setVisible(false);
restartGame.setVisible(false);
 scoreX.setVisible(false);
scoreO.setVisible(false);

        count=0;
        if(Scene_5_UIController.sympol.equals("X"))
            yourturn=true;
        else
        { yourturn=false;}

        btnGroup.add(btn0);
        btnGroup.add(btn1);
        btnGroup.add(btn2);
        btnGroup.add(btn3);
        btnGroup.add(btn4);
        btnGroup.add(btn5);
        btnGroup.add(btn6);
        btnGroup.add(btn7);
        btnGroup.add(btn8);
        Font font = Font.font("Courier New", FontWeight.BOLD, 19);
        symbol.setText("you are "+Scene_5_UIController.sympol);
        symbol.setFont(font);


        try{
            dis = new DataInputStream(controller1.mySocket.getInputStream ());
            ps = new PrintStream(controller1.mySocket.getOutputStream ());
        }   catch(IOException ex)
        {
            ex.printStackTrace();
        }
        username=scene3controller.username;
player1.setText("you");
player2.setText(Scene_5_UIController.enemy);
        th.start();
        btn0.fire();


    }


    @FXML
    void btnAction(ActionEvent event) throws IOException {



        if(count!=0)
        {
            if(yourturn==true){
                int buttonChecker = 0;
                Button x = (Button) (event.getSource());
                for (int i = 0; i < 9; i++)
                {
                    if (btnGroup.get(i) == x)
                    {
                        buttonChecker = i;
                    }
                }
                if (btnused[buttonChecker] == 0) {
                    //counter++;
                    btnGroup.get(buttonChecker).setText(Scene_5_UIController.sympol);
                    th.suspend();
                    ps.println("inGame*"+buttonChecker);
                    th.resume();
                    btnGroup.get(buttonChecker).setTextFill(Color.rgb(255, 49, 72));
                    btnused[buttonChecker] = 1;
                    btnGroup.get(buttonChecker).setStyle("-fx-background-color:#3b3b3b");


                }
                else{return;}

            }
        }
        if(count==0)
        {th.suspend();
            ps.println("inGame*"+9);
            th.resume();
        }


        if(count!=0)
        {
            
            yourturn=false;
            gameLogic();
        }
        count++;

    }

    @FXML
    void playAgainAction(ActionEvent event) throws IOException {




    }

    @FXML
    void restartGame(ActionEvent event) {


    }

     @FXML
    void goback(ActionEvent event) throws IOException {
            th.suspend();
            ps.println("inGame*back");
            
 root = FXMLLoader.load(getClass().getResource("Scene_6_UI.fxml"));
stage=(Stage)onGameEndLabel.getScene().getWindow();
scene=new Scene(root);
stage.setScene(scene);
stage.show();

    }
 public  Thread th= new Thread(new Runnable()
    {
        public void run()
        {
            while(true){
                try{
                    server=dis.readLine();

                }
                catch(IOException ex)
                {System.out.println("addd7a"); }

                if(server.equals("back")){
                        Platform.runLater(new Runnable() {
                                           @Override public void run() {

                                                    try{
                                                       enemyquit();
                                                    }catch(IOException ex){}
                                           }
                                       });
                                    
                                    }

                Platform.runLater(new Runnable() {
                    @Override public void run() {


                        toenemyturn(server);

                    }
                });
            }
        }

    });

 void enemyquit() throws IOException{
th.suspend();
refuse = new Alert(Alert.AlertType.INFORMATION," PLAYER Quit");
                refuse.show();
 root = FXMLLoader.load(getClass().getResource("Scene_6_UI.fxml"));
stage=(Stage)onGameEndLabel.getScene().getWindow();
scene=new Scene(root);
stage.setScene(scene);
stage.show();

}

    void toenemyturn(String server){
//String stringnumber=server.split("\\*")[1];


        int  number = Integer.parseInt(server);
        System.out.println(number);
        if(number<9)
        {
            btnused[number] = 1;
            if(Scene_5_UIController.sympol.equals("X"))
            {
                btnGroup.get(number).setText("O");
                btnGroup.get(number).setTextFill(Color.rgb(100,255,49));
                btnGroup.get(number).setStyle("-fx-background-color:#3b3b3b");

            }
            else
            {
                btnGroup.get(number).setText("X");
                btnGroup.get(number).setTextFill(Color.rgb(100,255,49));
                btnGroup.get(number).setStyle("-fx-background-color:#3b3b3b");
            }

            yourturn=true;
            gameLogic();

        }
        /*if(number==100)
                {}*/
    }



////////////////////////////////////////////////////////////////////
private void gameLogic()
{
    b0=btn0.getText();
    b1=btn1.getText();
    b2=btn2.getText();
    b3=btn3.getText();
    b4=btn4.getText();
    b5=btn5.getText();
    b6=btn6.getText();
    b7=btn7.getText();
    b8=btn8.getText();

    if(boardWin != true) {
        if ((b0 + b1 + b2).equalsIgnoreCase("XXX") || (b0 + b1 + b2).equalsIgnoreCase("OOO"))
        {
            if ((b0 + b1 + b2).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn0, btn1, btn2);
            boardWin =true;

        }
        if ((b3 + b4 + b5).equalsIgnoreCase("XXX") || (b3 + b4 + b5).equalsIgnoreCase("OOO"))
        {
            if ((b3 + b4 + b5).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn3, btn4, btn5);
            boardWin =true;

        }
        if ((b6 + b7 + b8).equalsIgnoreCase("XXX") || (b6 + b7 + b8).equalsIgnoreCase("OOO"))
        {
            if ((b6 + b7 + b8).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn6, btn7, btn8);
            boardWin =true;

        }
        if ((b0 + b3 + b6).equalsIgnoreCase("XXX") || (b0 + b3 + b6).equalsIgnoreCase("OOO"))
        {
            if ((b0 + b3 + b6).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn0, btn3, btn6);
            boardWin =true;

        }
        if ((b1 + b4 + b7).equalsIgnoreCase("XXX") || (b1 + b4 + b7).equalsIgnoreCase("OOO"))
        {
            if ((b1 + b4 + b7).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn1, btn4, btn7);
            boardWin =true;

        }
        if ((b2 + b5 + b8).equalsIgnoreCase("XXX") || (b2 + b5 + b8).equalsIgnoreCase("OOO"))
        {
            if ((b2 + b5 + b8).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn2, btn5, btn8);
            boardWin =true;

        }
        if ((b0 + b4 + b8).equalsIgnoreCase("XXX") || (b0 + b4 + b8).equalsIgnoreCase("OOO"))
        {
            if ((b0 + b4 + b8).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn0, btn4, btn8);
            boardWin =true;
        }
        if ((b2 + b4 + b6).equalsIgnoreCase("XXX") || (b2 + b4 + b6).equalsIgnoreCase("OOO"))
        {
            if ((b2 + b4 + b6).equalsIgnoreCase("XXX")) {
                screenEffectForX();
            } else {
                screenEffectForO();
            }
            buttonEffect(btn2, btn4, btn6);
            boardWin =true;

        }
    }
    if(btnused[0]==1 && btnused[1]==1 && btnused[2]==1 && btnused[3]==1 && btnused[4]==1 &&
            btnused[5]==1 && btnused[6]==1 && btnused[7]==1 && btnused[8]==1 && !boardWin)
    {
        onGameEndLabel.setText("Draw!\n");
        onGameEndLabel.setFont(new Font(60));
        onGameEndLabel.setVisible(true);
        onGameEndPane.setVisible(true);


    }

}
    private void buttonEffect(Button a, Button b, Button c)
    {
        a.setStyle("-fx-background-color:#1bb4da");
        b.setStyle("-fx-background-color:#1bb4da");
        c.setStyle("-fx-background-color:#1bb4da");
    }
    private void screenEffectForO()
    {
        if(sympol.equals("O"))
                {
                th.suspend();
                ps.println("win");
                th.resume();
        }
        Ocount++;
        score();
        onGameEndLabel.setText("O Has Won!\n");
        onGameEndLabel.setFont(new Font(60));
        onGameEndLabel.setVisible(true);
        onGameEndPane.setVisible(true);


    }

    private void screenEffectForX()
    {
        if(sympol.equals("X"))
{
th.suspend();
ps.println("win");
th.resume();
}
        Xcount++;
        score();
        onGameEndLabel.setText("X Has Won\n");
        onGameEndLabel.setFont(new Font(60));
        onGameEndLabel.setVisible(true);
        onGameEndPane.setVisible(true);


    }
    private void score()
    {
        scoreX.setText(String.valueOf(Xcount));
        scoreO.setText(String.valueOf(Ocount));
    }

}



