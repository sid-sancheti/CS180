package Week11.Challenge;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

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

    private static ArrayList<String> searchDatabase(String searchQuery) {
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

            // The .contains() method determines whether a given phrase or word appears in a string
            if (parts[1].contains(searchQuery) || parts[2].contains(searchQuery)) {
                matchingTitles.add(database.get(i));
            }
        }

        return matchingTitles;
    }

    private static void handleClient(Socket clientSocket) {
        try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message = reader.readLine();

            // Search find the titles that match the search query
            ArrayList<String> matchingTitles = searchDatabase(message);

            // Send the titles to the client
            for (String title : matchingTitles) {
                writer.println(title);
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

