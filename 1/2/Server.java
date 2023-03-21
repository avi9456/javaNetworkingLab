import java.net.*;
import java.io.*;

public class Server{
    public static void main(String arg[]){
        ServerSocket SS;
        Socket S;
        DataInputStream dis;
        String ip;
        try{
            if(arg.length>0){
                SS = new ServerSocket(Integer.parseInt(arg[0]));
            }else{
                SS = new ServerSocket(6969);
            }
            while(true){
                S = SS.accept();
                System.out.println(S);
                dis = new DataInputStream(S.getInputStream());
                ip = dis.readLine();
                System.out.println("IP Address of Client: "+ ip);
            }
        }
        catch(IOException ioe){
            System.out.println("Exception occure: "+ioe);
        }
    }
}