package Week07;
/**Flavor.java
 * 
 * Class representation of an ice cream flavor available at a restaurant.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 3, 2023
 *
 */
public class Flavor {
	private String name;
	private double cost;
	
	public Flavor(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public Flavor() {
		name = null;
		cost = 0;
	}

	public String getName() { return name; }

	public double getCost() { return cost; }
	public void setCost(double cost) { this.cost = cost; }
	


	
}
