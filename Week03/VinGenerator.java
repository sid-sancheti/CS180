package Week03;

import java.util.Scanner;
/**
 * HW-03 --VinGenerator
 *
 * This program takes in input from user and returns a VIN
 *
 * @author Siddharth Sancheti, Section 33
 *
 * @version September 5, 2023
 *
 */

public class VinGenerator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Getting the country code.
        System.out.println("Enter the Origin Country Code:");
        String countryCode = Integer.toBinaryString(scan.nextInt());
        scan.nextLine();
        // Adding the padding
        countryCode = String.format("%4s", countryCode).replace(" ", "0");

        // Get the make and only store the first two letters
        System.out.println("Enter the Vehicle Make:");
        String make = scan.nextLine();
        make = make.substring(0, 2).toUpperCase();

        // Get color of the vehicle and convert to lowercase
        System.out.println("Enter the Color of the Vehicle:");
        String color = scan.nextLine().toLowerCase();
        int vinColor = color.charAt(0) + color.charAt(1) + color.charAt(2);
        // Get the last two digits by taking mod 100
        vinColor %= 100;
        // Adding the padding in case the modulus is only one digit.
        String vinColorString = String.format("%2s", String.valueOf(vinColor)).replace(" ", "0");

        // Get model of vehicle and put it in upper case
        System.out.println("Enter the Model of the Vehicle:");
        String model = scan.nextLine().toUpperCase();
        // Get the first and last character of the model
        String vinModel = String.valueOf(model.charAt(0)) + String.valueOf(model.charAt(model.length() - 1));

        // Get the last two digits of the year
        System.out.println("Enter the Year of the Vehicle:");
        int vinYear = scan.nextInt() % 100;
        scan.nextLine();

        // Get the first character of the input
        System.out.println("Enter the Delivery Destination:");
        String delivery = scan.nextLine().toUpperCase();
        String vinDelivery = delivery.substring(0, 2);

        // Get the first character of the fuel type
        System.out.println("Enter the Fuel Type:");
        String fuel = scan.nextLine().toUpperCase();
        String vinFuel = String.valueOf(fuel.charAt(0));

        // Get the mileage in mpg
        System.out.println("Enter the Estimated Kilometers Per Liter:");
        int vinMileage = (int) (scan.nextDouble() / 0.42514);
        scan.nextLine();

        String vin = countryCode + make + vinColorString + vinModel + vinYear + vinDelivery + vinFuel + vinMileage;

        // Converting I's to 1's and O's to 0's
        vin = vin.replace('I', '1');
        vin = vin.replace("O", "0");
        System.out.printf("The Assigned VIN is " + vin);
        
        // Closing the scanner object
        scan.close();

    } //End main method

} //End VinGenerator class
