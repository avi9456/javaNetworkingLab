import java.io.*;
import java.net.*;
import java.util.Date;

public class ftpServer{
    private ServerSocket serverScoket;
    private Socket clientSocket;
    private String date,log,dir,msg,fileName;
    private DataInputStream readClient,readFile;
    private PrintStream writeClient,writeFile,writeLog,writeTerminal;
    private File file;
    
}
