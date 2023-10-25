package Week10.Challenge;

import java.io.*;

public class MapNavigator extends Thread {
    private static int currentRow;
    private static int currentColumn;
    private static int moveNumber;
    private static boolean started;
    private static char[][] map;
    private int playerNumber;
    private String fileName;

    private static final Object lock = new Object();

    public MapNavigator(int playerNumber, String fileName) {
        this.playerNumber = playerNumber;
        this.fileName = fileName;
    }

    public void run() {
        // If the file does not exist, throw an error and exit the method.
        try {
            verifyFileExists();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            return;
        }

        // Only want one thread to create the map.
        synchronized (lock) {
            while (!started) {
                started = true;
                createMap();
            }
        }

        // Have every thread read their files
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = br.readLine();
            while (line != null) {
                int move = Integer.parseInt(line);

                // Verify that the move is valid.
                if (move > 4 || move < 1) {
                    System.out.println("Error, invalid input!");
                } else { // If move is valid, continue
                    
                }

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /**
     * Verify that the specified file exists. 
     * If it does not, print "File [fileName] does not exist!" 
     */
    private void verifyFileExists() throws FileNotFoundException {
        // Verify that the file exists
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File " + fileName + " does not exist!");
        }
    }

    /**
     * Create the map.
     */
    public synchronized void createMap() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column ++) {
                // Set every point in the map to a space.
                map[row][column] = ' ';
            }
        }

        // Set the starting position of the player.
        map[4][4] = 'X';
    }

    /**
     * Print the map.
     * 
     * Does not to be synchronized in run method
     */
    public synchronized void printMap() {
        System.out.println("Move Number: " + moveNumber);
        System.out.println("Player: " + playerNumber);
        // TODO: Add the move direction
        System.out.println("Move: " + "TODO");
        for (int row = 0; row < 10; row++) {
            System.out.print("[");
            for (int column = 0; column < 10; column ++) {
                System.out.print(map[row][column]);
                if (column == 8) {
                    System.out.println("]");
                } else {
                    System.out.print("|");
                }
            }

            // Print the hyphens that separate the rows.
            for (int i = 0; i < 21; i++) {
                System.out.print("-");
            }

            System.out.println();
        }
    }

    /**
     * Notes: 
     * If a move will leave the valid range of indexes in the array, loop back around. 
     * That is, incrementing 9 would result in 0, or decrementing 0 would result in 9.
     * 
     *   Solution: just mod the increment by 10.
     *   (-1 mod 10 = 9)
     * 
     * Programs that use excessively broad solutions for race conditions will not be considered 
     * concurrent and will not receive any credit.
     * 
     * Class must extend Thread.
     * 
     * Implement static variable correctly.
     * 
     * If a move is not one of the valid options (1, 2, 3, or 4), print "Error, invalid input!" 
     * and do not modify the map for that turn. 
     * 
     * The order in which the moves will vary, but the final position of the X should be the same
     * every time we run the program.
     * 
     * Questions:
     * 1. Are we allowed to create more fields?
     * 2. Will the output be in the terminal or in a file?
     * 
     */
}
