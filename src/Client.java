import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String sonnet = reader.readLine();
        System.out.println("Полученный сонет: " + sonnet);
        socket.close();
    }
}
