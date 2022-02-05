package xoserver;

import  java.io.*;
import java.net.*;
import java.util.Vector;

public class Server extends Thread
{
    static DBConnection db;
    ServerSocket serverSocket;
    public Server() 
    {
        try
        {
            serverSocket= new ServerSocket(5005);
            db = new DBConnection();
            //start();
            /*while(true)
            {
                Socket s = serverSocket.accept();
                new ServerHandler(s, db);
            }*/
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void run(){
        try{
System.out.println("lol");
        while(true){
            Socket s = serverSocket.accept();
            new ServerHandler(s, db);
            }
        
        }catch(IOException ex){
        ex.printStackTrace();
        }

        }
    }
    
