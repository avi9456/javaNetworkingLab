import java.net.*;
import java.io.*;

public class Server{
    public static void main(String arg[]) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6969);
        Socket client = serverSocket.accept();
        Thread cRead = new Thread(new Runnable(){
            public void run(){
                DataInputStream read;
                PrintStream write;
                try{
                    read = new DataInputStream(client.getInputStream());
                    write = new PrintStream(System.out);
                    String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = read.readLine();
                        write.println("client: "+msg);
                    }
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        });
        Thread cWrite = new Thread(new Runnable(){
            public void run(){
                DataInputStream read;
                PrintStream write;
                try{
                    read = new DataInputStream(System.in);
                    write = new PrintStream(client.getOutputStream());
                    String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = read.readLine();
                        write.println("client: "+msg);
                    }
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