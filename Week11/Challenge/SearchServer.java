package Week11.Challenge;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**SearchServer.java
 * 
 * This class is the server side of the search engine.
 * 
 * HOST NAME: localhost
 * PORT NUMBER: 1234
 * 
 * @author Siddharth Sancheti, Section 33
 * @version November 1, 2023
 */
public class SearchServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            
            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Handle client's requests in a new thread
                /**
                 * This is a lambda expression. I had to do a bit of research to figure out why my
                 * code wasn't working and this fixed it.
                 * I needed to run the handleClient() method in a new thread because the server
                 * needs to be able to handle multiple clients at once.
                 * 
                 * The lambda expression is a way to create a new thread and run the handleClient()
                 * Basically, it's a shorter way to run the handleClient method in the run() method
                 */
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOException thrown", "Search Engine", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static ArrayList<String> loadDatabase() {
        ArrayList<String> database = new ArrayList<>();
        // TODO: Change path before submission
        try (BufferedReader br = new BufferedReader(new FileReader("Week11/Challenge/searchDatabase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                database.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return database;
    }

    /**
     * This method searches the database for the search query
     * 
     * @param searchQuery The search query
     * @return An ArrayList of all the lines that match the search query
     */
    private static String[] searchForTitles(String searchQuery) {
        // The arrayList that contains all matching titles to the search query
        ArrayList<String> matchingTitles = new ArrayList<>();
        // Contains all the pages
        ArrayList<String> database = loadDatabase();

        // Make the search query all lowercase
        searchQuery = searchQuery.toLowerCase();

        // Create a new ArrayList that is all lowercase
        ArrayList<String> lowerCaseDB = new ArrayList<String>();
        for (String entry : database) {
            lowerCaseDB.add(entry.toLowerCase());
        }

        for (int i = 0; i < database.size(); ++i) {
            String entry = lowerCaseDB.get(i);
            String[] parts = entry.split(";");

            String[] titles = database.get(i).split(";");
            // The .contains() method determines whether a given phrase or word appears in a string
            if (parts[1].contains(searchQuery) || parts[2].contains(searchQuery)) {
                matchingTitles.add(titles[1]);
            }
        }

        // TODO: Make sure to add titles from the database, not the lowercase database
        // Convert the result into an array and return it.
        String[] matchingTitlesArray = matchingTitles.toArray(new String[matchingTitles.size()]);
        return matchingTitlesArray;
    }

    public static String getDescription(int titleIndex) {
        ArrayList<String> database = loadDatabase();
        String[] parts = database.get(titleIndex).split(";");
        return parts[2];
    }

    private static void handleClient(Socket clientSocket) {
        try (ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message = reader.readLine();
            
            /**
             * Logic of the following lines
             * There are two types of things I need to return from the server
             * 1. The titles of the pages that match the search query
             * 2. The description of the page that the user selected
             * 
             * Since I need to determine what the user needs from just one call of the readLine() method,
             * I can do that by checking if the message is a number or not.
             * 
             * If the message is a number, it means that the user has selected a page and I need to return
             * the description of that page.
             * Otherwise, just return the titles that match the search query.
             */
            try {
                int titleIndex = Integer.parseInt(message); // If the parse is successful, query for the description

                // Send the description to the client
                writer.writeObject(getDescription(titleIndex));
            
            } catch (NumberFormatException e) { // If the parse is unsuccessful, query for titles
                // Search find the titles that match the search query
                String[] matchingTitles = searchForTitles(message);

                // Send the titles to the client
                writer.writeObject(matchingTitles);
            }



            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

