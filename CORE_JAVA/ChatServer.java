import java.io.*;
import java.net.*;

public class ChatServer {
    private static final int PORT = 5000;
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Chat Server started on port " + PORT);
            System.out.println("Waiting for client connection...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            
            // Input and output streams
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            
            BufferedReader consoleInput = new BufferedReader(
                    new InputStreamReader(System.in));
            
            String clientMessage;
            String serverMessage;
            
            while (true) {
                // Receive from client
                clientMessage = reader.readLine();
                if (clientMessage == null || clientMessage.equalsIgnoreCase("EXIT")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMessage);
                
                // Send to client
                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                if (serverMessage.equalsIgnoreCase("EXIT")) {
                    writer.println("EXIT");
                    break;
                }
                writer.println(serverMessage);
            }
            
            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
