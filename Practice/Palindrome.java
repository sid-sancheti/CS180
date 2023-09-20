package Practice;
import java.util.Scanner;
/**Program determines whether a string is a palindrome using recursion.
 * 
 * @author Siddharth Sancheti
 * 
 * @version September 11, 2023
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		
		String s = scan.nextLine();
		
		if (isPalindrome(s))
			System.out.println("The string " + s + " is a palindrome.");
		
		else
			System.out.println("The string " + s + " is not a palindrome.");
			
		scan.close();
	}
	
	/**Determines whether a string is a palindrome using recusion.
	 * 
	 * @param s
	 * @return True if the string is a palindrome. Else, return false.
	 */
	public static boolean isPalindrome(String s) {
		
		// Base case
		if (s == null || s.length() < 2)
			return true;
		
		if (s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrome(s.substring(1,s.length() - 1));
		
		return false;
	}

}
