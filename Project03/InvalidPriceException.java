package Project03;
/**Throws an exception when the price is negative
 * 
 * @author Siddhath Sancheti, Section 33
 * @version October 16, 2023
 */
public class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }
}
