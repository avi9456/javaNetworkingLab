import java.io.*;
public class traceRoute{
    public static void main(String arg[]) throws Exception{
        Process p = Runtime.getRuntime().exec("traceroute " + arg[0]);
        DataInputStream in = new DataInputStream(p.getInputStream());
        String msg = "";
        while((msg = in.readLine())!=null){
            System.out.println(msg);
        }
    }
}