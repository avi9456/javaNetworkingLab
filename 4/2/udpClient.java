import java.net.*;
import java.io.*;
import java.util.Date;

public class udpClient{
    public static void main(String arg[])throws Exception{
        InetAddress IA = InetAddress.getLocalHost();
        DatagramSocket ds = new DatagramSocket();
        byte b[] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(b,1024,IA,6969);
        b = "date".getBytes();
        packet.setData(b);
        packet.setLength(b.length);
        ds.send(packet);
        ds.receive(packet);
        System.out.println(packet.getLength());
        String str = new String(packet.getData(),0,packet.getLength());
        System.out.println(str);
    }
}