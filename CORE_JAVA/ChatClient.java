import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            int port = 5000;
            
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to server at " + serverAddress + ":" + port);
            
            // Input and output streams
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);
            
            BufferedReader consoleInput = new BufferedReader(
                    new InputStreamReader(System.in));
            
            String userMessage;
            String serverMessage;
            
            System.out.println("Type your messages (type EXIT to quit):\n");
            
            while (true) {
                // Send to server
                System.out.print("Client: ");
                userMessage = consoleInput.readLine();
                
                if (userMessage.equalsIgnoreCase("EXIT")) {
                    writer.println("EXIT");
                    break;
                }
                
                writer.println(userMessage);
                
                // Receive from server
                serverMessage = reader.readLine();
                if (serverMessage == null || serverMessage.equalsIgnoreCase("EXIT")) {
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }
            
            reader.close();
            writer.close();
            socket.close();
            System.out.println("Disconnected from server.");
            
        } catch (ConnectException e) {
            System.out.println("Error: Cannot connect to server. Make sure the server is running.");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
