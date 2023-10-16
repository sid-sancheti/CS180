package Project03;

/**Company.java
 * 
 * Records data associated with a single company.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 16, 2023
 */
public class Company {
    private String name;    // name of company
    private int[] prices;   // Stock prices associated with the company

    public Company(String name, int[] prices) {
        this.name = name;
        this.prices = prices;
    }

    // Name getter and setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Prices getter and setter
    public int[] getPrices() { return prices; }
    public void setPrices(int[] prices) { this.prices = prices; }
}
