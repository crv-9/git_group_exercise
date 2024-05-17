package dev.find_user;

import dev.user_profile.data_classes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLineParser {


    public static List<User> getUsersList(){
        UserCreator userCreator = new UserCreator();
        List<User> usersList = new ArrayList<>();
        List<String[]> usersArrayList = getUsersArrayList();

        for (String[] userLine: usersArrayList) {
            // TODO create a class to create a user based on the information available
            // TODO add here the instance of that class

            Optional<User> user = userCreator.createUser(userLine);
            if (user.isPresent()){
                usersList.add(user.get());
            }

        }

        return usersList;
    }

    private static List<String[]> getUsersArrayList(){
        List<String> usersLines = DatabaseReader.getUsersLines();
        List<String[]> usersArrayList = new ArrayList<>();

        // I need to have each line as String[]
        for (String userLine: usersLines) {
            usersArrayList.add(getCSVLineParser(userLine));
        }

        return usersArrayList;
    }

    // turns the csvLine string into an array - String[]
    public static String[] getCSVLineParser(String userLineCSVString){
        // Split the CSV line by comma, ignoring commas inside curly braces
        // Split by comma not followed by closing braces or brackets
        return userLineCSVString.split(",(?![^{\\[]*[\\]}])", -1);
    }






}
