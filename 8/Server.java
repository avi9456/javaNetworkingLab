import java.net.*;
import java.io.*;
import java.util.zip.*;
public class Server{
    public static void main(String arg[]) throws Exception{
        ServerSocket ss = new ServerSocket(6969);
        Socket client = ss.accept();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        PrintStream out = new PrintStream(System.out);
        PrintStream cout = new PrintStream(client.getOutputStream());
        PrintStream file = new PrintStream(new FileOutputStream(new File("data.txt")));
        String data = "",msg=dis.readLine();
        while(msg!=null){
            data = data+msg;
            msg = dis.readLine();
            
        }
        byte[] b = data.getBytes();
        CRC32 crc = new CRC32();
        crc.update(b,0,b.length);
        out.println(data+" "+crc.getValue());
        file.println(data);
        file.close();
        out.close();
        dis.close();
        client.close();
    }
}