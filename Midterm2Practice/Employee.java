package Midterm2Practice;

public class Employee extends Person {
    private final int hourlyRate;

    public Employee(String name, int age, int hourlyRate) {
        super(name, age); // Call the constructor of the superclass (Person)
    
        if (hourlyRate < 0)
            throw new IllegalArgumentException();

        this.hourlyRate = hourlyRate;
    }

    public Employee(Employee employee) {
        super(employee); // Call the copy constructor of the superclass (Person)
        this.hourlyRate = employee.hourlyRate;
    }

    public int getHourlyRate() { return hourlyRate; }
    public int calculateTotalIncome(int hours) { return hourlyRate * hours; }

    public boolean equals(Object o) {
        // Null pointer and class runtime check
        if (o == null || getClass() != o.getClass()) return false;

        // They are the same objects.
        if (this == o) return true;

        // Cast object to an employee
        Employee other = (Employee) o;

        return super.equals(other) && hourlyRate == other.hourlyRate;
    }

    public String toString() {
        return String.format("Employee<name=%s, age=$d, hourlyRate=%d>", getName(), getAge(), hourlyRate);
    }
}
