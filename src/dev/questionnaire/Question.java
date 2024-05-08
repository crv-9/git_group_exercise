package dev.questionnaire;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Question {
    String questionID;
    String questionString;
    List<String> answers;
    int userAnswer;
    String selectedAnswer;

    // answerNumber, nutriArea, nutriValue
    // where should I create new HashMap?
    Map<Integer, Map<String, Integer>> answersNutriValues;

    // constructor


    public Question(String questionID, String questionString, List<String> answers, Map<Integer, Map<String, Integer>> answersNutriValues) {
        this.questionID = questionID;
        this.questionString = questionString;
        this.answers = answers;
        this.answersNutriValues = answersNutriValues;
    }

    // run the question
    public void askQuestion(){
        // for now I will use scanner for testing
        Scanner userInput = new Scanner(System.in);
        System.out.println(questionString);
        for (String answer: answers) {
            System.out.println("   "+answer);
        }

        userAnswer = userInput.nextInt();

        selectedAnswer = answers.get(userAnswer-1);
    }


    public Map<String, Integer> getNutriValues(){
        return answersNutriValues.get(userAnswer);
    }
}
