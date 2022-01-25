import java.sql.* ;
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
            stmt = con.prepareStatement("select * from players where username=?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if(rs.next()){
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
            stmt.setString(4, "0");
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
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
    
}