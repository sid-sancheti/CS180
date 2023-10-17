package Project03;
import java.io.*;
import java.util.ArrayList;
/**DataSystem.java
 * 
 * Records data associated with the generated reports.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 16, 2023
 */
public class Report {
    private int minPrice, maxPrice;         // Minimum and maximum stock prices
    private ArrayList<Company> companyList; // A list of all the companies to be processed

    public Report(int minPrice, int maxPrice, ArrayList<Company> companyList) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.companyList = companyList;
    }

    // Getters for every field
    public int getMinPrice() { return minPrice; }
    public int getMaxPrice() { return maxPrice; }
    public ArrayList<Company> getCompanyList() { return companyList; }

    /*
     * Generates an output file named "Report.txt" using 
     * the format described in the next section.
     */
    public void generateReport() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Report.txt"))) {
            for (int i = 0; i < companyList.size(); ++i) {
                bw.write(companyList.get(i).getName());
                bw.newLine();
                bw.write(printExtremePrices(i));
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Generates an output file named "ReportMax.txt"
     */
    public void generateReportMax() {
        for (int i = 0; i < companyList.size(); ++i) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("ReportMax.txt"))) {
                bw.write(companyList.get(i).getName() + "-" + maxPrice);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * Prints all the prices that exceed the minimum or maximum price.
     * If no prices exceed the minimum or maximum price, print "All prices are within the range."
     * 
     * Implemented by generateReport()
     */
    private String printExtremePrices(int index) {
        String output = "";
        for (int i = 1; i <= companyList.get(index).getPrices().length; ++i) {
            if (companyList.get(index).getPrices()[i - 1] < minPrice) {
                output += "Below Minimum Price at " + i + " with " + companyList.get(index).getPrices()[i - 1] + ".\n";
            } else if (companyList.get(index).getPrices()[i - 1] > maxPrice) {
                output += "Above Maximum Price at " + i + " with " + companyList.get(index).getPrices()[i - 1] + ".\n";
            }
        }

        // If there are no stock prices outside of the range:
        if (output.isEmpty()) {
            output = "All prices are within the range.\n";
        }

        return output;
    }
}
