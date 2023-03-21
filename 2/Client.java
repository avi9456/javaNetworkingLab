import java.net.*;
import java.io.*;

public class Client{
    public static void main(String arg[]){
        Socket S;
        DataInputStream dis;
        String date;
        try{
            InetAddress IA = InetAddress.getLocalHost();
            S = new Socket(IA,6969);
            System.out.println(IA);
            dis = new DataInputStream(S.getInputStream());
            PrintStream ps = new PrintStream(S.getOutputStream());
            date = dis.readLine();
            ps.println(IA.getHostAddress());    
            System.out.println("The Date in the Server: "+date);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}