import java.io.*;
import java.net.*;
public class Client{
    public static void main(String arg[]) throws Exception{
        Client c = new Client();
        c.run();
    }
    public void run()throws Exception{
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("ENTER NO OF FRAMES TO BE SENT: ");
        int n = in.nextInt();
        Socket S = new Socket("localhost",6969);
        PrintStream swrite = new PrintStream(S.getOutputStream());
        for(int i=0;i<=n;){
            if(i==n){
                swrite.println("exit");
                break;
            }
            System.out.println("Frame no "+i+" is sent");
            swrite.println(i);
            BufferedReader sread = new BufferedReader(new InputStreamReader(S.getInputStream()));
            String ack = sread.readLine();
            if(ack!=null){
                System.out.println("Acknowledgement was Received from server");
                i++;
                Thread.sleep(4000);
            }
            else{
                swrite.println(i);
            }
        }
    }
}