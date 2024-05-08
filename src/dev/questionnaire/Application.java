package dev.questionnaire;

import dev.questionnaire.data_classes.UserQComplete;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {



    public static void main(String[] args) throws IOException {
        Questionnaire questionnaire = new Questionnaire();

        UserQComplete user = questionnaire.runQuestionnaire();

        System.out.println(user.getUsername() + ", thanks for completing the questionnaire");
        System.out.println("These are your nutriValues: " + user.getNutriValuesSummaryMap());
        System.out.println("Here the answers to your questions: " +  user.getQuestionsAnswersSummaryMap());

    }
}
