import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        Socket socket = server.accept();
        System.out.println("Client connected: " + socket);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Client: " + input);
            if (input.equalsIgnoreCase("bye")) {
                break;
            }
            String output = console.readLine();
            out.println(output);
            if (output.equalsIgnoreCase("bye")) {
                break;
            }
        }

        socket.close();
        server.close();
    }
}
