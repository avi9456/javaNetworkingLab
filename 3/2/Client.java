import java.net.*;
import java.io.*;

public class Client{
    private Socket socket;
    private InetAddress IA;
    private DataInputStream read,tread;
    private PrintStream write, twrite;
    private String msg,clientIP,serverIP;
    public Client(int portNum) throws Exception{
        // IA = InetAddress.getLocalHost();
        IA = InetAddress.getByName("127.0.2.1");
        socket = new Socket(IA,portNum);
        IA = InetAddress.getLocalHost();
        clientIP = IA.getHostAddress()+":"+socket.getLocalPort();
        serverIP = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
        read = new DataInputStream(socket.getInputStream());
        tread = new DataInputStream(System.in);
        write = new PrintStream(socket.getOutputStream(),true);
        twrite = new PrintStream(System.out,true);
        twrite.println("Client Info: "+clientIP);
        twrite.println("Server Info: "+serverIP);
        write.println(clientIP);
    }
    public Client() throws Exception{
        this(6969);
    }
    private void stopCon() throws Exception{
        twrite.println("Connection terminated");
        socket.close();
    }
    private void startChat()throws Exception{
        do{
            msg= read.readLine();
            twrite.println(serverIP+"> "+msg);
            twrite.print(clientIP+"> ");
            msg=tread.readLine();
            write.println(msg);
            // msg = read.readLine();
        }while(!msg.trim().equalsIgnoreCase("bye"));
        stopCon();
    }
    public static void main(String arg[]) throws Exception{
        Client client;
        if(arg.length== 1){
            client = new Client(Integer.parseInt(arg[0]));
        }
        else{
            client = new Client(6969);
        }
        client.startChat();
    }

}