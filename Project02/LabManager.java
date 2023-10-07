package Project02;
/**LabManager.java
 * 
 * Class representation of three CS labs.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 7, 2023
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
     * 
     * TODO: Need to fix.
     */
    public double calculateTotalUtilization() {

        // Double check the math here.
        double labOneUtilization = (double)(labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment()) 
        		/ (double)(labOne.getCapacity() * 2);
        double labTwoUtiliation = (double)(labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment()) 
        		/ (double)(labTwo.getCapacity() * 2);
        double labThreeUtilization = (double)(labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment()) 
        		/ (double)(labThree.getCapacity() * 2);

        return (labOneUtilization + labTwoUtiliation + labThreeUtilization) / 3d;
    }

    /**
     * Returns the number of available seats in all three labs.
     * 
     * @return The capacity minus the enrollment for all labs and their sessions.
     * 
     * TODO: Need to fix.
     */
    public int calculateAvailableSeats() {
        int labOneAvailableSeats = (labOne.getCapacity() * 2) - (labOne.getMorning().getEnrollment() + 
        		labOne.getAfternoon().getEnrollment());
        int labTwoAvailableSeats = (labTwo.getCapacity() * 2) - (labTwo.getMorning().getEnrollment() + 
        		labTwo.getAfternoon().getEnrollment());
        int labThreeAvailableSeats = (labThree.getCapacity() * 2) - (labThree.getMorning().getEnrollment() + 
        		labThree.getAfternoon().getEnrollment());

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
        result += labThree.listReservations();

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
     * Adds a reservation for the lab at the specified location and time.
     * 
     * @param location The location of the lab.
     * @param time The time of the lab.
     * @param name The name of the lab.
     * @param enrollment The number of students enrolling in a lab; may not exceed lab capacity.
     * 
     * @return A message indicating the success or failure of the operation.
     */
    public String addReservation(String location, String time, String name, int enrollment) {
        // Have to check which location and time matches the one passed to the method.
    	if (labOne.getLocation().equals(location))  {
            if (time.equals("morning")) {
                if (labOne.getMorning().getEnrollment() < labOne.getCapacity()) {
                    labOne.getMorning().setName(name);
                    labOne.getMorning().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.equals("afternoon")) {
                if (enrollment < labOne.getCapacity()) {
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
            if (time.equals("morning")) {
                if (enrollment < labTwo.getCapacity()) {
                    labTwo.getMorning().setName(name);
                    labTwo.getMorning().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.equals("afternoon")) {
                if (enrollment < labTwo.getCapacity()) {
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
            if (time.equals("morning")) {
                if (enrollment < labThree.getCapacity()) {
                    labThree.getMorning().setName(name);
                    labThree.getMorning().setEnrollment(enrollment);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.equals("afternoon")) {
                if (enrollment < labThree.getCapacity()) {
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
     * Removes a lab reservation at a certain location and time.
     * 
     * @param location The location of the lab.
     * @param time The time of the lab.
     * 
     * @return The status of the method. Either print an error message or indicate that the operation
     * was successful.
     */
    public String removeReservation(String location, String time) {
        if (labOne.getLocation().equals(location)) {
            if (time.equals("morning")) {
                labOne.getMorning().setName("");
                labOne.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.equals("afternoon")) {
                labOne.getAfternoon().setName("");
                labOne.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (time.equals("morning")) {
                labTwo.getMorning().setName("");
                labTwo.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.equals("afternoon")) {
                labTwo.getAfternoon().setName("");
                labTwo.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (time.equals("morning")) {
                labThree.getMorning().setName("");
                labThree.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.equals("afternoon")) {
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
     * Modifies a reservation for the lab at the specified location and time.
     *  
     * @param location The location of the lab.
     * @param time The time of the lab.
     * @param name The name of the lab.
     * @param enrollment The number of students enrolling in a lab; may not exceed lab capacity.
     * 
     * @return A message indicating the success or failure of the operation.
     */
    public String modifyReservation(String location, String time, String name, int enrollment) {
    	if (labOne.getLocation().equals(location))  {
            if (time.equals("morning")) {
                if (enrollment < labOne.getCapacity()) {
                    labOne.getMorning().setName(name);
                    labOne.getMorning().setEnrollment(enrollment);
                    return "Reservation modified!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.equals("afternoon")) {
                if (enrollment < labOne.getCapacity()) {
                    labOne.getAfternoon().setName(name);
                    labOne.getAfternoon().setEnrollment(enrollment);
                    return "Reservation modified!.";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else {
                return "Error. Invalid time.";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (time.equals("morning")) {
                if (enrollment < labTwo.getCapacity()) {
                    labTwo.getMorning().setName(name);
                    labTwo.getMorning().setEnrollment(enrollment);
                    return "Reservation modified!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.equals("afternoon")) {
                if (enrollment < labTwo.getCapacity()) {
                    labTwo.getAfternoon().setName(name);
                    labTwo.getAfternoon().setEnrollment(enrollment);
                    return "Reservation modified!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else {
                return "Error. Invalid time.";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (time.equals("morning")) {
                if (enrollment < labThree.getCapacity()) {
                    labThree.getMorning().setName(name);
                    labThree.getMorning().setEnrollment(enrollment);
                    return "Reservation modified!";
                } else {
                    return "Error. Capacity exceeded";
                }
            } else if (time.equals("afternoon")) {
                if (enrollment < labThree.getCapacity()) {
                    labThree.getAfternoon().setName(name);
                    labThree.getAfternoon().setEnrollment(enrollment);
                    return "Reservation modified!";
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

    /**String representation of the LabManager Object.
     * 
     * @return The string representation of the LabManager Object.
     */
    public String toString() {
    	return String.format("LabManager{%s, %s, %s}", labOne.toString(), labTwo.toString(), labThree.toString());
    }
}
