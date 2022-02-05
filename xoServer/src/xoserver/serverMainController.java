
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
package xoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.mysql.cj.MysqlConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class serverMainController implements Initializable{
    Server s = new Server();
    boolean flag = false;   
    String all; 
    private Stage stage;
    private Scene scene;
    private Parent root;  

    @FXML
    private Button startServerButton;

    @FXML
    private Button stopServerButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Button goBackButton;

    @FXML
        private TableView<Player> Table;

    @FXML
    private TableColumn<Player, String> userName;

    @FXML
    private TableColumn<Player, Integer> points;

    @FXML
    private TableColumn<Player, String> status;

    @FXML
    private TableColumn<Player, String> isPlaying;

    ObservableList<Player> listM;
 

        

    @FXML
    void goBack(ActionEvent event) throws Exception{
    //s.stop();
    s.serverSocket.close();
    root = FXMLLoader.load(getClass().getResource("Server_1.fxml"));
    stage=(Stage)goBackButton.getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();

    }

    @FXML
    void refreshServer(ActionEvent event) {
        updateTable();
    }

    @FXML
    void startServer(ActionEvent event) {
    if(!flag){
        s.start();
        flag = true;
    }else{
        s.resume();
    }
}
    

    

    @FXML
    void stopServer(ActionEvent event) {
    if(flag){
        s.suspend();
        System.out.println("close2");
    }

    }
    
    public void updateTable(){
        userName.setCellValueFactory(new PropertyValueFactory<>("username"));
        points.setCellValueFactory(new PropertyValueFactory<>("points"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        isPlaying.setCellValueFactory(new PropertyValueFactory<>("email"));
        listM = Server.db.getAll();
        Table.setItems(listM);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        updateTable();
    }
}


