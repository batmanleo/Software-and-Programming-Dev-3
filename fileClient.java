import java.io.*;
import java.net.*;
import java.util.Scanner;

public class fileClient {
    
    //private static final String SERVER_ADDRESS = "localhost";
    //note: the server port only works when it's the same as the server
    private static final int SERVER_PORT = 12346;

    public static void main(String[] args) {
        try {
            Scanner Keyboardinput = new Scanner(System.in);
            String userInput;
            System.out.println("Enter address ");
            System.out.println("Try 127.0.0.1 or localhost");
 
                userInput = Keyboardinput.nextLine();
                System.out.println(userInput);
            
            InetAddress SERVER_ADDRESS = InetAddress.getByName(userInput);
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to the file server!");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Enter file name ");
            Keyboardinput.nextLine();
            System.out.println(userInput);
            File fileseer= new File(userInput+".txt");
            Scanner readme= new Scanner(fileseer);
            


                  new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();



            while (true) {
                userInput = Keyboardinput.nextLine();
                out.println(userInput);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

}
