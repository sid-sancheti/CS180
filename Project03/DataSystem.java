package Project03;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/**Includes all the logic used to process the files.
 * 
 * @author Siddharth Sancheti
 * @version October 16, 2023
 */
public class DataSystem {
    public static void main(String[] args) {
        String fileName = args[0];

        // Verify that the file exists
        try {
            Validator.checkFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            int max = Validator.checkPrice(Validator.checkValueFormat(line, "MaxValue"));
            line = br.readLine();
            int min = Validator.checkPrice(Validator.checkValueFormat(line, "MinValue"));
            line = br.readLine();
            int companyNumber = Validator.checkValueFormat(line, "CompanyNumberValue");

            // Make an ArrayList of companies to pass to the 
            ArrayList<Company> companies = new ArrayList<Company>(companyNumber);

            // Collect the data from each line and store it in the ArrayList
            for (int i = 0; i < companyNumber; ++i) {
                line = br.readLine();
                String[] split = line.split(":");
                String name = split[0];
                String[] prices = split[1].split(",");
                int[] priceArray = new int[prices.length];
                for (int j = 0; j < prices.length; ++j) {
                    priceArray[j] = Validator.checkPrice(Integer.parseInt(prices[j]));
                }
                companies.add(new Company(name, priceArray));
            }
            Report report = new Report(min, max, companies);
            report.generateReport();
            report.generateReportMax();
        } catch (InvalidPriceException e) {
            e.printStackTrace(); 
        } catch (WrongFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
