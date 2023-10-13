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
 * @author Siddharth Sancheti, Section 33
 * @version October 12, 2023
 */
public class Movies {

    private static final String INVALID_RATING = "Rating must be one of the following: PG, G, PG-13, NR, R";
    private static final String INVALID_SCORE = "Score must be between 0 and 10";
    private static final String INVALID_DURATION = "Duration must be between 0 and 300";
    private static final String INVALID_YEAR = "Year must be before 2024";
    
    private ArrayList<ArrayList<String>> lineList = new ArrayList<ArrayList<String>>();

    /**
     * Creates a new file called ratings.txt that contains all the movie titles and
     * genres with the rating specified in the parameter.
     * @param rating
     */
    public void makeRatingFile(String rating, ArrayList<ArrayList<String>> lineListPointer) throws IOException {
    	
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))) {
            for (ArrayList<String> movie : lineListPointer) {
            	if (movie.get(2).equals(rating)) {
            		bw.write(movie.get(0));	
                    bw.newLine();
                    bw.flush();
            	}		
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public void makeScoreFile(double score, boolean greaterThan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))) {
            for (ArrayList<String> movie : lineList) {
            	if (greaterThan) {
	            	if (Double.parseDouble(movie.get(2)) > score) {
	            		bw.write(movie.get(0));
	            		bw.newLine();
                        bw.flush();
	            	}
            	} else {
            		if (Double.parseDouble(movie.get(2)) <= score) {
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))) {
            for (ArrayList<String> movie : lineList) {
            	if (greaterThan) {
	            	if (Double.parseDouble(movie.get(4)) > duration) {
	            		bw.write(movie.get(0));
	            		bw.newLine();
                        bw.flush();
	            	}
            	} else {
            		if (Double.parseDouble(movie.get(4)) <= duration) {
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))) {
            for (ArrayList<String> movie : lineList) {
            	if (Integer.parseInt(movie.get(1)) == year) {
            		bw.write(movie.get(0));
            		bw.newLine();
                    bw.flush();
            	}		
            }
            System.out.println("Ratings.txt has been created and the contents have been written to it."); // TODO: Remove this line
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
    public ArrayList<ArrayList<String>> getLineList() { return lineList; }
    public void addLine(ArrayList<String> line) { lineList.add(line); }

    /**
     * I have determined the issue. Outside the try-catch statement, the data gets lost. 
     * Let's add all the method calls for makeFiles into the try-catch statement
     */
    public static void main(String[] args) throws IOException {
        Movies movies = new Movies();
        
        // Reading every line in the data file and storing it in an ArrayList
        try (BufferedReader bufReader = new BufferedReader(new FileReader("movieData.txt"))) {
	        String line = bufReader.readLine();
            int i = 0; // TODO: Remove this line
	        while (line != null) {
                
                ArrayList<String> singleMovie = new ArrayList<String>();
	            String[] lineArray = line.split(",");
	            singleMovie.add(lineArray[0] + " | " + lineArray[4]);
	            singleMovie.add(lineArray[1]);
	            singleMovie.add(lineArray[2]);
	            singleMovie.add(lineArray[3]);
	            singleMovie.add(lineArray[5]);

                movies.addLine(singleMovie);

                System.out.println(movies.getLineList().get(i)); // TODO: Remove this line

                // Clear all the data from singleMovie so that it can be used again.
                singleMovie.clear();
                // Read the next line.
	            line = bufReader.readLine();
                i++; // TODO: Remove this line
	        }
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        // TODO: Remove the bottom five lines.
        ArrayList<ArrayList<String>> replica = movies.getLineList();
        System.out.println("\nThis is the replicas:");
        for (ArrayList<String> movie : replica) {
            System.out.println(movie);
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
        
        rating = "PG";
        duration = 100;
        greaterThan = false;
        year = 2010;
        score = 8.9;

        movies.makeRatingFile(rating, movies.getLineList());
        movies.makeDurationFile(duration, greaterThan);
        movies.makeScoreFile(score, greaterThan);
        movies.makeYearFile(year);
    }


}