package Week7;
/**Restaurant.java
 * 
 * Class representation of a restaurant.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 3, 2023
 *
 */
public class Restaurant {
	private String name;
	private Flavor[] flavors;
	
	// Array of cups sold each day. Each row is for one flavor and each column is for one day of the week.
	private int[][] cupsSold;
	
	// Number of hours the restaurant is open every week.
	private int hours;
	private boolean summerDiscount;
		
	public Restaurant(String name, Flavor[] flavors, int[][] cupsSold, int hours, boolean summerDiscount) {
		this.name = name;
		this.flavors = flavors;
		this.cupsSold = cupsSold;
		this.hours = hours;
		this.summerDiscount = summerDiscount;
	}
	
	public Restaurant() {
		this.name = null;
		this.flavors = new Flavor[3];
		this.cupsSold = new int[3][7];
		this.hours = 0;
		this.summerDiscount = false;
	}
	
	public double totalSales() {
		double totalSales = 0d;
		
		// Need to put everything in an if statement because there is a chance cupsSold is null.
		if (cupsSold != null) {
			// Move through each row of cups sold to get the number of cups sold for each flavor.
			for (int row = 0; row < cupsSold.length; ++row) {
				double flavorCost = flavors[row].getCost();
				for (int col = 0; col < cupsSold[row].length; ++col) {
					// Multiply the number of cups sold per day times the cost of the flavor sold.

					totalSales += (cupsSold[row][col] * flavorCost);
				}
			}
		}	
		
		return totalSales;
	}
	
	public void calculateDiscounts(double discount) {
		if (summerDiscount) {
			for (int i = 0; i < flavors.length; ++i) {
				flavors[i].setCost(flavors[i].getCost() * (1 - discount));
			}
		}
		
	}
	
	public double closeRestaurant() {
		
		double totalSales = totalSales();
		
		name = null;
		flavors = null;
		cupsSold = null;
		hours = 0;
		summerDiscount = false;
		
		return totalSales;
	}
	
	public void addFlavor(Flavor newFlavor) {
		for (int i = 0; i < flavors.length; ++i) {

			if (i == flavors.length - 1 && flavors[flavors.length - 1] != null)
				System.out.println("Error, no available space!");
				
			if (flavors[i] == null) {
				flavors[i] = newFlavor;
				i = flavors.length + 1; // Terminate the for loop.
			}
		}
	}
	
	// Getter and setter for the 'name' field
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	// Getter and setter for the 'flavors' field
	public Flavor[] getFlavors() { return flavors; }
	public void setFlavors(Flavor[] flavors) { this.flavors = flavors; }

	// Getter and setter for the 'cupsSold' field
	public int[][] getCupsSold() { return cupsSold; }
	public void setCupsSold(int[][] cupsSold) { this.cupsSold = cupsSold; }

	// Getter and setter for the 'hours' field
	public int getHours() { return hours; }
	public void setHours(int hours) { this.hours = hours; }

	// Getter and setter for the 'summerDiscount' field
	public boolean hasSummerDiscount() { return summerDiscount; }
	public void setSummerDiscount(boolean summerDiscounts) { this.summerDiscount = summerDiscounts; }
 
}