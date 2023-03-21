import java.net.*;

public class testServer {
    public static void main(String arg[]) throws Exception{
        ServerSocket SS = new ServerSocket(9999,100,InetAddress.getByName("127.0.2.1"));
        System.out.println(SS);
        System.out.println("InetAddress: "+SS.getInetAddress());
        System.out.println("localPort: "+SS.getLocalPort());
        System.out.println("localSocketAddress: "+SS.getLocalSocketAddress());
        // System.out.println("Remote Address: "+SS.getRemoteSocketAddress());
        // System.out.println("port: "+SS.getPort());
        Socket S = SS.accept();
        System.out.println(S);
        System.out.println("InetAddress: "+S.getInetAddress());
        System.out.println("localPort: "+S.getLocalPort());
        System.out.println("localSocketAddress: "+S.getLocalSocketAddress());
        System.out.println("Remote Address: "+S.getRemoteSocketAddress());
        System.out.println("port: "+S.getPort());
    }
}