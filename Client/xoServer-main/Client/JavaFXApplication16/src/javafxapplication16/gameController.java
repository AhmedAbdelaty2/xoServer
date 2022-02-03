package javafxapplication16;

import javafx.fxml.Initializable;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class gameController implements Initializable {
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    private int turn =2;

    public void setTurn() {
        this.turn = 2;
    }
    public boolean boardWin = false;

    public int[] btnused={0,0,0,0,0,0,0,0,0};
    public boolean btnCheck = false;
    public ArrayList<Button>btnGroup = new ArrayList<>();
    private Button btn;
    private int Xcount=0;
    private int Ocount=0;
    @FXML
    private Label scoreX;
    @FXML
    private Label scoreO;
    @FXML
    private Button playAgain;
    @FXML
    private Button restartGame;
    @FXML
    private Label onGameEndLabel;
    @FXML
    private Pane onGameEndPane;
    private String b0;
    private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String b6;
    private String b7;
    private String b8;
    Component parentComponent = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnGroup.add(btn0);
        btnGroup.add(btn1);
        btnGroup.add(btn2);
        btnGroup.add(btn3);
        btnGroup.add(btn4);
        btnGroup.add(btn5);
        btnGroup.add(btn6);
        btnGroup.add(btn7);
        btnGroup.add(btn8);
    }
    @FXML
    private void btnAction (ActionEvent event) {
        int buttonChecker=0;
        Button x = (Button)(event.getSource());
        for(int i = 0;i<9;i++)
        {
            if (btnGroup.get(i) == x)
            { buttonChecker = i; }
        }
        if (btnused[buttonChecker] == 0) {
            if (turn % 2 == 0) {
                turn++;
                btnGroup.get(buttonChecker).setText("X");
                btnGroup.get(buttonChecker).setTextFill(Color.rgb(255, 49, 72));
                btnused[buttonChecker] = 1;
                btnGroup.get(buttonChecker).setStyle("-fx-background-color:#3b3b3b");
            } else {
                turn++;
                btnGroup.get(buttonChecker).setText("O");
                btnGroup.get(buttonChecker).setTextFill(Color.rgb(255, 49, 72));
                btnGroup.get(buttonChecker).setStyle("-fx-background-color:#3b3b3b");
                btnused[buttonChecker] = 1;
            }
            gameLogic();
        }

    }

    public void tologin(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Scene_1_UI.fxml"));
        stage=(Stage)scoreX.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void screenEffectForO()
    {
        Ocount++;
        score();
        onGameEndLabel.setText("O Has Won!\n" + "Press Play Again to Restart!");
        onGameEndLabel.setFont(new Font(30));
        onGameEndLabel.setVisible(true);
        onGameEndPane.setVisible(true);
    }

    private void screenEffectForX()
    {
        Xcount++;
        score();
        onGameEndLabel.setText("X Has Won!\n" + "Press Play Again to Restart!");
        onGameEndLabel.setFont(new Font(30));
        onGameEndLabel.setVisible(true);
        onGameEndPane.setVisible(true);
    }
    private void buttonEffect(Button a, Button b, Button c)
    {
        a.setStyle("-fx-background-color:#1bb4da");
        b.setStyle("-fx-background-color:#1bb4da");
        c.setStyle("-fx-background-color:#1bb4da");
    }
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
            onGameEndLabel.setText("Draw!\n" + "Press Play Again to Restart!");
            onGameEndLabel.setFont(new Font(30));
            onGameEndLabel.setVisible(true);
            onGameEndPane.setVisible(true);
        }

    }
    private void score()
    {
        scoreX.setText(String.valueOf(Xcount));
        scoreO.setText(String.valueOf(Ocount));
    }
    private void onGameReset()
    {
        boardWin=false;
        for (int i =0; i<9;i++)
        {
            btnused[i]=0;
            btnGroup.get(i).setText("");
            btnGroup.get(i).setStyle(null);
            btnGroup.get(i).getStylesheets().add("HoverButtonsGrid.css");

        }
        onGameEndLabel.setVisible(false);
        onGameEndPane.setVisible(false);

    }
    @FXML
    void restartGame(ActionEvent event)
    {
        onGameReset();
    }
    @FXML
    private void playAgainAction(ActionEvent event)
    {
        onGameReset();
    }

}
