package Midterm2Practice;

public class Color {
    private final int red, green, blue;

    public Color (int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // Getter methods
    public int getRed() { return red; }
    public int getGreen() { return green; }
    public int getBlue() { return blue; }

    // Custom toString
    public String toString() {
        return String.format("Color<%d, %d, %d>", red, green, blue);
    }
}
