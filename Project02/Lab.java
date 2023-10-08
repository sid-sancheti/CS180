package Project02;
/**Lab.java
 * 
 * Class representation of two lab sessions.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 7, 2023 
 *
 */
public class Lab {
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }

    public Lab(int capacity, String location) {
        this.morning = new Session();
        this.afternoon = new Session();
        this.capacity = capacity;
        this.location = location;
    }

    // Morning session getter and setter
    public Session getMorning() { return morning; }
    public void setMorning(Session morning) { this.morning = morning; }

    // Afternoon session getter and setter
    public Session getAfternoon() { return afternoon; }
    public void setAfternoon(Session afternoon) { this.afternoon = afternoon; }

    // Lab capacity getter and setter
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    // Lab location getter and setter
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    /**String representation that documents the available sessions for this lab.
     * 
     * Note: A session is considered available if the enrollment is 0.
     * This method could be used to test if the lab is fully booked.
     * 'labObjectName'.listAvailablilies().equals("No Availabilities");
     * 
     * @return The available sessions for this lab.
     */
    public String listAvailabilities() {
        String result = "";
        if (morning.getEnrollment() == 0)
            result += "Morning: Available\n";
        if (afternoon.getEnrollment() == 0)
            result += "Afternoon: Available\n";
        if (result.equals(""))
            result = "No Availabilities";
        return result;
    }

    /**Returns a String that documents the reserved sessions for this lab.
     * 
     * Note: A session is reserved if the enrollment > 0.
     * This method could be used to test if the lab is completely available.
     * 'labObjectName'.listAvailablilies().equals("No Reservations");
     * 	
     * @return The reserved sessions for this lab.
     */
    public String listReservations() {
        String result = "";
        if (morning.getEnrollment() > 0)
            result += "Morning: Reserved\n";
        if (afternoon.getEnrollment() > 0)
            result += "Afternoon: Reserved\n";
        if (result.equals(""))
            result = "No Reservations";
        return result;
    }

    /**String representation of a Lab object.
     * 
     * If a session is not reserved for either of the available times, 
     * do not include the toString for that session. Instead, add "Available". 
     * 
     * 
     * @return String representation of the Lab Object
     */
    public String toString() {
        return "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: " + morning.toString() 
        + ", Afternoon: " + afternoon.toString() + "}";
    }
    
}