import java.net.*;
import java.io.*;

public class Server{
    public static void main(String arg[]) throws Exception{
        //establishing the connection with the server
        ServerSocket serverSocket = new ServerSocket(6969);
        System.out.println("server is ready for connection");
        Socket clientSocket = serverSocket.accept();//binding with port 6969
        System.out.println("Connection is successful and waiting for Client request");
        //reading file name from client
        InputStream read = clientSocket.getInputStream();
        BufferedReader  fRead  = new BufferedReader(new InputStreamReader(read));
        String fName = fRead.readLine();
        //reading file contents
        BufferedReader contentRead = new BufferedReader(new FileReader(fName));
        //keeping output stream ready to send the contents
        OutputStream write = clientSocket.getOutputStream();
        PrintStream pwrite = new PrintStream(write,true);
        String msg;
        while((msg = contentRead.readLine())!=null)//reading line-by-line from file
        {
            pwrite.println(msg);//sending each line to client
        }
        //closing network sockets and file,stream
        System.out.println("transfer completed\nconnection terminated");
        clientSocket.close();
        serverSocket.close();
        pwrite.close();
        fRead.close();
        contentRead.close();

    }
}