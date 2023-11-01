package Week08;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This file is just meant to test if we can write stuff to the ratings.txt file.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ratings.txt"))) {
            bw.write("Hello");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
