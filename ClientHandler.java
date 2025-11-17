import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket sock;

    public ClientHandler(Socket sock){
        this.sock=sock;
    }

    // public int factor(long num){
        

    //     return count;
    // }

    public void run(){
        PrintWriter out = null;
        BufferedReader in = null;

        try{
            out = new PrintWriter(sock.getOutputStream());
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String input = in.readLine();

            if(!(input.equals("12345"))){
                out.println("couldn't handshake");
                out.flush();
                sock.close();
                return;
            }

            String serveNum = in.readLine();
            long num = 0;

            try{
                num = Long.parseLong(serveNum);
            }catch(Exception e){
                System.out.println("There was an exception on the server");
                
            }

            if(num > 2147483642 || num == 0){
                out.println("There was an exception on the server");
                out.flush();
                return;
            }

            int count = 0;
            for(int i = 1; i <= num; i++){
                if(num % i == 0){
                    count++; 
                }
            }

            out.println("The number " + num + " has " + count + " factors");
            out.flush();
            sock.close();



        }catch(Exception e){
            System.out.println("Connection lost: "+sock.getRemoteSocketAddress());
            e.printStackTrace();
        }
    }
}
