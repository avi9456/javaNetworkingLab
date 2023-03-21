import java.net.*;

public class testClient{
    public static void main(String arg[]) throws Exception{
        InetAddress IA = InetAddress.getByName("127.0.2.1");
        Socket S = new Socket(IA,9999);
        System.out.println(S);
        System.out.println("My IP Address: "+InetAddress.getLocalHost());
        System.out.println("InetAddress object : "+IA);
        System.out.println("InetAddress: "+S.getInetAddress());
        System.out.println("localPort: "+S.getLocalPort());
        System.out.println("localSocketAddress: "+S.getLocalSocketAddress());
        System.out.println("Remote Address: "+S.getRemoteSocketAddress());
        System.out.println("port: "+S.getPort());
    }
    
}