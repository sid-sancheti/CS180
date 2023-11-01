package Week05;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String condition;
        
        
        do {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();

            for (int i = input.length() - 1; i >= 0; --i)
                System.out.print(input.charAt(i));

            System.out.println("\nAgain?");
            condition = scanner.nextLine();

        } while (condition.charAt(0) == 'Y');
        
        scanner.close(); // Close the scanner object
    }
}

