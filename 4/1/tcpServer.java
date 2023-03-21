import java.io.*;
import java.net.*;

public class tcpServer{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream clientRead;
    private PrintStream clientWrite, terminalWrite;
    private String request,clientIP,serverIP,response;
    // private InetAddress ;

    tcpServer(int portNumber)throws Exception{
        serverSocket = new ServerSocket(portNumber,50,InetAddress.getByName("127.0.2.1"));
        serverIP = serverSocket.getInetAddress()+":"+serverSocket.getLocalPort();
        terminalWrite = new PrintStream(System.out,true);
        terminalWrite.println("ServerIP: "+serverIP);
    }
    tcpServer() throws Exception{
        this(6969);
    }
    public void listening() throws Exception{
        clientSocket = serverSocket.accept();
        clientRead = new DataInputStream(clientSocket.getInputStream());
        clientWrite = new PrintStream(clientSocket.getOutputStream(),true);
        clientIP = clientRead.readLine();
        terminalWrite.println(clientIP+" connected");
    }
    private void clientRequest()throws Exception{
        request = clientRead.readLine();
        terminalWrite.println("Request: "+request);
    }
    private void clientResponse() throws Exception{
        response = DNSRessolver(request);
        clientWrite.println(response);
        terminate();
    }
    private void terminate()throws Exception{
        clientRead.close();
        clientWrite.close();
        clientSocket.close();
        terminalWrite.println(clientIP+" dissconnected");
    }
    private String DNSRessolver(String request) throws Exception{
        return InetAddress.getByName(request).getHostName()+":"+InetAddress.getByName(request).getHostAddress();
    }
    public static void main(String arg[]) throws Exception{
        tcpServer server;
        if(arg.length > 0){
            server = new tcpServer(Integer.parseInt(arg[0]));
        }
        else{
            server = new tcpServer();
        }
        while(true){
            server.listening();
            server.clientRequest();
            server.clientResponse();
        }
    }

}