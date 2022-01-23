import  java.io.*;
import java.net.*;
import java.util.Vector;

public class Server
{
    static DBConnection db;
    ServerSocket serverSocket;
    public Server()
    {
        try
        {
            serverSocket= new ServerSocket(5002);
            while(true)
            {
                Socket s = serverSocket.accept();
                new ServerHandler(s);
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        db = new DBConnection();
        new Server();
    }

    
}