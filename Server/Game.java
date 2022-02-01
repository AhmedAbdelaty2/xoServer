import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Game {

    // a board of 9 squares
    private Player[] board = {
            null, null, null,
            null, null, null,
            null, null, null};

    //current player
    Player currentPlayer;

    // winner
    public boolean hasWinner() {
        return (board[0] != null && board[0] == board[1] && board[0] == board[2])
                || (board[3] != null && board[3] == board[4] && board[3] == board[5])
                || (board[6] != null && board[6] == board[7] && board[6] == board[8])
                || (board[0] != null && board[0] == board[3] && board[0] == board[6])
                || (board[1] != null && board[1] == board[4] && board[1] == board[7])
                || (board[2] != null && board[2] == board[5] && board[2] == board[8])
                || (board[0] != null && board[0] == board[4] && board[0] == board[8])
                || (board[2] != null && board[2] == board[4] && board[2] == board[6]);
    }

    // no empty squares
    public boolean boardFilledUp() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) {
                return false;
            }
        }
        return true;
    }

    // thread when player tries a move
    public synchronized boolean legalMove(int location, Player player) {
        if (player == currentPlayer && board[location] == null) {
            board[location] = currentPlayer;
            currentPlayer = currentPlayer.opponent;
            currentPlayer.otherPlayerMoved(location);
            return true;
        }
        return false;
    }

    class Player extends Thread {

        char mark;
        Player opponent;
        Socket socket;
        BufferedReader input;
        PrintWriter output;
        String movement;
        // thread handler to initialize stream fields
        public Player(Socket socket, char mark) {
            this.socket = socket;
            this.mark = mark;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Player left: " + e);
            }
        }

        //Accepts notification of who the opponent is.
        public void setOpponent(Player opponent) {
            this.opponent = opponent;
        }

        //Handles the otherPlayerMoved message.
        public void otherPlayerMoved(int location) {
            output.println("OPPONENT_MOVED " + location);
            output.println(hasWinner() ? "DEFEAT" : boardFilledUp() ? "TIE" : "");
        }

        public void run() {
            try {
                if (mark == 'X') {
                    output.println("your."+movement);
                } else {
                    output.println("your1."+movement);
                }

                // Repeatedly get commands from the client and process them.
                while (true) {
                    String command = input.readLine();
                    System.out.println("reading " + command);
                    if (command.split("\\*")[0].equals("move")) {
                        movement = command.split("\\*")[1];
                        int location = Integer.parseInt(command.split("\\*")[1]);
                        System.out.println(location);
                        if (legalMove(location, this)) {
                            output.println(hasWinner() ? "VICTORY" : boardFilledUp() ? "TIE" : "");
                        } else {
                            output.println("MESSAGE ?");
                        }
                    } else if (command.split("\\*")[0].equals("quit")) {
                        currentPlayer.opponent.output.println("dead");
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            }
        }
    }
}