import java.net.*;

public class ipClient2{
    public static void main(String arg[]){
        try{
            InetAddress IA = InetAddress.getByName("noobra");
            System.out.println("The IP Address of Client: "+ IA);
        }
        catch(Exception e){
            System.out.println("The Exception occure: "+ e);
        }
    }
}