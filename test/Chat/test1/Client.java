import java.io.*;
import java.net.*;

public class Client{
    public static void main(String arg[]) throws Exception{
        Socket scoket = new Socket(InetAddress.getLocalHost(),6969);
        Thread sRead = new Thread(new Runnable(){
            static String msg;
            public void run(){
                try{
                    DataInputStream read = new DataInputStream(scoket.getInputStream());
                    PrintStream write = new PrintStream(System.out);
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = read.readLine();
                        write.println("server: "+msg);
                    }
                    System.out.println("write");
                    scoket.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        Thread sWrite = new Thread(new Runnable(){
            public void run(){
                try{
                    DataInputStream read = new DataInputStream(System.in);
                    PrintStream write = new PrintStream(scoket.getOutputStream());
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = read.readLine();
                        write.println("server: "+msg);
                    }
                    System.out.println("write");
                    scoket.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        sWrite.start();
        sRead.start();
        
    }
}