package Week04;
import java.util.Scanner;
/**HW-04 --FoodRecommender
 * 
 * Help the user find food according to their preferences. 
 * Program branches off to specific options based on user choices, 
 * eventually recommending a specific type of food.
 * 
 * @author Siddharth Sancheti, Lab 33
 *
 * @version September 12, 2023
 */
public class FoodRecommender {

    public static final String WELCOME_MESSAGE = "Welcome to the Food Recommender!";
    public static final String INITIAL_FOOD = "Do you want to have good food?";
    public static final String SPICY = "Do you like spicy food?";
    public static final String CHINESE = "Do you want to try spicy Chinese Food?";
    public static final String INDIAN = "Do you want to try spicy Indian Food?";
    public static final String ETHIOPIAN = "Do you want to try spicy Ethiopian food?";
    public static final String SEA_FOOD = "Do you like sea food?";
    public static final String SUSHI = "Do you like traditional sushi?";
    public static final String BEEF = "Do you like beef?";
    public static final String PORK = "Do you like pork?";
    public static final String LAMB = "Do you like lamb?";
    public static final String SOUP = "Do you want soup with beef?";
    public static final String GOODBYE_MESSAGE = "Thank you for using" +
            " the Food Recommender!";


    public static final String HOT_POT = "Sichuan hot pot is a great choice!";
    public static final String VINDALOO = "Vindaloo is a great choice!";
    public static final String DORO_WAT = "Doro wat is very good!";
    public static final String PENNE = "Penne all’arrabbiata is delicious!";
    public static final String SALMON_SUSHI = "Salmon sushi will fulfill you!";
    public static final String BBQ_SUSHI = "BBQ bacon sushi is a great combination of sushi and meat!";
    public static final String FRUIT_SALAD = "Sweet fruit salad is a great choice!";
    public static final String PORK_QUESADILLAS = "Pork quesadillas are very tasty!";
    public static final String LAMB_CHOPS = "Rosemary roast lamb chops are a great choice!";
    public static final String BIBIMBAP = "Beef and veggie bibimbap will fulfill you!";
    public static final String PHO_SOUP = "Vietnamese beef and noodle pho soup is very good!";
    
    public static void main(String[] args) {
    	
    	// Creating a scanner object
    	Scanner scanner = new Scanner(System.in);
    	
    	// Welcome message
    	System.out.println(WELCOME_MESSAGE);
    	
    	String input = "";
    	
    	System.out.println(INITIAL_FOOD);
    	input = scanner.nextLine().toLowerCase();
    	/**
    	 * Beginning the embedded if-else-if statements here
    	 */
    	if(input.equals("yes")) {
    		
    		// SPICY FOOD
    		System.out.println(SPICY);
    		input = scanner.nextLine().toLowerCase();
    		
    		if (input.equals("yes")) { // User wants spicy food.
    			System.out.println(CHINESE);
    			input = scanner.nextLine().toLowerCase();
    			if (input.equals("yes")) // User wants chinese food
    				System.out.println(HOT_POT); // Recommend hotpot.
    			else { // User does not want chinese food.
    				System.out.println(INDIAN);
    				input = scanner.nextLine().toLowerCase();
    				if (input.equals("yes"))
    					System.out.println(VINDALOO);
    				else {
    					System.out.println(ETHIOPIAN);
        				input = scanner.nextLine().toLowerCase();
        				if (input.equals("yes"))
        					System.out.println(DORO_WAT);
        				else
        					System.out.println(PENNE);
    				}
    			}
    		} else { // User does not want spicy food.
    			System.out.println(SEA_FOOD);
				input = scanner.nextLine().toLowerCase();
				if (input.equals("yes")) { // User wants sea food
					System.out.println(SUSHI);
					input = scanner.nextLine().toLowerCase();
					if(input.equals("yes"))
						System.out.println(SALMON_SUSHI); // Recommend salmon sushi if they like traditional sushi
					else // Recommend BBQ sushi if they don't like traditional sushi
						System.out.println(BBQ_SUSHI);
				} else { // User does not want sea food.
					System.out.println(BEEF);
					input = scanner.nextLine().toLowerCase();
					if(input.equals("yes")) { // User wants beef.
						System.out.println(SOUP);
						input = scanner.nextLine().toLowerCase();
						if(input.equals("yes")) // User wants soup.
							System.out.println(PHO_SOUP);
						else // User does not want soup
							System.out.println(BIBIMBAP);
					} else { // User does not want beef
						System.out.println(PORK);
						input = scanner.nextLine().toLowerCase();
						if(input.equals("yes")) // User wants pork, recommend pork quesadillas.
							System.out.println(PORK_QUESADILLAS);
						else { // User does not want lamb
							System.out.println(LAMB);
							input = scanner.nextLine().toLowerCase();
							if (input.equals("yes")) 
								System.out.println(LAMB_CHOPS); // Recommend lamb chops.
							else
								System.out.println(FRUIT_SALAD); // Recommend fruit salad
						}
					}
				}	
    		}
    	}
    	
    	// We will always print his message at the end of the program.
    	// Therefore, it will not be embedded in any if-else statements.
    	System.out.println(GOODBYE_MESSAGE);
    	
    	scanner.close(); // Closing the scanner object.
    } // End of the main method
   
} // End of the class

