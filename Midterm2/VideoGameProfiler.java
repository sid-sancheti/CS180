package Midterm2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoGameProfiler {
    public static final String INPUT_PROMPT = "What is the name of the file you would like to read from?";
    public static final String INPUT_ERROR = "The file doesn't exist!";
    public static final String OUTPUT_PROMPT = "What is the name of the output file?";

    public static final String THRESHOLD_PROMPT = "Enter the ratings threshold filter:";

    public static final String OUTPUT_SUCCESS = "The file was written to!";

    public static final String OUTPUT_ERROR = "There was an error writing to the file.";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(INPUT_PROMPT);
        String input = scan.nextLine();

        String[] dataset = readFile(input);

        // Terminate the program if the dataset is null
        if (dataset == null) {
            return;
        }

        System.out.println(THRESHOLD_PROMPT);
        double threshold = scan.nextDouble();
        scan.nextLine();

        System.out.println(OUTPUT_PROMPT);
        input = scan.nextLine();

        scan.close();


        writeFile(dataset, threshold, input);
        
    }

    public static String[] readFile(String filename)  {
        String[] dataset = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            ArrayList<String> datasetList = new ArrayList<String>();

            String line = br.readLine();
            while (line != null) {
                datasetList.add(line);
                line = br.readLine();
            }

            dataset = new String[datasetList.size()];
            dataset = datasetList.toArray(dataset);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println(INPUT_ERROR);
            return null;
        }

        return dataset;
    }

    public static boolean writeFile(String[] dataset, double threshold, String filename) {

        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : dataset) {
                String[] split = line.split(",");

                if (Double.parseDouble(split[3]) >= threshold) {
                    bfw.write(line);
                    bfw.newLine();
                    bfw.flush();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println(OUTPUT_ERROR);
            return false;
        }

        System.out.println(OUTPUT_SUCCESS);
        return true;
    }
}
