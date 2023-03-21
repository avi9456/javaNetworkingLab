import java.io.*;
import java.net.*;

public class tcpClient{
    private Socket socket;
    private DataInputStream terminalread,serverRead;
    private PrintStream terminalWrite,serverWrite;
    private InetAddress localHost;
    private String clientIP,request,response;
    tcpClient(int portNumber) throws Exception{
        localHost = InetAddress.getByName("127.0.2.1");
        socket = new Socket(localHost,portNumber);
        clientIP = InetAddress.getLocalHost().getHostAddress()+":"+socket.getLocalPort();
        terminalread = new DataInputStream(System.in);
        terminalWrite = new PrintStream(System.out,true);
        serverRead = new DataInputStream(socket.getInputStream());
        serverWrite = new PrintStream(socket.getOutputStream(),true);
        serverWrite.println(clientIP);
    }
    tcpClient() throws Exception{
        this(6969);
    }
    private void close() throws Exception{
        serverWrite.close();
        serverRead.close();
        socket.close();
        terminalWrite.println("connection terminated");
        terminalWrite.close();
        terminalread.close();
    }
    private void request() throws Exception{
        terminalWrite.println("Enter IP or URL");
        request = terminalread.readLine();
        serverWrite.println(request);
    }
    private void response() throws Exception{
        response = serverRead.readLine();
        terminalWrite.println("Host Name: "+response.substring(0,response.indexOf(":"))+"\n"+"Host Address: "+response.substring(response.indexOf(":")+1));
        close();
    }
    public static void main(String arg[]) throws Exception{
        tcpClient client;
        if(arg.length >0){
            client = new tcpClient(Integer.parseInt(arg[0]));
        }
        else{
            client = new tcpClient();
        }
        client.request();
        client.response();
    }
}