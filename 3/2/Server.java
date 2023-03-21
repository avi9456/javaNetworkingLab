import java.net.*;
import java.io.*;

public class Server{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream read,tread;
    private PrintStream write,twrite;
    private String clientIP,msg,serverIP;
    Server(int portNum) throws Exception{
        serverSocket = new ServerSocket(portNum,60,InetAddress.getByName("127.0.2.1"));
        tread = new DataInputStream(System.in);
        twrite = new PrintStream(System.out,true);
        serverIP = serverSocket.getInetAddress()+":"+serverSocket.getLocalPort();
        twrite.println("Server Info: "+serverIP);
    }
    Server() throws Exception{
        this(6969);
    }
    private void startCon()throws Exception{
        clientSocket = serverSocket.accept();
        read = new DataInputStream(clientSocket.getInputStream());
        write = new PrintStream(clientSocket.getOutputStream(),true);
        serverIP = serverSocket.getInetAddress()+":"+serverSocket.getLocalPort();
        clientIP = read.readLine();
        twrite.println("Connected to > "+clientIP);
    }
    private void stopCon()throws Exception{
        write.println("bye! connection terminated");
        twrite.println(clientIP+" disconnected");
        clientSocket.close();
    }
    private void startChat()throws Exception{
        write.println("Welcome to chatServer! type 'bye' to end");
        do{
            msg = read.readLine();
            if(msg!=null || msg!="\n"){
                twrite.println(clientIP+"> "+msg);
                if(msg.trim().equalsIgnoreCase("bye")){
                    write.println("bye");
                    break;
                }
                twrite.print(serverIP+">");
                msg = tread.readLine();
                write.println(msg);
            }
        }while(true);
        stopCon();
    }
    public static void main(String arg[]) throws Exception{
        Server server;
        if(arg.length==1){
            server = new Server(Integer.parseInt(arg[0]));
        }
        else{
            server = new Server();
        }
        while(true){
            server.startCon();
            server.startChat();
            
        }
    }

}