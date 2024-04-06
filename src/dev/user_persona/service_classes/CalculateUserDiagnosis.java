package dev.user_persona.service_classes;

import dev.user_persona.data_classes.User_Persona;

public class CalculateUserDiagnosis {
    public static void runDiagnosis(User_Persona user_persona){

        // setting userHealthType & userBalance
        user_persona.setUserHealthType(CalculateUserHealthType.calculateHealthType(user_persona));
        user_persona.setBalanced(CalculateUserBalance.calculateBalance(user_persona));

    }
}
