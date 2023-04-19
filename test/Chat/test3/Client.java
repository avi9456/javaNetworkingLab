import java.io.*;
import java.net.*;

public class Client{
    public static String msg="";
    public static DataInputStream cread,tread;
    public static PrintStream cwrite,twrite;
    public static void main(String arg[]) throws Exception{
        Socket scoket = new Socket(InetAddress.getLocalHost(),6969);
        Thread sRead = new Thread(new Runnable(){
            // static String msg;
            public void run(){
                try{
                    // DataInputStream read = new DataInputStream(scoket.getInputStream());
                    // PrintStream write = new PrintStream(System.out);
                    cread = new DataInputStream(scoket.getInputStream());
                    twrite = new PrintStream(System.out,true);
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = cread.readLine();
                        twrite.println("server: "+msg);
                    }
                    // cread.close();
                    // twrite.close();
                    // scoket.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        Thread sWrite = new Thread(new Runnable(){
            public void run(){
                try{
                    // DataInputStream read = new DataInputStream(System.in);
                    // PrintStream write = new PrintStream(scoket.getOutputStream());
                    // String msg="";
                    tread = new DataInputStream(System.in);
                    cwrite = new PrintStream(scoket.getOutputStream(),true);
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = tread.readLine();
                        cwrite.println(msg);
                    }
                    // tread.close();
                    // cwrite.close();
                    // scoket.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        sWrite.start();
        sRead.start();
        while(true){
            System.out.print("");
            if(msg.equalsIgnoreCase("bye")){
                sRead.stop();
                cread.close();
                twrite.close();
                sWrite.stop();
                tread.close();
                cwrite.close();
                scoket.close();
                break;
            }
        }
    }
}