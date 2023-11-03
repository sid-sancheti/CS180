package Week11.Challenge;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**SearchClient.java
 * 
 * This class is the client side of the search engine. 
 * It prompts the user for a search query and sends it to the server.
 * 
 * HOST NAME: localhost
 * PORT NUMBER: 1234
 * 
 * @author Siddharth Sancheti, Section 33
 * @version November 1, 2023
 */
public class SearchClient {
    private static final String TITLE = "Search Engine";

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome User!", TITLE, JOptionPane.INFORMATION_MESSAGE);   
        
        String portHost;
        String portNumberAsString;
        int portNumber;

        Socket client = null;
        
        try {
            // Get the port name
            portHost = JOptionPane.showInputDialog(null, "Enter the host name", TITLE, JOptionPane.QUESTION_MESSAGE);

            // Get the port number
            portNumberAsString = JOptionPane.showInputDialog(null, "Enter the port number", TITLE, JOptionPane.QUESTION_MESSAGE);
            portNumber = Integer.parseInt(portNumberAsString);

            client = new Socket(portHost, portNumber);

            JOptionPane.showMessageDialog(null, "Connection Established", TITLE, JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid port number", TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Invalid port number", TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "The IP of the host could not be determined", TITLE, 
            JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOException thrown", TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        }

        // TODO: Place in a do-while loop to allow the user to search multiple times.
        // Asking the user for their search query
        String searchQuery;
        do {    // Verify whether the user inputed a query.
            searchQuery = JOptionPane.showInputDialog(null, "Enter your search query: ", TITLE, JOptionPane.QUESTION_MESSAGE);

            if (searchQuery == null || searchQuery.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a search query!", TITLE, JOptionPane.ERROR_MESSAGE);
            }
        } while (searchQuery == null || searchQuery.isEmpty());

        // Send the user's query to the server and receive the response
        try {
            // Send search query
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(searchQuery);

            // Return query results
            ArrayList<String> results = new ArrayList<String>();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String response = in.readLine();

            // TODO: There is something going on with the readLine function. I'm not sure what it is.

            // Continue reading each line sent by the server until there are no more lines to read
            while (response != null) {
                results.add(response);
                response = in.readLine();
            }

            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOException thrown", TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Close the server connection with a goodbye message
        JOptionPane.showMessageDialog(null, "Goodbye User! Until next time...", TITLE, JOptionPane.INFORMATION_MESSAGE);
        try {
            client.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOException thrown", TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        }

    }
}


