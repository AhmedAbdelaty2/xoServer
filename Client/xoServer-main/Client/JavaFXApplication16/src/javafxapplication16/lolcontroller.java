package javafxapplication16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class lolcontroller implements Initializable{

    @FXML
    private Label scoreX;

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

    @FXML
    private Pane onGameEndPane;

    @FXML
    private Label onGameEndLabel;
String username;
String symbol;
 private DataInputStream dis ;
          private PrintStream ps;

public void initialize(URL url, ResourceBundle rb) {
username=scene3controller.username;
/*try
                {
                    
                    dis = new DataInputStream(controller1.mySocket.getInputStream ());
                    ps = new PrintStream(controller1.mySocket.getOutputStream ());
                  symbol=dis.readLine();
System.out.println(symbol);
                     ps.println("symbol");
                    symbol=dis.readLine();
                    
                   

                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
System.out.println(symbol);*/
}

    @FXML
    void btnAction(ActionEvent event) {

    }

    @FXML
    void playAgainAction(ActionEvent event) {

    }

    @FXML
    void restartGame(ActionEvent event) {

    }

    @FXML
    void tologin(ActionEvent event) {

    }

}
