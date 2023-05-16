package Client;

// Write the program that will have the Client read in 2 numbers from the user and then 
// send those 2 numbers to the Server whereupon the Server will return their sum.

import java.io.*;
import java.net.*;
import java.util.Scanner;
      
public class Client
{
    public static void main(String[] args) throws IOException 
    {   
        // Create a new Socket for "localhost" on port 8000
        Socket socket = new Socket("localhost", 8000);
        
        Scanner console = new Scanner(System.in);     
    
        // IO streams: DEFINE the following: DataOutputStream toServer AND DataInputStream fromServer 
        DataOutputStream output = new DataOutputStream(socket.getOutputStream()); 
        DataInputStream input = new DataInputStream(socket.getInputStream());  
        
        double x =0; 
        double y=0;
        
        // Get the radius from the text field
        System.out.print("Enter x: ");                    
        x = console.nextDouble();
        System.out.println("       x = " + x);      
                    
        //  Write x toServer
        output.writeDouble(x);
                             
        System.out.print("Enter y: ");
        y = console.nextDouble(); 
        System.out.println("       y = " + y);                                        
        //  Write y toServer
        output.writeDouble(y);
                    
        // Get sum from the server
        double sum = input.readDouble();
        System.out.println("Server: inputFromServer sum value = " + sum);                    

        System.out.println("x + y = " + sum);
                        
        System.exit(0);
    }  
} 
 


