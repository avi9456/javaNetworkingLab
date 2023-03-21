import java.net.*;
import java.io.*;

public class udpServer{
    public static void main(String arg[]) throws Exception{
        //create a socket to listen on port 6969
        DatagramSocket ds = new DatagramSocket(6969);
        byte[] receive = new byte[65535];
        DatagramPacket dpReceive = null;
        while(true){
            //create a datagramPacket to recive the data
            dpReceive = new DatagramPacket(receive,receive.length);
            //receive the data in byte buffer
            ds.receive(dpReceive);
            System.out.println("client:- "+data(receive));
            if(data(receive).toString().equals("bye")){
                System.out.println("client sent bye .........EXITING");
                break;
            }
            //clear the buffer after every message
            receive = new byte[65535];
        }
    }
    //A utility method to convert the byte array data into string repersentation.
    public static StringBuilder data(byte[] a)throws Exception{
        if(a== null){
            return null;
        }
        else{
            StringBuilder ret = new StringBuilder();
            int i = 0;
            while(a[i]!=0){
                ret.append((char)a[i]);
                i++;
            }
            return ret;
        }
    }
}