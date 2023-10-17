package Week9.Debugging;
import java.util.Scanner;
/**HelloLab.java
 * 
 * @author Siddharth Sancheti
 * @version October 17, 2023
 */
public class HelloLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello there!java Please enter your Lab number in the form LXX:");
        int labNumber = Integer.parseInt(scanner.nextLine().substring(1));
        System.out.printf("Welcome to L%d!",labNumber);

        scanner.close();
    }
}
