import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.*;
import java.util.ArrayList;

public class Server {
    private int port;
    private ServerSocket serverSock;
    private LocalDateTime time;
    private static ArrayList<LocalDateTime> timelist = new ArrayList<LocalDateTime>();


    public Server(int port) throws IOException{
        this.port = port;

        try{
            this.serverSock = new ServerSocket(this.port);
        }catch(IOException e){
            System.err.println("Cannot establish server socket");
            System.exit(1);
        }  
        
        
        
        
    }


    public void disconnect(){
        try{
            serverSock.close();
        }
        catch(Exception e){
            System.out.println("could not disconnect socket: "+ serverSock.getLocalSocketAddress());
        }
    }

    public ArrayList<LocalDateTime> getConnectedTimes(){
        return timelist;
    }

    public void serve(int number) throws IOException{

        for(int i = 0; i < number; i++){
                Socket clientSock = serverSock.accept();
                time = LocalDateTime.now();
                timelist.add(time);
                new ClientHandler(clientSock).start();
        }
    }

}
