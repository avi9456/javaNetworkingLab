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
        Thread cRead = new Thread(new Runnable(){
            public void run(){
                // DataInputStream read;
                // PrintStream write;
                try{
                    // read = new DataInputStream(client.getInputStream());
                    // write = new PrintStream(System.out);
                    // String msg="";
                    cread = new DataInputStream(client.getInputStream());
                    twrite = new PrintStream(System.out);
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = cread.readLine();
                        twrite.println("client: "+msg);
                    }
                    // cread.close();
                    // twrite.close();
                    //client.close();
                }
                catch(IOException e){
                    System.out.println(e+"2");
                }
            }
        });
        Thread cWrite = new Thread(new Runnable(){
            public void run(){
                // DataInputStream read;
                // PrintStream write;
                try{
                    // read = new DataInputStream(System.in);
                    // write = new PrintStream(client.getOutputStream());
                    // String msg="";
                    tread = new DataInputStream(System.in);
                    cwrite = new PrintStream(client.getOutputStream());
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = tread.readLine();
                        cwrite.println(msg);
                    }
                    // tread.close();
                    // cwrite.close();
                    // client.close();
                }
                catch(IOException e){
                    System.out.println(e+"1");
                }
            }
        });
        cRead.start();
        cWrite.start();
        while(true){
            System.out.print("");
            if(msg.equalsIgnoreCase("bye")){
                cRead.stop();
                cread.close();
                twrite.close();
                cWrite.stop();
                tread.close();
                cwrite.close();
                client.close();
                break;
            }
        }
        
    }
}