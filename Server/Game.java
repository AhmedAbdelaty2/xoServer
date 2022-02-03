import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;


public class Game {
    Socket firstPlayer, secondPlayer;

    public Game(Socket s1, Socket s2){
        firstPlayer = s1;
        secondPlayer = s2;
    }

    public void run() {
        try {
            /*datainputstream*/
            DataInputStream fromPlayer1 = new DataInputStream(firstPlayer.getInputStream());
            PrintStream toPlayer1 = new PrintStream(firstPlayer.getOutputStream());
            DataInputStream fromPlayer2 = new DataInputStream(secondPlayer.getInputStream());
            PrintStream toPlayer2 = new PrintStream(secondPlayer.getOutputStream());

            while(true){
                String p1 = fromPlayer1.readLine();
                String p2 = fromPlayer2.readLine();

                switch(p1){
                    case "symbol":
                    toPlayer1.println('X');
                }
                switch(p2){
                    case "symbol":
                    toPlayer1.println('O');
                }
            }
        }catch(IOException ex){
            System.err.println("ex");
        }
    }
}