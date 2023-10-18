package Week9.Challenge;
/**SpaceFullException.java
 * 
 * Thrown when the ride is full.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 */
public class SpaceFullException extends Exception {
    public SpaceFullException(String message) {
        super(message);
    }
}
