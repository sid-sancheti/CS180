package Project02;
/**Session.java
 * 
 * Class representation of a lab session.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 7, 2023
 *
 */
public class Session {
    private String name;
    private int enrollment;

    // Custom constructor
    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }
    
    // Default constructor
    public Session() {
        name = "";
        enrollment = 0;
    }

    // Setter and getter for the name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Setter and getter for the enrollment
    public int getEnrollment() { return enrollment; }
    public void setEnrollment(int enrollment) { this.enrollment = enrollment; }

    /**String representation of Session object.
     * 
     * If there is enrollment in the class, print the name and enrollment of the class.
     * Otherwise, mention that the Session is available.
     * 
     * The string will have white spaces between commas.
     * 
     * TODO: Determine what to print if name = "" and enrollment = 0.
     * 
     * @return The string representation of the Session.
     */
    public String toString() {
        return (enrollment > 0) ? String.format("Session{Name - %s, Enrollment - %d}", name, enrollment) : "Available";
    }

}
