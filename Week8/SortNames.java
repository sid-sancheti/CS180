package Week8;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Summer 2022</p>
 *
 * @author Purdue CS 
 * @version June 13, 2022
 */
public class SortNames {

    /**
     * Reads names from a file and returns them as an ArrayList.
     * 
     * @param fileName The name of the file to read from.
     * @return The array list of names.
     * @throws FileNotFoundException
     */
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))){
        	
            do {
                String line = bfr.readLine(); // Read a line from the file
                if (line == null) { break; } // If the line is null, break out of the loop
                list.add(line); // Add the line to the array list
            } while (true); // Repeat until the end of the file
            
        } catch (FileNotFoundException e) {
        	throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return list;
    }

    /**
     * Writes the names to a file after sorting them.
     * 
     * @param fileName The name of the file to write to.
     * @param names The array list of names to write.
     * @throws FileNotFoundException
     */
    public static void writeFile(String fileName, ArrayList<String> names) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))) {
            for (String name : names) { // For each name in the array list
                pw.println(name); // Write the name to the file
            }
        } catch (FileNotFoundException e) {
            throw e; // Re-throw the FileNotFoundException
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> names;
        System.out.println("Enter filename with unsorted names");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();

        sc.close();

        try {
            names = readFile(filename);
            Collections.sort(names);
            writeFile(null, names);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        System.out.println("Sorted names written to sorted_names.txt");
    }
}
