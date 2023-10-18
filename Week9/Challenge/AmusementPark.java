package Week9.Challenge;
import java.util.ArrayList;
/**AmusementPark.java
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 * 
 */
public class AmusementPark implements Park {
    private double admissionCost;      // the admission cost of the park
    private boolean arcade;            // indicates whether the park has an arcade
    private boolean bowling;           // indicates whether the park has a bowling alley
    private boolean indoor;            // indicates whether the park has an indoor component
    private double land;               // the amount of land in the amusement park in acres
    private String name;               // the name of the amusement park
    private boolean outdoor;           // indicates whether the park has an outdoor component
    private ArrayList<Ride> rides;     // the list of all the rides in the amusement park
    private boolean[] seasons;         // indicates whether the park is open during each season

    private final double epsilon = 0.01;

    // Constructs a newly allocated AmusementPark object with the field values specified by the input parameters
    public AmusementPark(String name, double admissionCost, double land, ArrayList<Ride> rides, boolean indoor, 
        boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    // Getter and setter for arcade
    public boolean isArcade() { return arcade; }
    public void setArcade(boolean arcade) { this.arcade = arcade; }
   
    // Getter and setter for bowling
    public boolean isBowling() { return bowling; }
    public void setBowling(boolean bowling) { this.bowling = bowling; }
   
    // Getter and setter for admissionCost
    public double getAdmissionCost() { return admissionCost; }
    public void setAdmissionCost(double admissionCost) { this.admissionCost = admissionCost; }
   
    // Getter and setter for name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
   
    // Getter for land
    public double getLand() { return land; }
   
   
    /**
    * Adds a new ride to the end of the list of rides in the amusement park, an amusement park can only
    * have rollercoasters so throw a WrongRideException if the ride to be added is not a rollercoaster
    * 
    * @param ride ride to be added to the end of the list
    */
    public void addRide(Ride ride) throws WrongRideException {
        if (ride instanceof Rollercoaster) {
            rides.add(ride);
        } else {
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
        }
    }
   
    /**
    * Removes the ride given as an input parameter from the list of rides
    * 
    * @param ride the ride to be removed from the list
    */
    public void removeRide(Ride ride) {
        rides.remove(ride);
    }
   
    // Getter for rides
    public ArrayList<Ride> getRides() { return rides; }
   
    // Getter for indoor and outdoor
    public boolean isIndoor() { return indoor; }
    public boolean isOutdoor() { return outdoor; }
   
    // Getter and setter for seasons
    public boolean[] getSeasons() { return seasons; }
    public void setSeasons(boolean[] seasons) { this.seasons = seasons; }
   
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws 
      SpaceFullException {
   
        if ((land + addedLand) - maxLand > epsilon) {
            throw new SpaceFullException("There is no more land to use for this park!");
        } 
   
        // Add the new land to the current land
        land += addedLand;
   
        // Set the indoor and outdoor variables accordingly
        if (addedIndoor) { indoor = true; }
        if (addedOutdoor) { outdoor = true; }
    }
       
    /**
    * Modifies the ride given as an input parameter by changing its name, color, minHeight, maxRiders, and splashDepth
    * 
    * @param ride the ride to be modified in the list of rides
    * @param newName the new name of the ride
    * @param newColor the new color of the ride
    * @param newMinHeight the new minimum height
    * @param newMaxRiders the new maximum number of riders
    * @param newSimulated determines whether the ride is simulated
    */
    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight, int newMaxRiders, 
        boolean newSimulated) {
        Rollercoaster newRide = new Rollercoaster(newName, newColor, newMinHeight, newMaxRiders, newSimulated);
        rides.set(rides.indexOf(ride), newRide);
    }
    
    public void close() {
        name = "";
        admissionCost = 0;
        land = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        arcade = false;
        bowling = false;
    }
    
}
