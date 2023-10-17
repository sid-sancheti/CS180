package Week9.Challenge;
import java.util.ArrayList;
/**AmusementPark.java
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 17, 2023
 * 
 */
public class AmusementPark implements Park{
    private double admissionCost;      // the admission cost of the park
    private boolean arcade;            // indicates whether or not the park has an arcade
    private boolean bowling;           // indicates whether or not the park has a bowling alley
    private boolean indoor;            // indicates whether or not the park has an indoor component
    private double land;               // the amount of land in the amusement park in acres
    private String name;               // the name of the amusement park
    private boolean outdoor;           // indicates whether or not the park has an outdoor component
    private ArrayList<Ride> rides;     // the list of all the rides in the amusement park
    private boolean[] seasons;         // indicates whether or not the park is open during each season

    // Constructs a newly allocated AmusementPark object with the field values specified by the input parameters
    public AmusementPark(String name, double admissionCost, double land, ArrayList<Ride> rides, boolean indoor, 
      boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    /**
     * Adds a new ride to the end of the list of rides in the amusement park, an amusement park can only have 
     * rollercoasters so throw a WrongRideException if the ride to be added is not a rollercoaster
     * 
     * @param 
     */
    public void addRide(Ride ride) {
    }

    //TODO: Finis the rest of the class
    
}
