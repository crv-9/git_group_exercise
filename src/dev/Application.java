package dev;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome!");

    boolean userBoolean;
    boolean isValidInput = false;

     // Loop until a valid boolean is entered
    while (!isValidInput) {
        System.out.println("Do you have an account? (answer: true/false)");
        String input =  scanner.nextLine();  

        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            userBoolean = Boolean.parseBoolean(input);
            isValidInput = true;  // Set flag to true to exit the loop

            if (userBoolean){
                System.out.println("Coming Soon"); // here we will implement the case if the User already have an account.
                // login
                } else if (!userBoolean) {
                
                    
                }
        } else {
            System.out.println("Invalid input. Please enter only 'true' or 'false'.");
        }  
    }
    }  
}
