package Week05;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author sid_s
 *
 */
public class AutonomousRacecar {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int speed = 0;
        int seedValue;
        int newRandom;
        int threshold;

        System.out.println("Please enter the seed for the random number generator:");
        seedValue = scan.nextInt();
        scan.nextLine();

        System.out.println("Please enter the threshold:");
        threshold = scan.nextInt();
        scan.nextLine();
        
        scan.close();

        Random random = new Random(seedValue);

        System.out.println("Starting the car...");
        System.out.print("Current speed: "); 

        do {
        	newRandom = random.nextInt((threshold * 10)) + 1 ;
        	speed += 5;
        	System.out.print(speed + "...");
        } while (threshold < newRandom);
        
        System.out.print("Done!"); // Print "Done!" once the loop terminates.

        System.out.println("\nMaximum run speed: "  + speed);

    }
}
