import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;


public class Game extends Thread{
    Socket firstPlayer, secondPlayer;


    public Game(Socket s1, Socket s2){
        firstPlayer = s1;
        secondPlayer = s2;
        start();
    }
    
    public void run() {
        try {
            /*datainputstream*/
            DataInputStream fromPlayer1 = new DataInputStream(firstPlayer.getInputStream());
            PrintStream toPlayer1 = new PrintStream(firstPlayer.getOutputStream());
            DataInputStream fromPlayer2 = new DataInputStream(secondPlayer.getInputStream());
            PrintStream toPlayer2 = new PrintStream(secondPlayer.getOutputStream());

            while(true){
                System.out.println(firstPlayer);
                toPlayer1.println("lol");
                String p1 = fromPlayer1.readLine();
                System.out.println(p1);
                

                switch(p1){
                    case "symbol":
                    toPlayer1.println('X');
                }
                String p2 = fromPlayer2.readLine();
                System.out.println(p2);
                switch(p2){
                    case "symbol":
                    toPlayer2.println('O');
                }
            }
        }catch(IOException ex){
            System.err.println("ex");
        }
    }

}