
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    private String address;
    private int port;
    private Socket sock;
    private PrintWriter out;
    private BufferedReader in;
    
    public Client(String address, int port) throws IOException{
        this.address = address;
        this.port = port;
        try{
            this.sock = new Socket(address, port);
            this.out = new PrintWriter(sock.getOutputStream());
            this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }




    }

    public void handshake(){
        //send a password 
        //if password wrong => disconnect
        // else open a thread 
        //sends an integer to server 

        out.println("12345");
        out.flush();
    
    }

    public String request(String number) throws IOException{
        out.println(number);
        out.flush();

        return in.readLine();
    }

    public void disconnect(){
        try{
            sock.close();}
            catch(IOException e){
                System.out.println("could not disconnect socket: "+sock.getRemoteSocketAddress());
            }
    }


    public Socket getSocket(){
        return sock;
    }
}