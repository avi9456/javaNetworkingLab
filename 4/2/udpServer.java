import java.net.*;
import java.io.*;
import java.util.*;
public class udpServer{
    public static void main(String arg[]) throws Exception{
        DatagramSocket ds = new DatagramSocket(6969);
        InetAddress IA= InetAddress.getLocalHost();
        System.out.println("Server up "+IA);
        byte[] b = new byte[1024];
        DatagramPacket packet = new DatagramPacket(b,1024);
        while(true){
            ds.receive(packet);
            String str = new String(packet.getData(),0,packet.getLength());
            packet.setSocketAddress(packet.getSocketAddress());
            if(!str.equalsIgnoreCase("date")){
                b = "wrong request".getBytes();
                packet.setLength(b.length);
                packet.setData(b);
            }
            else{
                Date d = new Date();
                b = d.toString().getBytes();
                // packet.setLength(b.length);
                packet.setData(b);
                System.out.println(packet.getLength());
            }
            ds.send(packet);
        }
    }
}