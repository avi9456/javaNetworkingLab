import java.net.*;
import java.io.*;
import java.util.zip.*;
public class Client{
    public static void main(String arg[]) throws Exception{
        Socket soc = new Socket(InetAddress.getLocalHost(),6969);
        PrintStream out = new PrintStream(soc.getOutputStream(),true);
        DataInputStream dis = new DataInputStream(new FileInputStream(new File("sendData.txt")));
        String data="",msg=dis.readLine();
        while(msg!=null){
            data = data+msg;
            out.println(msg);
            msg = dis.readLine();
        }
        byte[] b = data.getBytes();
        CRC32 crc = new CRC32();
        crc.update(b,0,b.length);
        System.out.println(data + ""+crc.getValue());
        dis.close();
        out.close();
        soc.close();
    }
}