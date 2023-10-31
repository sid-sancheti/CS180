package Week11.Walkthrough;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 * 
 */
public class SimpleClient {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 4242);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            System.out.println("What do you want to send to the server?");
            String response = scan.nextLine();

            writer.write(response);
            writer.println();
            writer.flush(); // ensure data is sent to the server
            System.out.printf("Sent to server:\n%s\n", response);

            String s1 = reader.readLine();
            System.out.printf("Received from server:\n%s\n", s1);

            writer.close();
            reader.close();
            scan.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 