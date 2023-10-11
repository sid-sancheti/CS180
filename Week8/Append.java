package Week8;
import java.io.*;
import java.util.Scanner;

public class Append {
    
    public void appendText(String path, String toAppend) throws PathException {

        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            throw new PathException();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(toAppend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in); 
        
        System.out.println("Enter the path to the file:");
        String path = scan.nextLine();
        
        System.out.println("Enter the line to append:");
        String toAppend = scan.nextLine(); 
        
        Append a = new Append();
        try {
            a.appendText(path, toAppend);
        } catch (PathException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scan.close();
    }
}
