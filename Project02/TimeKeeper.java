package Project02;
import java.util.Scanner;
/**
 * Project 02 - TimeKeeper
 * 
 * Writing a lab management application.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 7, 2023
 * 
 * 
 */
public class TimeKeeper {
    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab "; 
    private static String labLocationPrompt = "Enter the location of the lab:"; 
    private static String reservationTimePrompt = "Enter the time of the reservation:"; 
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:"; 
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:"; 
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: "; 
    
    
    private static String initializeMenu = "1. Initialize Application\n" +
                                        "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
                                "2. List Labs by Availability\n" +
                                "3. List Labs by Reservation\n" +
                                "4. Add a Reservation\n" +
                                "5. Remove a Reservation\n" +
                                "6. Modify a Reservation\n" +
                                "7. Calculate Statistics\n" +
                                "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
                                            "2. Total Utilization\n" +
                                            "3. Available seats\n" +
                                            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	LabManager labManager = null; // Declaring the variable here for scope.
    	boolean condition;
    	
    	System.out.println(welcomePrompt);
    	
    	while (true) {
	    	System.out.println(initializeMenu);
	    	int input = scan.nextInt();
	    	scan.nextLine();
	    	
	    	if (input == 1) {
	    		condition = true;
	    		
	    		// Lab One Information
	    		System.out.println(enterLabCapacity + "1: ");
	    		int oneCapacity = scan.nextInt();
	    		scan.nextLine();
	    		System.out.println(enterLabLocation + "1: ");
	    		String oneLocation = scan.nextLine();
	    		
	    		// Lab Two Information
	    		System.out.println(enterLabCapacity + "2: ");
	    		int twoCapacity = scan.nextInt();
	    		scan.nextLine();
	    		System.out.println(enterLabLocation + "2: ");
	    		String twoLocation = scan.nextLine();
	    		
	    		// Lab Three Information
	    		System.out.println(enterLabCapacity + "3: ");
	    		int threeCapacity = scan.nextInt();
	    		scan.nextLine();
	    		System.out.println(enterLabLocation + "3: ");
	    		String threeLocation = scan.nextLine();
	    		
	    		labManager = new LabManager(new Lab(oneCapacity, oneLocation), new Lab(twoCapacity, twoLocation),
	    				new Lab(threeCapacity, threeLocation));
	    		
	    		break;
	    	} else if (input == 2) {
	    		condition = false;
	    		break;
	    	} else 
	    		System.out.println(invalidInput);
    	}
    	
    	// Main loop that controls the main application
    	while (condition) {
    		System.out.println(ongoingMenu);
    		int input = scan.nextInt();
    		scan.nextLine();
    		
    		if (input == 1) {
    			printLabSchedule(labManager);
    		} else if (input == 2) {
    			System.out.println(labManager.listAvailableLabs());
    		} else if (input == 3) {
    			System.out.println(labManager.listReservedLabs());
    		} else if (input == 4) {
    			System.out.println(labLocationPrompt);
    			String location = scan.nextLine();
    			System.out.println(reservationTimePrompt);
    			String time = scan.nextLine();
    			System.out.println(reservationNamePrompt);
    			String name = scan.nextLine();
    			System.out.println(reservationEnrollmentPrompt);
    			int enrollment = scan.nextInt();
    			scan.nextLine();
    			
    			System.out.println(labManager.addReservation(location, time, name, enrollment));
    		} else if (input == 5) {
    			System.out.println(labLocationPrompt);
    			String location = scan.nextLine();
    			System.out.println(reservationTimePrompt);
    			String time = scan.nextLine();
    			
    			System.out.println(labManager.removeReservation(location, time));
    		} else if (input == 6) {
    			System.out.println(labLocationPrompt);
    			String location = scan.nextLine();
    			System.out.println(reservationTimePrompt);
    			String time = scan.nextLine();
    			System.out.println(reservationNameUpdate);
    			String name = scan.nextLine();
    			System.out.println(reservationEnrollmentUpdate);
    			int enrollment = scan.nextInt();
    			scan.nextLine();
    			
    			System.out.println(labManager.modifyReservation(location, time, name, enrollment));
    		} else if (input == 7) {
    			// This will require its own infinite loop.
    			while (true) {
    				System.out.println(statisticsMenu);
    				input = scan.nextInt();
    				scan.nextLine();
    				
    				if (input == 1) {
    					System.out.println(totalCapacity + labManager.calculateTotalCapacity());
    				} else if (input == 2) {
    					System.out.printf(totalUtilization + "%.2f\n", labManager.calculateTotalUtilization());
    				} else if (input == 3) {
    					System.out.println(availableSeats + labManager.calculateAvailableSeats());
    				} else if (input == 4) {
    					break;
    				} else
    					errorMessage();
    					
    			}
    			
    			
    		} else if (input == 8) {
    			// Terminate the program and print the exit message.
    			condition = false; 
    		} else {
    			errorMessage();
    		}
    	}
    	
    	scan.close();
    	System.out.println(exitMessage);
    }
    
    /**Ongoing Menu -> 1
     * Prints the toString for all the labs in labManager
     * 
     * @param labManager The LabManager responsible for managing the labs.
     */
    public static void printLabSchedule(LabManager labManager) {
    	System.out.println("\n" + labManager.getLabOne().toString());
    	System.out.println(labManager.getLabTwo().toString());
    	System.out.println(labManager.getLabThree().toString());	
    }
    
    
    /**
     * Prints the error message for an invalid input.
     */
    public static void errorMessage() {
    	System.out.println(invalidInput);
    }
}
