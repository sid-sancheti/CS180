package Week9.Challenge;
import java.util.Objects;
/**Rollercoaster.java
 * 
 * A rollercoaster class
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 * @extends Ride
 */
public class Rollercoaster extends Ride {
    private boolean simulated;  // whether or not the ride is simulated

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }

    // Getter and setter for simulated
    public boolean isSimulated() { return simulated; }
    public void setSimulated(boolean simulated) { this.simulated = simulated; }

    @Override
    public boolean equals(Object o) {
        // Check for a null pointer; if the class runtimes are not the same, return false
        if (o == null || getClass() != o.getClass()) return false;

        // Same reference, they are equal.
        if (this == o) return true;

        // Cast the object to a Rollercoaster
        Rollercoaster other = (Rollercoaster) o;

        return Objects.equals(getName(), other.getName()) &&
          Objects.equals(getColor(), other.getColor()) &&
          getMinHeight() == other.getMinHeight() &&
          getMaxRiders() == other.getMaxRiders() &&
          simulated == other.isSimulated();

    }

    /**
     * Overrides toString() method in Ride. Returns the String representation of this rollercoaster. This includes 
     * the name, color, minHeight, maxRiders, and simulated value separated by a new line each with labels and units 
     * when necessary.
     * 
     * @return the string representation of this rollercoaster
     */
    @Override
    public String toString() {
        return String.format("Name: %s\nColor: %s\nMinimum Height: %d inches\nMaximum Riders: %d\nSimulated: %b",
          getName(), getColor(), getMinHeight(), getMaxRiders(), simulated);
    }

}
