import java.net.*;
import java.io.*;
public class Server{
    public static void main(String arg[]) throws Exception{
        Server s = new Server();
        s.run();
    }
    public void run() throws Exception{
        String tmp="any message",str="exit";
        ServerSocket SS = new ServerSocket(6969);
        Socket S = SS.accept();
        BufferedReader cread = new BufferedReader(new InputStreamReader(S.getInputStream()));
        PrintStream cwrite = new PrintStream(S.getOutputStream(),true);
        while(tmp.compareTo(str)!=0){
            Thread.sleep(1000);
            tmp = cread.readLine();
            if(tmp.compareTo(str)==0){
                break;
            }
            System.out.println("Frame "+tmp+" was recived");
            Thread.sleep(500);
            cwrite.println("Recived");
        }
        System.out.println("ALL FRAMES WERE RECEIVED SUCCESSFULLY");
    }
}