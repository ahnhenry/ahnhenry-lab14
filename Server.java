import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.*;
import java.util.ArrayList;

public class Server {
    private int port;
    private ServerSocket serverSock;
    private static ArrayList<LocalDateTime> timelist = new ArrayList<LocalDateTime>();


    public Server(int port) throws IOException{
        this.port = port;
        this.serverSock = new ServerSocket(this.port);
   
    }


    public void disconnect(){
        try{
            if(serverSock != null){
                serverSock.close();
            }
        }
        catch(Exception e){
            
        }
    }

    public ArrayList<LocalDateTime> getConnectedTimes(){
        return timelist;
    }

    public void serve(int number) throws IOException{
       //System.out.println("Current timelist size: " + timelist.size());
        timelist.clear();
        for(int i = 0; i < number; i++){

                Socket clientSock = serverSock.accept();
        
        
                timelist.add(LocalDateTime.now());
                new ClientHandler(clientSock).start();
                
        }
    }

}
