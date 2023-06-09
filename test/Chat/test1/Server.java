import java.net.*;
import java.io.*;

public class Server{
    public static String msg="";
    public static DataInputStream cread,tread;
    public static PrintStream cwrite,twrite;
    public static void main(String arg[]) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6969);
        Socket client = serverSocket.accept();
        // String msg = "";
        // DataInputStream cread,tread;
        // PrintStream cwrite,twrite;
        Thread cRead = new Thread(new Runnable(){
            public void run(){
                // DataInputStream read;
                // PrintStream write;
                try{
                    cread = new DataInputStream(client.getInputStream());
                    twrite = new PrintStream(System.out);
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = cread.readLine();
                        twrite.println("client: "+msg);
                    }
                    tread.close();
                    cread.close();
                    twrite.close();
                    cwrite.close();
                    client.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        Thread cWrite = new Thread(new Runnable(){
            public void run(){
                // DataInputStream read;
                // PrintStream write;
                try{
                    tread = new DataInputStream(System.in);
                    cwrite = new PrintStream(client.getOutputStream());
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = tread.readLine();
                        cwrite.println(msg);
                    }
                    tread.close();
                    cread.close();
                    twrite.close();
                    cwrite.close();
                    client.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        cRead.start();
        cWrite.start();
        
    }
}