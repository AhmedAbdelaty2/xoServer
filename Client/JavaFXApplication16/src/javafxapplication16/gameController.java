package javafxapplication16;

import javafx.fxml.Initializable;


import java.awt.Component;
import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    public int[] btnused={0,0,0,0,0,0,0,0,0};
    private Button btn;
    private int Xcount=0;
    private int Ocount=0;
    @FXML
    private Label scoreX;
    @FXML
    private Label scoreO;
    @FXML
    private Button playAgain;


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

    @FXML
    private void btn0Action(ActionEvent event) {
        if(btnused[0]==0){
            if(turn%2==0)
            {
                turn++;
                btn0.setText("X");
//
                btn0.setTextFill(Color.rgb(249, 228, 212));
                btnused[0]=1;



            }else{
                turn++;
                btn0.setText("O");
                btn0.setTextFill(Color.rgb(216, 133, 163));
                btnused[0]=1;

            }
            gameLogic();
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn1Action(ActionEvent event)
    {
        if(btnused[1]==0){
            if(turn%2==0)
            {
                turn++;
                btn1.setText("X");
                btn1.setTextFill(Color.rgb(249, 228, 212));
                btnused[1]=1;

            }else{
                turn++;
                btn1.setText("O");
                btn1.setTextFill(Color.rgb(216, 133, 163));
                btnused[1]=1;

            }
            gameLogic();
        }
        else{

            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn2Action(ActionEvent event)
    {
        if(btnused[2]==0){
            if(turn%2==0)
            {
                turn++;
                btn2.setText("X");
                btn2.setTextFill(Color.rgb(249, 228, 212));
                btnused[2]=1;


            }else{
                turn++;
                btn2.setText("O");
                btn2.setTextFill(Color.rgb(216, 133, 163));
                btnused[2]=1;

            }
            gameLogic();
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn3Action(ActionEvent event)
    {
        if(btnused[3]==0){
            if(turn%2==0)
            {
                turn++;
                btn3.setText("X");
                btn3.setTextFill(Color.rgb(249, 228, 212));
                btnused[3]=1;


            }else{
                turn++;
                btn3.setText("O");
                btn3.setTextFill(Color.rgb(216, 133, 163));
                btnused[3]=1;

            }
            gameLogic();
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn4Action(ActionEvent event)
    {
        if(btnused[4]==0){
            if(turn%2==0)
            {
                turn++;
                btn4.setText("X");
                btn4.setTextFill(Color.rgb(249, 228, 212));
                btnused[4]=1;
                gameLogic();

            }else{
                turn++;
                btn4.setText("O");
                btn4.setTextFill(Color.rgb(216, 133, 163));
                btnused[4]=1;
                gameLogic();
            }
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn5Action(ActionEvent event)
    {
        if(btnused[5]==0){
            if(turn%2==0)
            {
                turn++;
                btn5.setText("X");
                btn5.setTextFill(Color.rgb(249, 228, 212));
                btnused[5]=1;
                gameLogic();

            }else{
                turn++;
                btn5.setText("O");
                btn5.setTextFill(Color.rgb(216, 133, 163));
                btnused[5]=1;
                gameLogic();
            }
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn6Action(ActionEvent event)
    {
        if(btnused[6]==0){
            if(turn%2==0)
            {
                turn++;
                btn6.setText("X");
                btn6.setTextFill(Color.rgb(249, 228, 212));
                btnused[6]=1;
                gameLogic();

            }else{
                turn++;
                btn6.setText("O");
                btn6.setTextFill(Color.rgb(216, 133, 163));
                btnused[6]=1;
                gameLogic();
            }
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn7Action(ActionEvent event)
    {
        if(btnused[7]==0){
            if(turn%2==0)
            {
                turn++;
                btn7.setText("X");
                btn7.setTextFill(Color.rgb(249, 228, 212));
                btnused[7]=1;
                gameLogic();

            }else{
                turn++;
                btn7.setText("O");
                btn7.setTextFill(Color.rgb(216, 133, 163));
                btnused[7]=1;
                gameLogic();
            }
        }
        else{

            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }
    @FXML
    private void btn8Action(ActionEvent event)
    {
        if(btnused[8]==0){
            if(turn%2==0)
            {
                turn++;
                btn8.setText("X");
                btn8.setTextFill(Color.rgb(249, 228, 212));
                btnused[8]=1;
                gameLogic();

            }else{
                turn++;
                btn8.setText("O");
                btn8.setTextFill(Color.rgb(216, 133, 163));
                btnused[8]=1;
                gameLogic();
            }
        }
        else{
            JOptionPane.showMessageDialog(parentComponent,"btn used");
        }
    }

@FXML
   /* private void backtologinAction(ActionEvent event) throws IOException{
        JavaFXApplication16 base=new JavaFXApplication16();
        try {
            base.changeScene("Scene_1_UI.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
public void tologin(ActionEvent event) throws IOException{
                root = FXMLLoader.load(getClass().getResource("Scene_1_UI.fxml"));
               stage=(Stage)scoreX.getScene().getWindow();
               scene=new Scene(root);
               stage.setScene(scene);
               stage.show();



       }






    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        //1st row  X - X - X //
        if( b0.equalsIgnoreCase("X") &&  b1.equalsIgnoreCase("X") && b2.equalsIgnoreCase("X")){

            Xcount++;

            score();
//          btn0.setStyle("-fx-background-color:#C0D8C0");
//          btn1.setStyle("-fx-background-color:#C0D8C0");
//          btn2.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }
        // 2nd row X - X -X  //
        if(b3.equalsIgnoreCase("X") &&  b4.equalsIgnoreCase("X") && b5.equalsIgnoreCase("X")){
            Xcount++;

            score();
//          btn3.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn5.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }
        //3rd row X - X -X //
        if(b6.equalsIgnoreCase("X") &&  b7.equalsIgnoreCase("X") && b8.equalsIgnoreCase("X")){
            Xcount++;
            score();
//          btn6.setStyle("-fx-background-color:#C0D8C0");
//          btn7.setStyle("-fx-background-color:#C0D8C0");
//          btn8.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");

        }



        //1st clmn  X - X - X //
        if(b0.equalsIgnoreCase("X") &&  b3.equalsIgnoreCase("X") && b6.equalsIgnoreCase("X")){
            Xcount++;

            score();
//          btn0.setStyle("-fx-background-color:#C0D8C0");
//          btn3.setStyle("-fx-background-color:#C0D8C0");
//          btn6.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }
        // 2nd clmn X - X -X  //
        if(b1.equalsIgnoreCase("X") &&  b4.equalsIgnoreCase("X") && b7.equalsIgnoreCase("X")){
            Xcount++;

            score();
//          btn1.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn7.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }
        //3rd clumn X - X -X //
        if(b2.equalsIgnoreCase("X") &&  b5.equalsIgnoreCase("X") && b8.equalsIgnoreCase("X")){

            Xcount++;
            score();
            btn2.setStyle("-fx-background-color:#C0D8C0");
            btn5.setStyle("-fx-background-color:#C0D8C0");
            btn8.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }
        // diag X
        //     X
        //         X
        if(b0.equalsIgnoreCase("X") &&  b4.equalsIgnoreCase("X") && b8.equalsIgnoreCase("X")){

            Xcount++;
            score();
//          btn0.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn8.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }

        // diag       X
        //     X
        // X
        if(b2.equalsIgnoreCase("X") &&  b4.equalsIgnoreCase("X") && b6.equalsIgnoreCase("X")){
            Xcount++;
            score();
//            btn2.setBackground(yellow);
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn6.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player one win!!");
        }



        /////////// O//////////

        //1st row  O - O - O //
        if(b0.equalsIgnoreCase("O") &&  b1.equalsIgnoreCase("O") && b2.equalsIgnoreCase("O")){
            Ocount++;
            score();
//          btn0.setStyle("-fx-background-color:#C0D8C0");
//          btn1.setStyle("-fx-background-color:#C0D8C0");
//          btn2.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");

        }
        // 2nd row O - O - O  //
        if(b3.equalsIgnoreCase("O") &&  b4.equalsIgnoreCase("O") && b5.equalsIgnoreCase("O")){
            Ocount++;
            score();
//          btn3.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn5.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }
        //3rd row O - O - O //
        if(b6.equalsIgnoreCase("O") &&  b7.equalsIgnoreCase("O") && b8.equalsIgnoreCase("O")){

            Ocount++;
            score();
//          btn6.setStyle("-fx-background-color:#C0D8C0");
//          btn7.setStyle("-fx-background-color:#C0D8C0");
//          btn8.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }

        //1st clmn  O - O - O//
        if(b0.equalsIgnoreCase("O") &&  b3.equalsIgnoreCase("O") && b6.equalsIgnoreCase("O")){

            Ocount++;
            score();
//          btn0.setStyle("-fx-background-color:#C0D8C0");
//          btn3.setStyle("-fx-background-color:#C0D8C0");
//          btn6.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }
        // 2nd clmn O - O - O  //
        if(b1.equalsIgnoreCase("O") &&  b4.equalsIgnoreCase("O") && b7.equalsIgnoreCase("O")){

            Ocount++;
            score();
//          btn1.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn7.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }
        //3rd clumn O - O - O //
        if(b2.equalsIgnoreCase("O") &&  b5.equalsIgnoreCase("O") && b8.equalsIgnoreCase("O")){

            Ocount++;
            score();
//          btn2.setStyle("-fx-background-color:#C0D8C0");
//          btn5.setStyle("-fx-background-color:#C0D8C0");
//          btn8.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }
        // diag O
        //     O
        //         O
        if(b0.equalsIgnoreCase("O") &&  b4.equalsIgnoreCase("O") && b8.equalsIgnoreCase("O")){

            Ocount++;
            score();
//          btn0.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn8.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }

        // diag       O
        //     O
        // O
        if(b2.equalsIgnoreCase("O") &&  b4.equalsIgnoreCase("O") && b6.equalsIgnoreCase("O")){

            Ocount++;

            score();
//          btn2.setStyle("-fx-background-color:#C0D8C0");
//          btn4.setStyle("-fx-background-color:#C0D8C0");
//          btn6.setStyle("-fx-background-color:#C0D8C0");
            JOptionPane.showMessageDialog(parentComponent,"Player two win!!");
        }
        else if(btnused[0]==1 && btnused[1]==1 && btnused[2]==1 && btnused[3]==1 && btnused[4]==1 && btnused[5]==1 && btnused[6]==1 && btnused[7]==1 && btnused[8]==1)
        {
            JOptionPane.showMessageDialog(parentComponent,"Game Over!");
        }
    }

    private void score()
    {
        scoreX.setText(String.valueOf(Xcount));
        scoreO.setText(String.valueOf(Ocount));

    }
    @FXML
    private void playAgainAction(ActionEvent event)
    {

        btnused[0]=0;
        btn0.setText("");
        btnused[1]=0;
        btn1.setText("");
        btnused[2]=0;
        btn2.setText("");
        btnused[3]=0;
        btn3.setText("");
        btnused[4]=0;
        btn4.setText("");
        btnused[5]=0;
        btn5.setText("");
        btnused[6]=0;
        btn6.setText("");
        btnused[7]=0;
        btn7.setText("");
        btnused[8]=0;
        btn8.setText("");




    }


}
