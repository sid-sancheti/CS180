package Week6;
/**
 * This class models the type of tea sold at a tea shop.
 * 
 * @author Siddharth Sancheti
 * @version September 26, 2023
 *
 */
public class Tea {
	private String name;
	private double price;
	private int stockAvailable;
	private String type;
	private int caffeineLevel;
	private int steepTemperature;
	private double steepTime;
	
	public Tea(String name, double price, String type, int stockAvailable) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.stockAvailable = stockAvailable;
		
		switch (type) {
			case "Black":
				caffeineLevel = 5;
				steepTemperature = 212;
				steepTime = 4.5;
				break;
			case "Oolong":
				caffeineLevel = 4;
				steepTemperature = 200;
				steepTime = 2d;
				break;
			case "Green":
				caffeineLevel = 3;
				steepTemperature = 185;
				steepTime = 2.5;
				break;
			case "White":
				caffeineLevel = 2;
				steepTemperature = 160;
				steepTime = 1.5;
				break;
			case "Herbal":
				caffeineLevel = 1;
				steepTemperature = 212;
				steepTime = 5d;
				break;
			default:
				System.out.println("This is not a type of tea sold here");
				break;
		}
	}
	
    // Getter method for 'name'
    public String getName() { return name; }

    // Getter and Setter methods for 'price'
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Getter for stockAvailable for 'stockAvailable'
    public int getStockAvailable() { return stockAvailable; }

    // Getter and Setter methods for 'type'
    public String getType() { return type; }

    // Getter and Setter methods for 'caffeineLevel'
    public int getCaffeineLevel() { return caffeineLevel; }

    // Getter method for 'steepTemperature'
    public int getSteepTemperature() { return steepTemperature; }

    // Getter method for 'steepTime'
    public double getSteepTime() { return steepTime; }
    
    // Update the amount of stock available.
    public void restock(int quantity) { this.stockAvailable = quantity; }
	
    public double purchaseTea(int quantity) { 
    	int purchaseAmt = quantity;
    	
    	// If the customer wants to by more stock than available, sell the entire stock.
    	if (quantity > stockAvailable) 
    		purchaseAmt = stockAvailable;
    	
    	// Update the amount of stock available.
    	stockAvailable -= purchaseAmt;
    	
    	return purchaseAmt * price;
    }
    
    public String toString() {
        return "Tea Name : " + name + '\n' +
                "Type: " + type + '\n' +
                "Stock Available: " + stockAvailable + '\n' +
                "Price: $" + price + '\n' +
                "Steep Time: " + steepTime + '\n' +
                "Steep Temperature: " + steepTemperature + '\n' +
                "Caffeine Level: " + caffeineLevel;
    }
}

