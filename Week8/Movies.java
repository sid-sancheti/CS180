package Week8;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**Movies.java
 * 
 * A program that reads movies from a text file, sorts them, then writes them to another text file.
 * 
 * @auther Siddharth Sancheti, Section 33
 * @version October 11, 2023
 */
public class Movies {

    private static final String INVALID_RATING = "Rating must be one of the following: PG, G, PG-13, NR, R";
    private static final String INVALID_SCORE = "Score must be between 0 and 10";
    private static final String INVALID_DURATION = "Duration must be between 0 and 300";
    private static final String INVALID_YEAR = "Year must be before 2024";
    
    // TODO: Organize the data using a 2D ArrayList.
    private ArrayList<ArrayList<String>> lineList = new ArrayList<ArrayList<String>>();

    /**
     * Creates a new file called ratings.txt that contains all the movie titles and genres with the rating specified in the parameter.
     * @param rating
     */
    public void makeRatingFile(String rating) throws IOException{
    	
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))){
            for (ArrayList<String> movie : lineList) {
            	if (movie.get(2).equals(rating)) {
            		bw.write(movie.get(0));
            	}		
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeScoreFile(double score, boolean greaterThan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))){
            for (ArrayList<String> movie : lineList) {
            	if (greaterThan) {
	            	if (Double.parseDouble(movie.get(2)) > score) {
	            		bw.write(movie.get(0));
	            	}
            	} else {
            		if (Double.parseDouble(movie.get(2)) <= score) {
            			bw.write(movie.get(0));
            		}
            	}
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeDurationFile(int duration, boolean greaterThan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))){
            for (ArrayList<String> movie : lineList) {
            	if (greaterThan) {
	            	if (Double.parseDouble(movie.get(4)) > duration) {
	            		bw.write(movie.get(0));
	            	}
            	} else {
            		if (Double.parseDouble(movie.get(4)) <= duration) {
            			bw.write(movie.get(0));
            		}
            	}
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeYearFile(int year) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))){
            for (ArrayList<String> movie : lineList) {
            	if (Integer.parseInt(movie.get(1)) == year) {
            		bw.write(movie.get(0));
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
    
    /**
     * Adds a line from the data textfile to the arrayList.
     * Acts like a setter method.
     * 
     * @param line The line that needs to be added to the ArrayList.
     */
    public void appendLine(String line, int index) { lineList.get(index).add(line); }
    
    // ArrayList lineList getter method.
    public ArrayList<ArrayList<String>> getLineList() { return lineList; }
    

    public static void main(String[] args) throws IOException {
        Movies movies = new Movies();
        
        // Reading every line in the data file and storing it in an ArrayList
        try (BufferedReader bufReader = new BufferedReader(new FileReader("movieData.txt"))) {
	        String line = bufReader.readLine();
	        int index = 0;
	        while (line != null) {
	          String[] lineArray = line.split(",");
	          String movieAndGenre = lineArray[0] + " | " + lineArray[3];
	          String year = lineArray[1];
	          String rating = lineArray[2];
	          String duration = lineArray[4];
	          String score = lineArray[5];
	          
	          movies.appendLine(movieAndGenre, index);
	          movies.appendLine(year, index);
	          movies.appendLine(rating, index);
	          movies.appendLine(duration, index);
	          movies.appendLine(score, index);
	          
	          line = bufReader.readLine();
	          ++index;
	        }
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
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

        try { // validateInput method will throw an exception. Catch the exception and deal with it.
        	movies.validateInput(rating, score, duration, year);
        } catch (InvalidInputException e) {
        	e.printStackTrace();
        }
        
        movies.makeRatingFile(rating);
        movies.makeDurationFile(duration, greaterThan);
        movies.makeScoreFile(score, greaterThan);
        movies.makeYearFile(year);
    }


}
