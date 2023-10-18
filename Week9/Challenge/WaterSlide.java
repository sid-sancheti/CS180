package Week9.Challenge;

import java.util.Objects;

/**Waterslide.java
 * 
 * A waterslide class
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 * @extends Ride
 */
public class Waterslide extends Ride {

    private double splashDepth; // the depth of the waterslide in feet

    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }

    // Getter and setter for splashDepth
    public double getSplashDepth() { return splashDepth; }
    public void setSplashDepth(double splashDepth) { this.splashDepth = splashDepth; }

    /**
     * Determines whether or not the object given as a parameter is equal to this waterslide.
     */
    @Override
    public boolean equals(Object o) {
        // Check for a null pointer; if the class runtimes are not the same, return false
        if (o == null || getClass() != o.getClass()) return false;

        // Same reference, they are equal.
        if (this == o) return true;

        // Cast the object to a Waterslide
        Waterslide other = (Waterslide) o;

        return Objects.equals(getName(), other.getName()) &&
          Objects.equals(getColor(), other.getColor()) &&
          getMinHeight() == other.getMinHeight() &&
          getMaxRiders() == other.getMaxRiders() &&
          splashDepth == other.getSplashDepth();
    }

    /**
     * Overrides toString() method in Ride. Returns the String representation of this waterslide. This includes 
     * the name, color, minHeight, maxRiders, and splash depth value separated by a new line each with labels and units 
     * when necessary.
     * 
     * @return the string representation of this waterslide
     */
    @Override
    public String toString() {
        return String.format("Name: %s\nColor: %s\nMinHeight: %d inches\nMaxRiders: %d\nSplashDepth: %.1f feet",
          getName(), getColor(), getMinHeight(), getMaxRiders(), splashDepth);
    }
}
