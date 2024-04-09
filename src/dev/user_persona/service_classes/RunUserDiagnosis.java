package dev.user_persona.service_classes;

import dev.user_persona.data_classes.User_Persona;

public class RunUserDiagnosis {
    public static void getDiagnosis(User_Persona user_persona){

        // setting userHealthType, userBalance & sortedNutritionalValues
        user_persona.setUserHealthType(CalculateUserHealthType.calculateHealthType(user_persona));
        user_persona.setBalanced(CalculateUserBalance.calculateBalance(user_persona));
        user_persona.setSortedNutritionalValues(OrganizeNutritionalValues.sortValues(user_persona));
        user_persona.setHealthFocus(CalculateUserHealthFocus.getHealthFocus(user_persona));

    }
}
