package Project03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.PatternSyntaxException;

/**Validator.java
 * 
 * Used to validate the data stored in the input log file.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 16, 2023
 */
public class Validator {

    public static int checkPrice(int price) throws InvalidPriceException {
        if (price < 0)
            throw new InvalidPriceException("Invalid Price Format: " + price);
        
        return price;
    }


    public static int checkValueFormat(String line, String valueType) throws WrongFormatException {
        try {
            String[] split = line.split(":");
            if (split.length != 2) {
                throw new WrongFormatException("Invalid " + valueType + " error");
            }

            if (split[0].equals("Max")) {
                if (valueType.equals("MaxValue"))
                    return Integer.parseInt(split[1]);
                else
                    throw new WrongFormatException("Invalid " + valueType + " error");
            } else if (split[0].equals("Min")) {
                if (valueType.equals("MinValue"))
                    return Integer.parseInt(split[1]);
                else
                    throw new WrongFormatException("Invalid " + valueType + " error");
            } else if (split[0].equals("CompanyNumber")) {
                if (valueType.equals("CompanyNumberValue"))
                    return Integer.parseInt(split[1]);
                else
                    throw new WrongFormatException("Invalid " + valueType + " error");
            } else
                throw new WrongFormatException("Invalid " + valueType + " error");
            
        } catch (NullPointerException e) {      // Thrown by String.split()
            throw new WrongFormatException("Invalid " + valueType + " error");
        } catch (PatternSyntaxException e) {    // Thrown by String.split()
            throw new WrongFormatException("Invalid " + valueType + " error");
        } catch (NumberFormatException e) {     // Thrown by Integer.parseInt()
            throw new WrongFormatException("Invalid " + valueType + " error");
        }
    }

    public static void checkFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException("File: " + fileName + " is invalid");
    }
}
