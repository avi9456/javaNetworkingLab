import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket SS;
    private Socket client;
    private DataInputStream read;
    private PrintStream write;
    private String msg,ip;
    Server(int portNum)throws IOException{
        SS = new ServerSocket(portNum);
    }
    Server() throws IOException{
        this(6969);
    }
    private void clientInfo(){
        System.out.println("Connected client: "+ip);
    }
    private void con() throws IOException{
        client = SS.accept();
        read = new DataInputStream(client.getInputStream());
        write = new PrintStream(client.getOutputStream(),true);
        ip = read.readLine();
        clientInfo();
    }
    private void echo() throws IOException{
        for(int i= 0;i<3;i++){
            msg = read.readLine();
            if(msg!=null){
                System.out.println(ip+"> "+msg);
                write.println(msg);
            }
        }
        client.close();
    }
    public static void main(String arg[]) throws IOException{
        Server server;
        if(arg.length > 0){
            server = new Server(Integer.parseInt(arg[0]));
        }
        else{
            server = new Server(6969);
        }

            server.con();
            server.echo();
        
    }

}