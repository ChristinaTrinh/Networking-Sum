package Server;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class Server
{     
    public static void main(String[]args) throws IOException 
    {
                    // Create a server socket on port 8000
                    ServerSocket ss = new ServerSocket(8000);
                    System.out.println("Server started at " + new Date() + '\n');

                    // Listen for a connection request
                    Socket socket = ss.accept();
                        
                    // Create outputToClient and inputFromClient streams
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                        
                        // Receive radius from the client
                        double x =  input.readDouble();
                        System.out.println("Server: inputFromClient x value = " + x);
                        double y =  input.readDouble();
                        System.out.println("Server: inputFromClient y value = " + y);           
                        
                        // Compute area
                        double sum = x + y;

                        // Send area back to the client
                        output.writeDouble(sum);
                        System.out.println(" x = " + x + "   y = " + y + "     sum = " + sum);
                        System.exit(0);
    }  
} 
