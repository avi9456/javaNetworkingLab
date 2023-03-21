import java.net.*;
import java.util.*;
import java.io.*;

public class Server{
    public static void main(String arg[]){
        ServerSocket SS;
        Socket S;
        PrintStream ps;
        try{
            SS = new ServerSocket(6969);
            while(true){
                S = SS.accept();
                // System.out.println(S.getLocalSocketAddress());
                ps = new PrintStream(S.getOutputStream());
                Date d = new Date();
                ps.println(d);
                DataInputStream dis = new DataInputStream(S.getInputStream());
                String ipClient = dis.readLine();
                System.out.println("Client : "+ipClient);
                ps.close();
                S.close();
            }
        }
        catch(IOException ioe){
            System.out.println("Exception occure: "+ioe);
        }
    }
}