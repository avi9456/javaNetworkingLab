import java.io.*;
import java.net.*;

public class Client{
    public static void main(String arg[]) throws Exception{
        //connting localhost with server nad binding with port 6969
        Socket socket = new Socket(InetAddress.getLocalHost(),6969);
        //reading the file name from keyboard. uses input stream
        System.out.print("Enter file name: ");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fName = keyRead.readLine();
        //sending the file name to the srever. Uses PrintWriter
        OutputStream write = socket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(write,true);
        pwrite.println(fName);
        //reciving the contents from the server. Uses Iput Stream 
        InputStream read = socket.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(read));
        String msg;
        while((msg = socketRead.readLine())!=null)//reading line-by-line
        {
            System.out.println(msg);
        }
        //closing file, stream and socket
        pwrite.close();
        socketRead.close();
        keyRead.close();
        socket.close();

    }
}