package dev.user_persona.service_classes;

import dev.user_persona.data_classes.User_Persona;

import java.util.List;
import java.util.Map;

public class CalculateUserHealthFocus {
    public static String getHealthFocus(User_Persona user_persona){
        String focusResult = "";

        String healthType = user_persona.getUserHealthType();
        boolean isBalanced = user_persona.isBalanced();
        String balance =  (isBalanced) ? "balanced" : "unbalanced";
        List<Map.Entry<String, Integer>> sortedNutritionalValues = user_persona.getSortedNutritionalValues();

        List<String> areasToFocus = sortedNutritionalValues.stream()
                .limit(2)
                .map(Map.Entry::getKey)
                .toList();

        focusResult = "You seem to be: " + healthType + " " + balance+"\n"+
                        "Let's focus on your " + areasToFocus.get(0) + " & " + areasToFocus.get(1);

        return focusResult;
    }
}
