import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Сервер запущен");

        List<String> sonnets = Files.readAllLines(Paths.get("src/sonnets.txt"));

        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            int random = new Random().nextInt(sonnets.size());
            writer.println(sonnets.get(random));
            socket.close();
        }
    }
}
