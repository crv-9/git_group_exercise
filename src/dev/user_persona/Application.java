package dev.user_persona;

import dev.user_persona.data_classes.NutritionalValues;
import dev.user_persona.data_classes.User_Persona;
import dev.user_persona.service_classes.RunUserDiagnosis;

public class Application {
    public static void main(String[] args) {
        User_Persona testUser = new User_Persona(new NutritionalValues(7,2,3,8));
        RunUserDiagnosis.getDiagnosis(testUser);
        System.out.println(testUser.getHealthFocus());
    }
}
