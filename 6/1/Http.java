import java.io.*;
import java.net.*;

public class Http{
    public static void main(String arg[]) throws Exception{
        URL url = new URL("http://raspwn.org/install");
        URLConnection conn = url.openConnection();
        conn.connect();
        InputStreamReader content = new InputStreamReader(conn.getInputStream());
        FileWriter f = new FileWriter("abc.html");
        int i = 0;
        while(i!=-1){
            i= content.read();
            f.write((char)i);
        }
        f.close();
        content.close();

    }
}