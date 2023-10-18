package Week9.Challenge;
import java.util.ArrayList;
/**Park.java
 * 
 * A Park interface
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 * 
 */
public interface Park {
    /**
     * Adds a new ride to the end of the list of rides in the park, throws a WrongRideException 
     * when trying to add a waterslide to an amusement park or a rollercoaster to a water park. 
     * An amusement park can only have rollercoasters and a water park can only have waterslides.
     * 
     * @param ride the ride to be added to the end of the list
     * @throws WrongRideException indicates trying to add wrong type of ride
     */
    void addRide(Ride ride) throws WrongRideException;
    /**
     * Removes the ride given as an input parameter from the list of rides
     * 
     * @param ride the ride to be removed from the rides list
     */
    void removeRide(Ride ride);
    /**
     * Returns the list of rides in the park
     * 
     * @return the list of rides in the park
     */
    ArrayList<Ride> getRides();

    /**
     * Closes the park by and adjusts corresponding fields accordingly
     */
    void close();

    /**
     * Enlarges the park by adding a certain amount of land to the park. If the amount of land 
     * already used combined with the amount of land to be added exceeds the maximum amount of 
     * land the park can use, throw a SpaceFullException. If the existing land does not have 
     * either an indoor or outdoor component but the added land does, adjust the indoor and 
     * outdoor instance variables accordingly.
     *
     * @param addedLand amount of land to be added to the park in acres
     * @param maxLand maximum amount of land the park can occupy in acres
     * @param addedIndoor indicates whether or not hte newly added land has an indoor component
     * @param addedOutdoor indicates whether or not the newly added land has an outdoor component
     * 
     * @throws SpaceFullException message: "There is no more land to use for this park!"
     */
    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws 
      SpaceFullException;

    /**
     * Returns the admission cost of the park
     * 
     * @return the admission cost of the park
     */
    double getAdmissionCost();
    /**
     * Sets the admission cost of the park to the value given as a parameter
     * 
     * @param admissionCost the new admission cost of the park
     */
    void setAdmissionCost(double admissionCost);


    /**
     * Returns the amount of land the park covers in acres
     * 
     * @return the amount of land the park covers in acres
     */
    double getLand();

    /**
     * Returns whether or not the park has an indoor component
     * 
     * @return whether or not the park has an indoor component
     */
    boolean isIndoor();
    /**
     * Returns whether or not the park has an outdoor component
     * 
     * @return whether or not the park has an outdoor component
     */
    boolean isOutdoor();


    /**
     * Returns the name of the park
     * 
     * @return the name of the park
     */
    String getName();
    /**
     * Sets the name of the park to the String given as a parameter
     * 
     * @param name the new name of the park
     */
    void setName(String name);

    /**
     * Returns the array representing the seasons when the park is open and closed
     * 
     * @return the array representing the seasons when the park is open and closed
     */
    boolean[] getSeasons();
    /**
     * Sets the seasons array to the boolean array given as a parameter
     * 
     * @param seasons the new seasons array that represents when the park is open and closed
     */
    void setSeasons(boolean[] seasons);
    

}
