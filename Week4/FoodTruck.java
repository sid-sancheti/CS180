package Week4;
import java.util.Scanner; 

/**
 * A Food Truck order program.
 *
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 04 -- Debugging
 *
 * @author Purdue CS
 * @version September 12, 2023
 */
public class FoodTruck {
	public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to place an order? (yes or no)");
        String orderStatus = scanner.nextLine();
        
        String cookMethod = "";
        String dish = "";
        
        if (orderStatus.equals("no")) {            
            System.out.println("Okay, have a nice day!");            
        } else if (orderStatus.equals("yes")) {
        	System.out.println("What would you like to order?");
            
            System.out.println("1. Lamb"); 
            System.out.println("2. Pork");
            System.out.println("3. Chicken");
            System.out.println("4. Vegetables");
            
            int meal = scanner.nextInt();
            scanner.nextLine();
            
            // Store the type of meal we cook in dish.
            dish = switch(meal) {
	            case 1 -> "Lamb";
	            case 2 -> "Pork";
	            case 3 -> "Chicken";
	            case 4 -> "Vegetables";
	            default -> "";
            };
            
            // Printing the error message if user inputs an invalid value for the dish.
            if (dish.isEmpty())
            	System.out.println("Input Error! Valid menu options are from 1 - 4.");
            else { // If the input is value, continue.
	            System.out.println("How would you like it cooked?");
	            System.out.println("1. Fried"); 
	            System.out.println("2. Boiled");
	
	            int method = scanner.nextInt();
	            scanner.nextLine(); // Getting rid of the new line character.
	            
	            cookMethod = switch(method) {
		            case 1 -> "Fried";
		            case 2 -> "Boiled";
		            default -> "";
	            };
	            
	            //Printing an error message if the user inputed an invalid number.
	            if(cookMethod.isEmpty())
	            	System.out.println("Input Error! Valid cooking options are 1 or 2.");
            }
            
            // Printing the final value.
            if(dish.isEmpty() || cookMethod.isEmpty())
            	System.out.println("\nWe couldn't complete the order, sorry!");
            else
            	System.out.printf("\nYou have ordered %s %s!", cookMethod, dish);
            
            } else {
            	String err  = "Input Error! Valid options are yes or no.";
            	System.out.println(err); 
            }
        
        scanner.close(); // Close the scanner object.
        
	} // End of the main method
} // End of the class