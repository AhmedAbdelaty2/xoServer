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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root","Leavetheduckalone22");



            
            
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
    boolean signUp(String name, String psw) {
        try {
            stmt = con.prepareStatement("insert into player(username,password) values(? ,?)");
            stmt.setString(1, name);
            stmt.setString(2, psw);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}