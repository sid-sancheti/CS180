package Project03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.PatternSyntaxException;

/**Used to validate the data stored in the input log file.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 16, 2023
 */
public class Validator {

    public static int checkPrice(int price) throws IllegalArgumentException{
        if (price < 0)
            throw new IllegalArgumentException("Invalid Price Format: " + price);
        
        return price;
    }


    public static int checkValueFormat(String line, String valueType) throws WrongFormatException{
        try {
            String[] split = line.split(":");
            if (split.length != 2)
                throw new WrongFormatException("Invalid " + valueType + " error");
            if (!split[0].equals(valueType))
                throw new WrongFormatException("Invalid " + valueType + " error");
            
            return Integer.parseInt(split[1]);

        } catch (NullPointerException e) {      // Thrown by String.split()
            throw new WrongFormatException("Invalid " + valueType + " error");
        } catch (PatternSyntaxException e) {    // Thrown by String.split()
            throw new WrongFormatException("Invalid " + valueType + " error");
        } catch (NumberFormatException e) {     // Thrown by Integer.parseInt()
            throw new WrongFormatException("Invalid " + valueType + " error");
        }
    }

    public static void checkFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException("File: " + fileName + " is invalid");
    }
}
