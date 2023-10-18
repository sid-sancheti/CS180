package Week9.Challenge;
/**WrongRideException.java
 * 
 * Thrown when it's the wrong ride
 * 
 * @author Siddharth Sancheti
 * @version October 17, 2023
 */

public class WrongRideException extends Exception {
    public WrongRideException(String message) {
        super(message);
    }
}
