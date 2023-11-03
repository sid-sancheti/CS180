package Week11.Challenge;
import javax.swing.*;
import java.io.*;
import java.net.*;
/**SearchClient.java
 * 
 * This class is the client side of the search engine. 
 * It prompts the user for a search query and sends it to the server.
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

        // Asking the user for their search query
        String searchQuery = JOptionPane.showInputDialog(null, "Enter your search query: ", TITLE, JOptionPane.QUESTION_MESSAGE);

        
        try {
            client.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOException thrown", TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        }

    }
}


