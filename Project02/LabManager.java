package Project02;
/**LabManager.java
 * 
 * Class representation of three CS labs.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 4, 2023
 *
 */
public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }

    // Getter and setter for labOne
    public Lab getLabOne() { return labOne; }
    public void setLabOne(Lab labOne) { this.labOne = labOne; }

    // Getter and setter for labTwo
    public Lab getLabTwo() { return labTwo; }
    public void setLabTwo(Lab labTwo) { this.labTwo = labTwo; }

    // Getter and setter for labThree
    public Lab getLabThree() { return labThree; }
    public void setLabThree(Lab labThree) { this.labThree = labThree; }

    /**
     * Returns the total number of students in labs one, two, and three.
     * 
     * @return The sum of the enrollment of all the labs.
     */
    public int calculateTotalCapacity() {
        return labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment() + 
        labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment() + 
        labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment();
    }

    /**
     * Compute the average percentage of utlization for all the labs.
     * 
     * @return The average percentage utilization for all three labs
     */
    public double calculateTotalUtilization() {

        // Double check the math here.
        double labOneUtilization = (double)(labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment()) / (double)(labOne.getCapacity() * 2);
        double labTwoUtiliation = (double)(labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment()) / (double)(labTwo.getCapacity() * 2);
        double labThreeUtilization = (double)(labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment()) / (double)(labThree.getCapacity() * 2);

        return (labOneUtilization + labTwoUtiliation + labThreeUtilization) / 3d;
    }

    /**
     * Returns the number of available seats in all three labs.
     * 
     * @return The capacity minus the enrollment for all labs and their sessions.
     */
    public int calculateAvailableSeats() {
        int labOneAvailableSeats = (labOne.getCapacity() * 2) - (labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment());
        int labTwoAvailableSeats = (labTwo.getCapacity() * 2) - (labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment());
        int labThreeAvailableSeats = (labThree.getCapacity() * 2) - (labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment());

        return labOneAvailableSeats + labTwoAvailableSeats + labThreeAvailableSeats;
    }

    /**
     * List the reservations for each lab. If there are no reservations, print "No Reservations".
     * Utlize the listReservations() method from the Lab class.
     * 
     * @return The String representation of the reservations for each lab.
     */
    public String listReservedLabs() {
        String result = "Lab One\n";
        result += labOne.listReservations() + "\n";

        result += "Lab Two\n";
        result += labTwo.listReservations() + "\n";

        result += "Lab Three\n";
        result += labThree.listReservations() + "\n";

        return result;
    }

    /**
     * List the availabilities for each lab. If there are no availabilities, print "No Availabilities".
     * Using the listAvailabilities() method from the Lab class.
     * 
     * @return The String representation of the availabilities for each lab.
     */
    public String listAvailableLabs() {
        String result = "Lab One\n";
        result += labOne.listAvailabilities() + "\n";

        result += "Lab Two\n";
        result += labTwo.listAvailabilities() + "\n";

        result += "Lab Three\n";
        result += labThree.listAvailabilities() + "\n";

        return result;
    }

    /**
     * Adds a reservation for the lab at the specified location and time. Returns a message depending on the outcome of the operation. 
     * @param location
     * @param time
     * @param name
     * @param enrollment
     * 
     * @return A message indicating the success or failure of the operation.
     * 
     * TODO: Find the difference between addReservation and modifyReservation.
     */
    public String addReservation(String location, String time, String name, int enrollment) {
        // Have to check which location and time matches the one passed to the method.
        if (labOne.getLocation().equals(location))  {
            if (time.toLowerCase().equals("morning")) {
                if (labOne.getMorning().getEnrollment() == 0) {
                    labOne.getMorning().setName(name);
                    labOne.getMorning().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.toLowerCase().equals("afternoon")) {
                if (labOne.getAfternoon().getEnrollment() == 0) {
                    labOne.getAfternoon().setName(name);
                    labOne.getAfternoon().setEnrollment(enrollment);
                    return "Reservation added!.";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else {
                return "Error. Invalid time.";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (time.toLowerCase().equals("morning")) {
                if (labTwo.getMorning().getEnrollment() == 0) {
                    labTwo.getMorning().setName(name);
                    labTwo.getMorning().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.toLowerCase().equals("afternoon")) {
                if (labTwo.getAfternoon().getEnrollment() == 0) {
                    labTwo.getAfternoon().setName(name);
                    labTwo.getAfternoon().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else {
                return "Error. Invalid time.";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (time.toLowerCase().equals("morning")) {
                if (labThree.getMorning().getEnrollment() == 0) {
                    labThree.getMorning().setName(name);
                    labThree.getMorning().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.toLowerCase().equals("afternoon")) {
                if (labThree.getAfternoon().getEnrollment() == 0) {
                    labThree.getAfternoon().setName(name);
                    labThree.getAfternoon().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else {
                return "Error. Invalid time.";
            }
        } else {
            return "Error. Invalid location.";
        }

    }

    /**
     * TODO: Javadoc
     * @param location
     * @param time
     * @return
     */
    public String removeReservation(String location, String time) {
        if (labOne.getLocation().equals(location)) {
            if (time.toLowerCase().equals("morning")) {
                labOne.getMorning().setName("");
                labOne.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.toLowerCase().equals("afternoon")) {
                labOne.getAfternoon().setName("");
                labOne.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (time.toLowerCase().equals("morning")) {
                labTwo.getMorning().setName("");
                labTwo.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.toLowerCase().equals("afternoon")) {
                labTwo.getAfternoon().setName("");
                labTwo.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (time.toLowerCase().equals("morning")) {
                labThree.getMorning().setName("");
                labThree.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.toLowerCase().equals("afternoon")) {
                labThree.getAfternoon().setName("");
                labThree.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else {
                return "Error. Invalid time.";
            }
        } else {
            return "Error. Invalid location";
        }
        
    }
    
    /**
     * TODO: F
     * @return
     */
    public String modifyReservation() {
        return "";
    }

    /**String representation of the LabManager Object.
     * 
     * @return The string representation of the LabManager Object.
     */
    public String toString() {
    	return String.format("LabManager{%s, %s, %s}", labOne.toString(), labTwo.toString(), labThree.toString());
    }
}
