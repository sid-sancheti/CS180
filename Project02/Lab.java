package Project02;
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

    // Make getters and setters for every field
    public Session getMorning() { return morning; }
    public void setMorning(Session morning) { this.morning = morning; }

    public Session getAfternoon() { return afternoon; }
    public void setAfternoon(Session afternoon) { this.afternoon = afternoon; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    /**
     * TODO: Add Javadoc
     * @return
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

    /**
     * TODO: Add Javadoc
     * 	
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

    /**
     * TODO: Add Javadoc
     */
    public String toString() {
        String result = "Lab{Capacity - " + capacity + ", Location - " + location + ", ";
        if (morning.getEnrollment() > 0)
            result += "Morning: " + morning.toString() + ", ";
        else
            result += "Morning: Available, "; // If there is no enrollment, return that the session is available.
        if (afternoon.getEnrollment() > 0)
            result += "Afternoon: " + afternoon.toString() + "}";
        else
            result += "Afternoon: Available}";
        return result;
    }
    
}
