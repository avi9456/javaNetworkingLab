import java.net.*;
import java.io.*;

public class Client{
    public static void main(String arg[]) throws IOException{
        Socket S;
        InetAddress IA = InetAddress.getLocalHost();
        if(arg.length > 0){
            S = new Socket(IA,Integer.parseInt(arg[0]));
        }
        else{
            S = new Socket(IA,6969);
        }
        DataInputStream read = new DataInputStream(S.getInputStream());
        PrintStream write = new PrintStream(S.getOutputStream(),true);
        write.println(IA.getHostAddress()+":"+S.getLocalPort());
        String msg = "ECHO";
        write.println(msg);
        for(int i =0;i<3;i++){
            msg = read.readLine();
            if(msg!=null){
                System.out.println(msg);
                write.println(msg);
            }
        }
        S.close();
    }
}