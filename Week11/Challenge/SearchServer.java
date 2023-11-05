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
            Socket clientSocket = serverSocket.accept();
 
            while (true) {

                try (ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream())) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String searchQuery = reader.readLine();
                    writer.writeObject(searchForTitles(searchQuery));

                    String title = reader.readLine();
                    writer.writeObject(getDescription(title));

                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

    public static String getDescription(String title) {
        String description = "";
        ArrayList<String> database = loadDatabase();
        for (String entry : database) {
            String[] parts = entry.split(";");
            if (parts[1].equals(title)) {
                description = parts[2];
            }
        }

        return description;
    }

}

