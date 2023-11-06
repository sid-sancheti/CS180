package Week11.Challenge;

import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * SearchClient.java
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
            portNumberAsString = JOptionPane.showInputDialog(null, "Enter the port number", TITLE,
                    JOptionPane.QUESTION_MESSAGE);
            portNumber = Integer.parseInt(portNumberAsString);

            client = new Socket(portHost, portNumber);

            JOptionPane.showMessageDialog(null, "Connection Established", TITLE, JOptionPane.INFORMATION_MESSAGE);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            do {
                // Asking the user for their search query
                String searchQuery;
                do { // Verify whether the user inputed a query.
                    searchQuery = JOptionPane.showInputDialog(null, "Enter your search query: ", TITLE,
                            JOptionPane.QUESTION_MESSAGE);

                    if (searchQuery == null || searchQuery.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a search query!", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }
                } while (searchQuery == null || searchQuery.isEmpty());

                // Send the user's query to the server and receive the response
                try {
                    // Send search query

                    // Get query results
                    out.println(searchQuery);
                    out.flush();

                    String[] titleResponse = (String[]) in.readObject();

                    if (titleResponse.length == 0) {
                        JOptionPane.showMessageDialog(null, "No results found", TITLE, JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    // Display the response to the user
                    String descriptionQuery = (String) JOptionPane.showInputDialog(null, "Select the Title ",
                            "Order Form",
                            JOptionPane.PLAIN_MESSAGE, null, titleResponse, null);

                    // Send the title index to the server
                    out.println(descriptionQuery);
                    out.flush();

                    // Receive the description from the server
                    String description = (String) in.readObject();
                    JOptionPane.showMessageDialog(null, description, TITLE, JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "IOException thrown", TITLE, JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "ClassNotFoundException thrown", TITLE,
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } while (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Would you like to search again?",
                    TITLE, JOptionPane.YES_NO_OPTION));

            // Close the server connection with a goodbye message
            JOptionPane.showMessageDialog(null, "Goodbye User! Until next time...", TITLE,
                    JOptionPane.INFORMATION_MESSAGE);
            client.close();
        } catch (NumberFormatException e) {
            displayError("Invalid port number");
            return;
        } catch (IllegalArgumentException e) {
            displayError("Invalid port number");
            return;
        } catch (UnknownHostException e) {
            displayError("The IP of the host could not be determined");
            return;
        } catch (IOException e) {
            displayError("IOException thrown");
            return;
        }

    }

    public static void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, TITLE, JOptionPane.ERROR_MESSAGE);
    }
}
