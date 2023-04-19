import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server: " + socket);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (true) {
            String output = console.readLine();
            out.println(output);
            if (output.equalsIgnoreCase("bye")) {
                break;
            }
            input = in.readLine();
            System.out.println("Server: " + input);
            if (input.equalsIgnoreCase("bye")) {
                break;
            }
        }

        socket.close();
    }
}
