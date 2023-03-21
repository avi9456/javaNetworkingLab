import java.net.*;
import java.io.*;
import java.util.Scanner;

public class udpClient{
    public static void main(String arg[])throws Exception{
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte[] buf = null;
        while(true){
            String inp = sc.nextLine();
            buf = inp.getBytes();
            DatagramPacket dpSend = new DatagramPacket(buf,buf.length,ip,6969);
            ds.send(dpSend);
            if(inp.equals("bye")){
                break;
            }
        }
    }
}