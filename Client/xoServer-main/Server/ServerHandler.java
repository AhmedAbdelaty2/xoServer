import  java.io.*;
import java.net.*;
import java.util.Vector;

class ServerHandler extends Thread
{
    DBConnection db;
    DataInputStream dis;
    PrintStream ps;
    String handle;
    Socket playerSocket;
    static Vector<ServerHandler> loggedPlayers = new Vector<>();
    static String loggedNames;
    String playerName, playerScore;
    static String player1name, player2name;
    int sessionNum = 1;
    boolean serverFlag = false;

    public ServerHandler(Socket cs, DBConnection db1)
    {
        try{
            playerSocket=cs;
            db = db1;
            dis = new DataInputStream(playerSocket.getInputStream());
            ps= new PrintStream(playerSocket.getOutputStream());
            start();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try{
                String inData= dis.readLine();
                String state = inData.split("\\*")[0];

                //if(serverFlag){
                    switch(state){
                        case "signIn":{
                            signInHandler(inData);
                            getNames();
                            break;
                        }

                        case "signUp":{
                            signUpHandler(inData);
                            break;
                        }

                        case "names":{
                            getNames();
                            break;
                        }

                        case "exit":{
                            remv(inData.split("\\*")[1]);
                            getNames();
                            break;
                        }

                        case "multi":{
                            invite(inData);
                            break;
                        }

                        case "reply":
                            handleRequest(inData.split("\\*")[1]);
                            break;
                    }
                //}
            }catch(IOException ex){
                //ex.printStackTrace();
                //System.out.println("h");
                loggedPlayers.remove(this);
                break;
                
            }
        }
    }

    void signInHandler(String data){
        String[] arrData = data.split("\\*");

        try{
            boolean falg = true;
            if (loggedPlayers.isEmpty()){
                handle = db.signIn(arrData[1], arrData[2]);
            }else{
                for (ServerHandler s : loggedPlayers){
                    if (s.playerName.equals(arrData[1])){
                        handle = "dublicated";
                        falg = false;
                        break;  
                    } 
                }
                if(falg)
                    handle = db.signIn(arrData[1], arrData[2]);
            }

            switch (handle){
                case "pass":
                    this.playerName = arrData[1];
                    this.playerScore = db.getScore(this.playerName);
                    loggedPlayers.add(this);
                    ps.println("ldone*"+playerName+"*"+playerScore);

                    /*for(ServerHandler s : loggedPlayers){
                        System.out.println(s.playerName);
                    }*/
                    break;
                case "wrongPass":
                    ps.println("wrong");
                    break;
                case "dublicated":
                    ps.println("dublicated");
                    break;
                case "wrongName":
                    ps.println("wrong");
                    break;
            }
        }catch(ArrayIndexOutOfBoundsException AI){
            ps.println("wrong");
        } 
    }

    void signUpHandler(String data){
        String[] arrData = data.split("\\*");
        System.out.println(arrData[0]);

        try{
            if (db.signUp(arrData[1], arrData[2], arrData[3])){
                this.playerName = arrData[1];
                //this.playerScore = db.getScore(this.playerName);
                loggedPlayers.add(this);
                ps.println("done");
            }else{
                ps.println("failed");
            }
        }catch(ArrayIndexOutOfBoundsException AI){
            ps.println("wrong");
        }   
    }

    void getNames(){
        loggedNames = "onlinepeople";

        for(ServerHandler s : loggedPlayers)
            loggedNames += "*"+s.playerName;
        
        System.out.println(loggedNames);
        for(ServerHandler s : loggedPlayers)
            s.ps.println(loggedNames);

            
    }

    static void remv(String name) throws IOException{
        for(ServerHandler s : loggedPlayers){
            if(s.playerName.equals(name)){
                loggedPlayers.remove(s);
                break;
            }
        for(ServerHandler s1 : loggedPlayers){
            System.out.println(s1.playerName+s1.playerSocket);
        }
        }
    }

    void invite(String data) throws IOException{
        String[] receivedData = data.split("\\*");
        player1name = receivedData[1];
        player2name = receivedData[2];
        for(ServerHandler s : loggedPlayers){
            if(s.playerName.equals(player2name)){
                s.ps.println("request*"+player1name);
            }
        }
    }
    
    private void handleRequest(String req){
        switch (req){
            case "ok":
                for(ServerHandler s : loggedPlayers){
                    if(s.playerName.equals(player1name)){
                        s.ps.println("start*"+player2name+"*"+player1name);
                    }
                }
             startGame();
                break;
            case "refused":
                for(ServerHandler s : loggedPlayers){
                    if(s.playerName.equals(player1name)){
                        s.ps.println("refused*");
                    }
                }
                break;
        }
    }

    void startGame(){
        Socket socket1 = null;
        Socket socket2 = null;
        for (ServerHandler s: loggedPlayers) {
            if (s.playerName.equals(player1name)) {
                socket1 = s.playerSocket;
            }
        }
        System.out.println(socket1);
        
        for (ServerHandler s : loggedPlayers) {
            if (s.playerName.equals(player2name)) {
                socket2 = s.playerSocket;
            }
        }
        System.out.println(socket2);
        
        Game game = new Game(socket1, socket2);
    }

}
