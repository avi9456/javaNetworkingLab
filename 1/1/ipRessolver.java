import java.net.*;
import java.io.*;

public class ipRessolver{
    private InetAddress IA;
    ipRessolver(String url){
        try{
            IA = InetAddress.getByName(url);
        }
        catch(Exception e){
            System.out.println("The Exception occure: "+e);
        }
    }
    ipRessolver(){
        try{
            IA = InetAddress.getLocalHost();
        }
        catch(Exception e){
            System.out.println("The Exception occure: "+e);
        }
    }
    private void show(){
        System.out.println("Host Name: "+ IA.getHostName());
        System.out.println("IP Address: "+ IA.getHostAddress());
    }
    public static void main(String arg[]){
        ipRessolver IPR;
        if(arg.length>0){
            IPR = new ipRessolver(arg[0]);
        }
        else{
            IPR = new ipRessolver();
        }
        
        IPR.show();
    }
}