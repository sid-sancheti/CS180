package Week7;
/**IceCream.java
 * 
 * Class that represents all the icecream restaurants in a certain area.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 4, 2023
 *
 */
public class IceCream {
    private Restaurant[] restaurants;
    private boolean summer;
    private int newBusinesses;
    private int newBusinessThreshold;
    

    // Constructor
    public IceCream(Restaurant[] restaurants, boolean summer, int newBusinesses, int newBusinessThreshold) {
        this.restaurants = restaurants;
        this.summer = summer;
        this.newBusinesses = newBusinesses;
        this.newBusinessThreshold = newBusinessThreshold;
    }

	/**Close the businesses that don't make enough money.
	 *
	 * @return The number of businesses closed.
	 */
    public int closeBusinesses() {
    	// First step, get the totalSales from every business.
    	double[] restaurantSales = new double[restaurants.length];
    	for (int i = 0; i < restaurantSales.length; ++i) {
    		if (restaurants[i] != null)
    			restaurantSales[i] = restaurants[i].totalSales();
    	}
    	
    	int numberOfClosedBusinesses = 0;
    	for (int i = newBusinesses; i > newBusinessThreshold; --i) {
    		restaurants[getSmallestIndex(restaurantSales)].closeRestaurant();
    		restaurantSales[getSmallestIndex(restaurantSales)] = 0; // Set the restaurant sale equal to zero when we
    		// remove it from 'restaurants' array.
    		numberOfClosedBusinesses++;
    	}

		newBusinesses = 0;
    	return numberOfClosedBusinesses;
    }
    
    public void applySummerDiscounts() {
    	if (summer) {
    		for (int i = 0; i < restaurants.length; ++i) {
    			if (restaurants[i].hasSummerDiscount()) {
    				if (restaurants[i].totalSales() <= 150.0)
    					restaurants[i].calculateDiscounts(0.25);
    				else if (restaurants[i].totalSales() > 150.0 && restaurants[i].totalSales() <= 300.0)
    					restaurants[i].calculateDiscounts(0.15);
    				else
    					restaurants[i].calculateDiscounts(0.10);


    				
    			}
    		}
    	}
    }
    
    // Getters and Setters for 'restaurants' field
    public Restaurant[] getRestaurants() { return restaurants; }
    public void setRestaurants(Restaurant[] restaurants) { this.restaurants = restaurants; }

    // Getter and Setter for 'summer' field
    public boolean isSummer() { return summer; }
    public void setSummer(boolean summer) { this.summer = summer; }

    // Getter and Setter for 'newBusiness' field
    public int getNewBusinesses() { return newBusinesses; }
    public void setNewBusinesses(int newBusinesses) { this.newBusinesses = newBusinesses; }

    // Getter and Setter for 'newBusinessThreshold' field
    public int getNewBusinessThreshold() { return newBusinessThreshold; }
    public void setNewBusinessThreshold(int newBusinessThreshold) { this.newBusinessThreshold = newBusinessThreshold; }

    /**Find the index of the smallest value in an array
     * THAT IS NOT ZERO.
     * 
     * @param array Array of integers.
     * @return The index of the smallest value in the array that isn't zero.
     */
    public int getSmallestIndex(double[] array) {
    	int index = 0;
    	double smallestInteger = Double.MAX_VALUE;
    	
    	for (int i = 0; i < array.length; ++i) {
    		if (array[i] != 0 && array[i] < smallestInteger) {
				smallestInteger = array[i]; // Update smallestInteger
				index = i;
			}

    	}
    	
    	return index;
    }
}