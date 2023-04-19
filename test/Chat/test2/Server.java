import java.net.*;
import java.io.*;

public class Server{
    public static String msg="";
    public static void main(String arg[]) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6969);
        Socket client = serverSocket.accept();
        // String msg = "";
        Thread cRead = new Thread(new Runnable(){
            public void run(){
                DataInputStream read;
                PrintStream write;
                try{
                    read = new DataInputStream(client.getInputStream());
                    write = new PrintStream(System.out);
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = read.readLine();
                        write.println("client: "+msg);
                    }
                    read.close();
                    write.close();
                    //client.close();
                }
                catch(IOException e){
                    System.out.println(e+"2");
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
                    // String msg="";
                    while(!msg.equalsIgnoreCase("bye")){
                        msg = read.readLine();
                        write.println(msg);
                    }
                    read.close();
                    write.close();
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
                System.out.println("cRead destroy");
                cWrite.stop();
                System.out.println("cRead destroy");
                client.close();
                break;
            }
        }
        
    }
}