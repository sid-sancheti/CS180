package Week8;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.io.File;
/**Movies.java
 * 
 * A program that reads movies from a text file, sorts them, then writes them to another text file.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 13, 2023
 */
public class Movies {

    private static final String INVALID_RATING = "Rating must be one of the following: PG, G, PG-13, NR, R";
    private static final String INVALID_SCORE = "Score must be between 0 and 10";
    private static final String INVALID_DURATION = "Duration must be between 0 and 300";
    private static final String INVALID_YEAR = "Year must be before 2024";
    
    private ArrayList<List<String>> lineList = new ArrayList<List<String>>();

    /**
     * Creates a new file called ratings.txt that contains all the movie titles and
     * genres with the rating specified in the parameter.
     * @param rating
     */
    public void makeRatingFile(String rating) throws IOException {

    	File file = new File("ratings.txt");
        if (file.exists()) {
        	file.delete();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt", true))) {
            for (List<String> movie : this.lineList) {
            	if (movie.get(2).equals(rating)) {
            		bw.write(movie.get(0));	
                    bw.newLine();
                    bw.flush(); // Flush the buffered writer and write to the file
            	}		
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeScoreFile(double score, boolean greaterThan) {
        File file = new File("scores.txt");
        if (file.exists()) {
        	file.delete();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt", true))) {
            for (List<String> movie : lineList) {
            	if (greaterThan) {
	            	if (Double.parseDouble(movie.get(4)) > score) {
	            		bw.write(movie.get(0));
	            		bw.newLine();
                        bw.flush();
	            	}
            	} else {
            		if (Double.parseDouble(movie.get(4)) <= score) {
            			bw.write(movie.get(0));
            			bw.newLine();
                        bw.flush();
            		}
            	}
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeDurationFile(int duration, boolean greaterThan) {
        File file = new File("durations.txt");
        if (file.exists()) {
        	file.delete();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("durations.txt", true))) {
            for (List<String> movie : lineList) {
            	if (greaterThan) {
	            	if (Integer.parseInt(movie.get(3)) > duration) {
	            		bw.write(movie.get(0));
	            		bw.newLine();
                        bw.flush();
	            	}
            	} else {
            		if (Integer.parseInt(movie.get(3)) <= duration) {
            			bw.write(movie.get(0));
            			bw.newLine();
                        bw.flush();
            		}
            	}
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeYearFile(int year) {
        // Delete the file so we can start from scratch.
        File file = new File("years.txt");
        if (file.exists()) {
        	file.delete();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("years.txt", true))) {
            for (List<String> movie : lineList) {
            	if (Integer.parseInt(movie.get(1)) == year) {
            		bw.write(movie.get(0));
            		bw.newLine();
                    bw.flush();
            	}		
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    public void validateInput(String rating, double score, int duration, int year) throws InvalidInputException {

    	// Validate rating
    	if (!(rating.equals("G") || rating.equals("PG") || rating.equals("PG-13") || 
    			rating.equals("R") || rating.equals("NR")))
    			throw new InvalidInputException(INVALID_RATING);
    	
    	// Validate score
    	if (!(score >= 0 && score <= 10))
    		throw new InvalidInputException(INVALID_SCORE);
    	
    	// Validate duration
    	if (!(duration > 0 && duration < 300))
    		throw new InvalidInputException(INVALID_DURATION);
    	
    	// Validate year
    	if (!isFourDigits(year))
    		throw new InvalidInputException(INVALID_YEAR);
    }
    
    public boolean isFourDigits(int year) {
        return year >= 1000 && year <= 2023;
    }
    
    
    // ArrayList lineList getter and setter method.
    public ArrayList<List<String>> getLineList() { return lineList; }
    public void setLineList(ArrayList<List<String>> lineList) { this.lineList = lineList; }

    /**
     * I have determined the issue. Outside the try-catch statement, the data gets lost. 
     * Let's add all the method calls for makeFiles into the try-catch statement
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in); 
        

        System.out.println("Enter Movie Rating:");     
        String rating = scan.nextLine();
        
        System.out.println("Enter Movie Duration:"); 
        int duration = scan.nextInt(); 
        scan.nextLine();
        
        System.out.println("Enter Movie Score:"); 
        double score = scan.nextDouble(); 
        scan.nextLine();
        
        System.out.println("Will the filter be greater or less than?");
        boolean greaterThan = scan.nextBoolean(); 
        scan.nextLine();
        
        System.out.println("Enter Movie Year: ");
        int year = scan.nextInt(); 
        scan.nextLine();

        scan.close();

        Movies movies = new Movies();

        // Validate the inputs.
        try {
        	movies.validateInput(rating, score, duration, year);
        } catch (InvalidInputException e) {
        	e.printStackTrace();
        }

        // Determine whether the data file exists.
        File file = new File("movieData.txt");
        if (!file.exists()) {
        	throw new FileNotFoundException("movieData.txt does not exist.");
        }

        // Reading every line in the data file and storing it in an ArrayList
        BufferedReader bufReader = new BufferedReader(new FileReader("movieData.txt"));
        
        // Counter for the number of lines in the data file.
        int lines = 0;
        // The issue was with the .clear() method. The pointer was removed.
	    while (bufReader.readLine() != null) { ++lines; }
        // Close the bufReader cause we reached the end of the file.
        bufReader.close();

        // Make a new bufReader to read the file again.
        bufReader = new BufferedReader(new FileReader("movieData.txt"));

        ArrayList<List<String>> mainList = new ArrayList<List<String>>(lines);      
        
        for (int i = 0; i < lines; ++i) {
            // Read a line from the file
            String line = bufReader.readLine();
            // Split the line into an array of strings based on the commas.
            String[] lineArray = line.split(",");
            // Add the line to the mainList.
            mainList.add(Arrays.asList(lineArray[0] + " | " + lineArray[4], lineArray[1], lineArray[2],
                lineArray[3], lineArray[5]));
        }

        // Set the lineList
        movies.setLineList(mainList);

        // Closed the buffered reader.
        try {
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        movies.makeRatingFile(rating);
        movies.makeDurationFile(duration, greaterThan);
        movies.makeScoreFile(score, greaterThan);
        movies.makeYearFile(year);
    }

}