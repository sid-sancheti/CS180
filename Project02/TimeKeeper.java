package Project02;

/**
 * Project 02 - TimeKeeper
 * 
 * Writing a lab management application.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 3, 2023
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

    }
}
