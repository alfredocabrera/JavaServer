
package zerver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Zerver {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    
    public static void main(String[] args) throws IOException 
    {
      try {
			serverSocket = new ServerSocket(44444); // Server socket
 
		} catch (IOException e) {
			System.out.println("Could not listen on port: 44444");
		}
 
		System.out.println("Server started. Listening to the port 4444");
 
		while (true) {
			try {
 
				clientSocket = serverSocket.accept(); // accept the client connection
				inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader); // get the client message
				message = bufferedReader.readLine();
 
				System.out.println(message);
				inputStreamReader.close();
				clientSocket.close();
 
			} catch (IOException ex) {
				System.out.println("Problem in message reading");
			}
		}      
    }
                
                
                
    
}
