//this code lets the user connect to a server using a web address 
//orginal code by geeks for geeks
//edited by Leo 
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class fileClient {
    //private static final String SERVER_ADDRESS = "67.42.72.118";
    private static final int SERVER_PORT = 12346;

    public static void main(String[] args) {
        try {

            System.out.println("");

            Scanner keyboardInput  = new Scanner(System.in);
            String userInput;
            String filename;

            System.out.println("Enter address ");
            System.out.println("Try 127.0.0.1 or localhost"); 

            userInput = keyboardInput .nextLine();
            InetAddress SERVER_ADDRESS = InetAddress.getByName(userInput);
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to the file server!");


            //System.out.println("Enter text file name");
            
            //userInput = keyboardInput .nextLine();
            //File fileForServer = new File(userInput+".txt");


            // Setting up input and output streams
            PrintWriter forServer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start a thread to handle incoming messages
            new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = fromServer.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read messages from the console and send to the server


            while (true) {
                userInput = keyboardInput .nextLine();
                forServer.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}