import java.net.*;
import java.io.*;

public class Client{
    public static void main(String arg[]){
        Socket S;
        PrintStream ps;
        InetAddress IA;
        try{
            IA = InetAddress.getLocalHost();
            if(arg.length > 0){
                S = new Socket(IA,Integer.parseInt(arg[0]));
            }
            else{
                S = new Socket(IA,6969);
            }
            System.out.println(S);
            ps = new PrintStream(S.getOutputStream());
            ps.println(IA);
        }
        catch(IOException ioe){
            System.out.println("Exception occure: "+ioe);
        }
    }
}