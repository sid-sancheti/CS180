package Week8;
/**InvalidInputException.java
 * 
 * Custom exception class for invalid input.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 12, 2023
 */
public class InvalidInputException extends Exception {
	
	public InvalidInputException() { super(); }
    public InvalidInputException(String message) { super(message); }

}