package Week9.Challenge;
import java.util.Objects;
/**Ride.java
 * 
 * Class representation of a ride in a park.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 */
public class Ride {
    private String color;   // the color of the ride
    private int maxRiders;  // the maximum number of riders allowed on the ride at once
    private int minHeight;  // the minimum height in inches required to ride the ride
    private String name;    // the name of the ride

    // Default constructor
    public Ride() {
        this.color = "";
        this.name = "";
        this.maxRiders = 0;
        minHeight =0;
    }

    // Custom constructor
    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    // Getter and setter for name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Getter and setter for color
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // Getter and setter for minHeight
    public int getMinHeight() { return minHeight; }
    public void setMinHeight(int minHeight) { this.minHeight = minHeight; }

    // Getter and setter for maxRiders
    public int getMaxRiders() { return maxRiders; }
    public void setMaxRiders(int maxRiders) { this.maxRiders = maxRiders; }

    /**
     * Determines whether or not the object given as a parameter is equal to this ride.
     * 
     * Note: the implementation of this method can have an effect on several methods in the AmusementPark or 
     * WaterPark classes such as removeRide() and modifyRide() so it is important to implement equals() correctly
     * 
     * @return true if the object equals the ride; else return false
     */
    @Override
    public boolean equals(Object o) {
        // Check for a null pointer; if the class runtimes are not the same, return false
        if (o == null || getClass() != o.getClass()) return false;

        // Same reference, they are equal.
        if (this == o) return true; 

        // Cast to a ride
        Ride other = (Ride) o;
        
        // Handle nulls safely using Objects.equals
        return Objects.equals(name, other.name) &&
          Objects.equals(color, other.color) &&
          minHeight == other.minHeight &&
          maxRiders == other.maxRiders;
    }


    public String toString() {
        return String.format("Name: %s\nColor: %s\nMin Height: %d inches\nMaxRiders: %d", name, color, minHeight, 
          maxRiders);
    }
    
    
}
