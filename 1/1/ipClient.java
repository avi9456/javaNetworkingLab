import java.net.*;
import java.io.*;

public class ipClient{
    public static void main(String arg[]){
        try{
            InetAddress IA = InetAddress.getLocalHost();
            System.out.println("The IP Address of Client: "+IA.getHostAddress());
        }
        catch(Exception e){
            System.out.println("Exception occure: "+ e);
        }
    }
}