package Week11.Challenge;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
/**SearchServer.java
 * 
 * This class is the server side of the search engine.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version November 1, 2023
 */
public class SearchServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            // Load the database from the "searchDatabase.txt" file
            ArrayList<String> database = loadDatabase();
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle client's requests in a new thread
                Thread clientThread = new Thread(() -> handleClient(clientSocket, database));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> loadDatabase() {
        ArrayList<String> database = new ArrayList<>();
        // TODO: Change Week11/Challege/searchDatabase.txt to the correct path
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

    private static void handleClient(Socket clientSocket, List<String> database) {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String searchQuery = in.readLine();
            System.out.println("Received search query from client: " + searchQuery);

            List<String> matchingTitles = new ArrayList<>();
            for (String entry : database) {
                String[] parts = entry.split(";");
                if (parts.length >= 2 && (parts[1].contains(searchQuery) || parts[2].contains(searchQuery))) {
                    matchingTitles.add(parts[1]);
                }
            }

            if (matchingTitles.isEmpty()) {
                out.println("No results found");
            } else {
                for (String title : matchingTitles) {
                    out.println(title);
                }
            }

            String selectedTitle = in.readLine();
            System.out.println("Client selected title: " + selectedTitle);

            for (String entry : database) {
                String[] parts = entry.split(";");
                if (parts.length >= 2 && parts[1].equals(selectedTitle)) {
                    out.println(parts[2]); // Send the description
                    break;
                }
            }

            in.close();
            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

