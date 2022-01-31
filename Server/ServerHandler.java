import  java.io.*;
import java.net.*;
import java.util.Vector;

class ServerHandler extends Thread
{
    DBConnection db;
    DataInputStream dis;
    PrintStream ps;
    String handle;
    static Vector<ServerHandler> loggedPlayers = new Vector<>();
    static String loggedNames;
    String playerName, playerScore;
    static String player1name, player2name;

    public ServerHandler(Socket cs, DBConnection db1)
    {
        try{
            db = db1;
            dis = new DataInputStream(cs.getInputStream());
            ps= new PrintStream(cs.getOutputStream());
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

                switch(state){
                    case "signIn":{
                        signInHandler(inData);
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
                        stop();
                        
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
            }catch(IOException ex){
                //ex.printStackTrace();
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
        loggedNames = "";

        for(ServerHandler s : loggedPlayers)
            loggedNames += s.playerName+"*";
        
        for(ServerHandler s : loggedPlayers)
            s.ps.println(loggedNames);
            
    }

    static void remv(String name){
        for(ServerHandler s : loggedPlayers){
            if(s.playerName.equals(name))
                loggedPlayers.remove(s);
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
                 //startMatch();
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

}

