package Midterm1;

import java.util.Scanner;
/**
 * CS 180 Midterm 1
 * 
 * This program will prompt the user for information about a piece of luggage and then output a luggage code based on the information provided.
 * 
 * @author Siddharth Sancheti, Section 33
 * @version October 2, 2023
 */
public class LuggageInfo {
    public static final String WELCOME_MESSAGE = "Welcome to the LuggageInfo program!";
    public static final String TYPE_PROMPT = "What is the type of luggage?";
    public static final String BRAND_PROMPT = "What is the brand of the luggage?";
    public static final String MODEL_PROMPT = "What is the model of the luggage?";
    public static final String SIZE_PROMPT = "What is the size of the luggage?";
    public static final String MATERIAL_PROMPT = "What is the material of the luggage?";
    public static final String COLOR_PROMPT = "What is the color of the luggage?";
    public static final String COMPARTMENT_COUNT_PROMPT = "How many compartments does the luggage have?";
    public static final String EXPANDABLE_PROMPT = "Is the luggage expandable (Yes/No)?";
    public static final String ITEM_COUNT_PROMPT = "How many items are currently inside the luggage?";
    public static final String ITH_ITEM_PROMPT = "What is the name of item number ";
    public static final String WARRANTY_COUNT_PROMPT = "What is the warranty period (in months) for the luggage?";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Printing the welcome message.
        System.out.println(WELCOME_MESSAGE);
        
        System.out.println(TYPE_PROMPT);
        String type = scanner.nextLine();

        System.out.println(BRAND_PROMPT);   
        String brand = scanner.nextLine();

        System.out.println(MODEL_PROMPT);
        String model = scanner.nextLine();

        System.out.println(SIZE_PROMPT);
        String size = scanner.nextLine();

        System.out.println(MATERIAL_PROMPT);
        String material = scanner.nextLine();

        System.out.println(COLOR_PROMPT);
        String color = scanner.nextLine();

        System.out.println(COMPARTMENT_COUNT_PROMPT);
        int compartmentCount = scanner.nextInt();
        scanner.nextLine();

        System.out.println(EXPANDABLE_PROMPT);
        String expandable = scanner.nextLine();

        System.out.println(ITEM_COUNT_PROMPT);
        int itemCount = scanner.nextInt();
        scanner.nextLine();

        String[] items = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            System.out.println(ITH_ITEM_PROMPT + (i + 1) + "?");
            items[i] = scanner.nextLine();
        }

        System.out.println(WARRANTY_COUNT_PROMPT);
        int warrantyCount = scanner.nextInt();
        scanner.nextLine();


        scanner.close();
       
        /**
         * Altering the strings to fit the final format.
         */

        // Concatinating the first and last letter of the luggage type; uppercase.
        String luggageTypeCode = type.substring(0, 1).toUpperCase() + type.substring(type.length() - 1).toUpperCase();
        // First three letters of the brand name and the entire model name.
        String brandModel = brand.substring(0, 3) + model;
        // First letter of the size; uppercase.
        String sizeCode = size.substring(0, 1).toUpperCase();
        // to uppercase; remove whitespace; color to lowercase; concatinate material with color and a hyphen.
        String materialCode = material.toUpperCase().replace(" ", "") + "-" + color.toLowerCase();
        // Convert the compartment count to a string.
        String compartmentCode = String.valueOf(compartmentCount);
        // Y for yes and N for no.
        String expandableCode = expandable.equalsIgnoreCase("yes") ? "Y" : "N";
        // Printing and seperating the items with a comma.
        String itemsCode = "{";
        for (int i = 0; i < items.length; i++) {
            itemsCode += items[i];
            if (i < items.length - 1) {
                itemsCode += ", ";
            }
        }
        itemsCode += "}";

        // Determine the warranty code based on the length of the warranty.
        String warrantyCode = "";
        if (warrantyCount  < 6)
            warrantyCode = "POOR";
        else if (warrantyCount <= 12)
            warrantyCode = "AVERAGE";
        else 
            warrantyCode = "EXCELLENT";

        // Printing the final output.
        System.out.println(luggageTypeCode + "_" + brandModel + "_" + sizeCode + "_" + materialCode + "_" + compartmentCode + "_" + expandableCode + "_" + itemsCode + "_" + warrantyCode + ";");
    }
}