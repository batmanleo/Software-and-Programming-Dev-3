//this code sets up a server that a client can connect to
//and the user can send messages to all of the clients
//code by geeks for geeks
//edited by Leo
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class fileServer {

    private static final int PORT = 12346;
    private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections...");

            // Thread to handle server admin input
            new Thread(() -> {
                Scanner keyboardInput = new Scanner(System.in);
                while (true) {
                    String serverMessage = keyboardInput.nextLine();
                    broadcast("[Server]: " + serverMessage, null);
                }
            }).start();

            // Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // Create a new client handler for the connected client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast a message to all clients
    public static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Internal class to handle client connections
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter forCilent;
        private BufferedReader fromCilent;
        private String username;
        private File fileFromCilent;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;

            try {
                forCilent = new PrintWriter(clientSocket.getOutputStream(), true);
                fromCilent = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Get the username from the client
                forCilent.println("Enter your username:");
                username = fromCilent.readLine();
                System.out.println("User " + username + " connected.");
                forCilent.println("Welcome to the server, " + username);
                forCilent.println("Enter your file:");
                //fileFromCilent = fromCilent.();


                String inputLine;
                while ((inputLine = fromCilent.readLine()) != null) {
                    System.out.println("[" + username + "]: " + inputLine);
                    broadcast("[" + username + "]: " + inputLine, this);
                }

                // Remove the client handler from the list
                clients.remove(this);
                System.out.println("User " + username + " disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fromCilent.close();
                    forCilent.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            forCilent.println(message);
        }
    }
}