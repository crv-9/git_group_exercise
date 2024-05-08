package dev.user_profile.service_classes;


    import dev.questionnaire.Questionnaire;
    import dev.user_profile.data_classes.User;

    import java.io.IOException;
    import java.util.Scanner;
    import java.util.Map;
    import java.util.HashMap;
    
    public class UserService {
        private Scanner scanner;
    
        public UserService() {
            this.scanner = new Scanner(System.in);
        }
    // Prompts the user and stores responses in a Map
        public Map<String, String> gatherUserData() {
            Map<String, String> userData = new HashMap<>();
            
            System.out.println("Please enter your name:");
            userData.put("Name", scanner.nextLine());
    
            System.out.println("Please enter your age:");
            userData.put("Age", scanner.nextLine());
    
            System.out.println("Please enter your email:");
            userData.put("Email", scanner.nextLine());
    
            System.out.println("Please enter your password:");
            userData.put("Password", scanner.nextLine());
    
            System.out.println("Please enter your weight (in kg):");
            userData.put("Weight", scanner.nextLine());
    
            System.out.println("Please enter your height (in meters):");
            userData.put("Height", scanner.nextLine());
    
            return userData;
        }
    //Parses the data from the map and creates a new User instance.
        public User createUserFromMap(Map<String, String> userData) {
            String name = userData.get("Name");
            int age = Integer.parseInt(userData.get("Age"));
            String email = userData.get("Email");
            String password = userData.get("Password");
            double weight = Double.parseDouble(userData.get("Weight"));
            double height = Double.parseDouble(userData.get("Height"));
            return new User(name, age, email, password, weight, height);
        }
    
        public static void main(String[] args) {
            UserService userService = new UserService();
            Map<String, String> userData = userService.gatherUserData();
            User user = userService.createUserFromMap(userData);
            
            System.out.println("User created successfully with ID: " + user.getIdNumber());
        }

        public static void runQuestionnaire(User user)throws IOException {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.runQuestionnaire();
        }
    }
    
