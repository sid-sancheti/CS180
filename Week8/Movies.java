package Week8;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    public void makeRatingFile(String rating) {
        //TODO: create ratings.txt
        // Create a file called ratings.txt. Account for exceptions.
        try {
            File file = new File("ratings.txt");
            if (file.)
        }        

    }

    public void makeScoreFile(double score, boolean greaterThan) {
        //TODO: create scores.txt

    }

    public void makeDurationFile(int duration, boolean greaterThan) {
        //TODO: create durations.txt

    }

    public void makeYearFile(int year) {
        //TODO: create years.txt

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
    	if (!(year < 2024 && isFourDigits(year)))
    		throw new InvalidInputException(INVALID_YEAR);
    }
    
    public boolean isFourDigits(int year) {
        return year >= 1000 && year <= 9999;
    }


    public static void main(String[] args) {
        Movies movies = new Movies();
        
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
