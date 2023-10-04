package Project02;
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

    public String toString() {
        return "Session{Name - " + name + ", Enrollment - " + enrollment + "}";
    }

}
