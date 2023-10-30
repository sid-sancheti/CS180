package Midterm2Practice;

import java.io.*;
import java.util.Scanner;
/**
 * @author Siddharth Sancheti, Section 33
 * @version October 30, 2023
 */

public class ColorMixer {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the filename of the color map.\r\n");
        String input = scan.nextLine();
        
        try {
            Color[] colors = readFile(input);

            System.out.print("Enter the filename to output the colors to.\r\n");
            input = scan.nextLine();

            writeFile(colors, input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scan.close();
    }

    public static Color[] readFile(String filename) throws FileNotFoundException {
        Color[] colors = null;

        File file = new File(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // Determine the number of lines a file using the line number reader
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
            // LineNumberReader will jump to the end of the file
            lineNumberReader.skip(Integer.MAX_VALUE);
            // Get the value of the lineNumberReader's current position
            int lines = lineNumberReader.getLineNumber();
            lineNumberReader.close();

            if (lines % 3 != 0) {
                return null;
            }

            colors = new Color[lines / 3];

            // Each group of three lines will have the RGB value for the color. 
            for (int i = 0; i < lines / 3; i++) {
                // Read the first line
                String red = br.readLine();
                // Read the second line
                String green = br.readLine();
                // Read the third line
                String blue = br.readLine();

                colors[i] = new Color(Integer.parseInt(red), Integer.parseInt(green), Integer.parseInt(blue));
            }
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }

        return colors;
    }

    public static boolean writeFile(Color[] colors, String filename) {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < colors.length; i++) {
                bfw.write(colors[i].toString());
                bfw.newLine();
                bfw.flush();
            }

            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }
}
