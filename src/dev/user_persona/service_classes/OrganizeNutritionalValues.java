package dev.user_persona.service_classes;

import dev.user_persona.data_classes.User_Persona;

import java.util.*;

public class OrganizeNutritionalValues {
    // we will sort the values from lowest to highest to know which area to focus on first
    public static List<Map.Entry<String, Integer>> sortValues(User_Persona user_persona){

        // Map.Entry provides a convenient way to work with individual key-value pairs in a map
        // here I am giving as key the health area name and as value the user's nutritional value
        // here I decided to use an array because I know it will always be of 4 and it should be immutable
        Map.Entry<String, Integer>[] nutritionalValuesArray = new Map.Entry[4];
        nutritionalValuesArray[0] = new AbstractMap.SimpleEntry<>("Immune Health", user_persona.getUserNutritionalValues().getImmuneHealth());
        nutritionalValuesArray[1] = new AbstractMap.SimpleEntry<>("Nutritional Status", user_persona.getUserNutritionalValues().getNutritionalStatus());
        nutritionalValuesArray[2] = new AbstractMap.SimpleEntry<>("Gut Health", user_persona.getUserNutritionalValues().getGutHealth());
        nutritionalValuesArray[3] = new AbstractMap.SimpleEntry<>("Mental Wellness", user_persona.getUserNutritionalValues().getMentalWellness());

        return Arrays.stream(nutritionalValuesArray)
                .sorted(Map.Entry.comparingByValue())
                .toList();
    }

}
