package dev.user_profile.service_classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import dev.user_profile.data_classes.User;

/**
 * WriteNewUserToDatabase
 */
public class WriteNewUserToDatabase {

    public void write (User user) throws IOException{

        String dataBaseRootPath = "src\\dev\\supp_buddy_database.csv";
        Path path = Path.of(dataBaseRootPath); 

        // Working on it 
        
    }
}