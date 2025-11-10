import java.time.*;
import java.util.ArrayList;

public class Server {
    int port;
    static ArrayList<Client> list = new ArrayList<Client>();

    public void server(int port){
        this.port = port;
    }

    private void storeClient(Client c){
        list.add(c);
    }

    public void disconnect(){

    }

    public int getConnectedTimes(){
        LocalDateTime time ;
        

        return;
    }
}
