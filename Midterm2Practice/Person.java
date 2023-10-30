package Midterm2Practice;

import java.util.Objects;

import Week9.Challenge.Rollercoaster;

public class Person implements Identifiable {
    private final String name;
    private final int age;

    public Person (String name, int age) {

        if (name == null)
            throw new NullPointerException();
        
        if (age < 0)
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
    }

    public Person (Person person) {
        if (person == null)
            throw new NullPointerException();
        
        this.name = person.name;
        this.age = person.age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object o) {
        // Check for a null pointer; if the class runtimes are not the same, return false
        if (o == null || getClass() != o.getClass()) return false;

        // Same reference, they are equal.
        if (this == o) return true;

        // Cast the object to a Person
        Person other = (Person) o;

        return Objects.equals(getName(), other.getName()) && Objects.equals(getAge(), other.getAge());
    }

    @Override
    public String toString() {
        return String.format("Person<name=%s, age=%d>", name, age);
    }

}
