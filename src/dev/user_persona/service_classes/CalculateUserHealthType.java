package dev.user_persona.service_classes;

import dev.user_persona.data_classes.User_Persona;

public class CalculateUserHealthType {
    // this class will receive a User_Persona, calculate its healthType and set it back in the User Persona

    public static String calculateHealthType(User_Persona user_persona) {

        // there must be a way to get these values in a cleaner/leaner way
        int ih = user_persona.getUserNutritionalValues().getImmuneHealth();
        int ns = user_persona.getUserNutritionalValues().getNutritionalStatus();
        int gh = user_persona.getUserNutritionalValues().getGutHealth();
        int mw = user_persona.getUserNutritionalValues().getMentalWellness();

        // can these be stored in a "constants file" where it would be easy to adapt and have an overview? 
        int minValueNormal = 16;
        int minValueHealthy = 28;

        int valuesSum = ih + ns + gh + mw;

        
        if (valuesSum >= minValueNormal && valuesSum < minValueHealthy){
            return "normal";
        } else if (valuesSum >= minValueHealthy) {
            return "healthy";
        } else return "sick";


    }
}
