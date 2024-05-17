package dev;

import dev.user_profile.data_classes.User;
import dev.user_profile.service_classes.UserService;

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
                // parser need it to call the user from the database
                } else if (!userBoolean) {  // the dose not have an account (create an account)
                System.out.println("Do you want to rnter Personal Data or skip to questionnaire? (write skip/ countie");
                String skipOrNot = scanner.nextLine();
                if (skipOrNot.equalsIgnoreCase("countie")){


                    UserService userService = new UserService();


                    User user = userService.createUserFromMap(userService.gatherUserData());



                        //Parser need it here to store user in the Database;
                } else  {


                    // Run questionnaire

                }


            }
        } else {
            System.out.println("Invalid input. Please enter only 'true' or 'false'.");
        }  
    }
    }  
}
