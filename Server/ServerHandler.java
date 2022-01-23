import  java.io.*;
import java.net.*;
import java.util.Vector;

class ServerHandler extends Thread
{
    DBConnection db;
    DataInputStream dis;
    PrintStream ps;
    String handle;
    static Vector<ServerHandler> loggedPlayers = new Vector<ServerHandler>();
    String PlayerName, PlayerScore;

    public ServerHandler(Socket cs)
    {
        try
        {
            dis = new DataInputStream(cs.getInputStream());
            ps= new PrintStream(cs.getOutputStream());
            start();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void run()
    {
        while(true)
        {
            try
            {
                String inData= dis.readLine();
                String state = inData.split("\\.")[0];

                switch(state){
                    case "signIn":{
                        signInHandler(inData);
                        break;
                    }

                    case "signUp":{
                        signUpHandler(inData);
                        break;
                    }

                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    void signInHandler(String data) {
        String[] arrData = data.split("\\.");

        try {
            if (loggedPlayers.isEmpty()) {
                handle = db.signIn(arrData[1], arrData[2]);
            } else {
                for (ServerHandler s : loggedPlayers) {
                    if (!(s.PlayerName.equals(arrData[1]))) {
                        handle = db.signIn(arrData[1], arrData[2]);
                    } else {
                        handle = "dublicated";
                    }
                }
            }

            switch (handle) {
                case "pass":
                    ps.println("Pass. "+arrData[1]);
                    this.PlayerName = arrData[1];
                    //this.PlayerScore = db.getScore(this.PlayerName);
                    loggedPlayers.add(this);
                    break;
                case "wrongPass":
                    ps.println("wrongPass.");
                    break;
                case "dublicated":
                    ps.println("dublicated.");
                    break;
                case "wrongName":
                    ps.println("wrongName.");
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException AI) {
            ps.println("wrongName.");
        } 
    }

    public void signUpHandler(String data) {
        String[] arrData = data.split("\\.");

        try {
            if (db.signUp(arrData[1], arrData[2])) {
                ps.println("done "+arrData[1]);
                this.PlayerName = arrData[1];
                //this.PlayerScore = db.getScore(this.PlayerName);
                loggedPlayers.add(this);
            } else {
                ps.println("failed");
            }
        } catch (ArrayIndexOutOfBoundsException AI) {
            ps.println("wrongName.");
        } 
    }
}

