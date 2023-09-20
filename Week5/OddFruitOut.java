package Week5;
import java.util.Scanner;
/**
 * Determine if a list of fruits is entered in alphabetical order.
 * 
 * @author Siddharth Sancheti - Section 33
 * @version September 19, 2023
 *
 */
public class OddFruitOut {
    
    public static void main(String[] args) {
    	
    	String welcome = "Hello, welcome to the Odd Fruit Out game!";
        String prompt = "Please enter a String of fruits separated by commas.";
        String result = "The odd fruit out is fruit number ";
        
    	System.out.println(welcome); // Print the welcome message. 
    	System.out.println(prompt);
    	
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.nextLine();
    	
    	//Adding a comma to the end of the input string so that my code doesn't break.
    	//My code relies on the index of commas. I need this to compare the last two words.
    	input += ",";
    	
    	scanner.close();
    	
    	boolean condition = true; // If .compareToMethod returns 0 or 1, remain true. Else false.
    	int counter = 1; // Keeps track of all values 
    	
    	do {
    		String firstWord = input.substring(0, input.indexOf(','));

    		input = input.substring(input.indexOf(',') + 1);
    		
    		String secondWord = input.substring(0, input.indexOf(','));
    		
    		if (secondWord.compareTo(firstWord) < 0) {
    			condition = false;
    			System.out.printf("%s%d: %s", result, counter, firstWord);
    		}
    			
    		++counter; // Add one to the counter to represent the index of the next word
    		
    	}while (condition);
    	
    }
    
    /** && countCharacter(input, ',') > 0
     * Return the number of times a character occurs in a string.
     * 
     * @param input The string to search
     * @param targetChar The target char we are trying to count the occurrence of.
     * @return The number of times a char appears in a string.
     */
    public static int countCharacter(String input, char targetChar) {
        return (int) input.chars().filter(ch -> ch == targetChar).count();
    }
}
