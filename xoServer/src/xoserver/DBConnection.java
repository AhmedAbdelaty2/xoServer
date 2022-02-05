package xoserver;

import java.sql.* ;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.*;



public class DBConnection
{
    PreparedStatement stmt;
    ResultSet rs;
    Connection con;

    public DBConnection()
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe1", "root","Leavetheduckalone22");
            System.out.println("connected");



            
            
        }
        catch(SQLException ex)
        {
                ex.printStackTrace();
        }

        
    }

    String signIn(String name, String psw){
        try{
            stmt = con.prepareStatement("update players set status='1' where username=?");
            //stmt.setString(1, "online");
            stmt.setString(1, name);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("select * from players where username=?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if(rs.next()){
                System.out.println("in bd"+rs.getString(3)+"inpas="+psw);
                if(rs.getString(3).equals(psw))
                    return "pass";
                else
                    return "wrongPass";
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return "wrongName";
    }
    boolean signUp(String name,String email ,String psw) {
        try {
            stmt = con.prepareStatement("insert into players(username, email, password, status) values(?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, psw);
            stmt.setString(4, "1");
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    void exit(String name){
        try{
            stmt = con.prepareStatement("update players set status='0' where username=?");
            stmt.setString(1, name);
            stmt.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        } 
    }

    String getScore(String playerName){
        try{
            stmt = con.prepareStatement("select * from players where username=?");
            stmt.setString(1, playerName);
            rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getString(5);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return null;
        
    }

    void updatescore(String name, int score) {
        try {

            stmt = con.prepareStatement("update players set points=? where username=?");
            stmt.setString(1, String.valueOf(score));
            stmt.setString(2, name);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    ObservableList<Player> getAll()
    {
        ObservableList<Player> list = FXCollections.observableArrayList();
        //String all = "";
        try{
            stmt = con.prepareStatement("select username,points,status,email from players");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                list.add(new Player(rs.getString("username"),Integer.parseInt(rs.getString("points")),rs.getString("status"),rs.getString("email")));
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}