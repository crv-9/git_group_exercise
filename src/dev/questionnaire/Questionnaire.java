package dev.questionnaire;

import dev.questionnaire.data_classes.UserQComplete;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Questionnaire {
    // to build the questionnaire
    FileReader reader = new FileReader();
    String fileString = "src/dev/questionnaire/files/Supp_Buddy_questions-input.csv";
    Path filePath = Path.of(fileString);
    Parser parser = new Parser();

    // this class will call all question classes and collect all question answers to add into user

    // this map will have the total sum of the nutriValues per nutriArea
    Map<String, Integer> nutriValuesSummaryMap = new HashMap<>(Map.of(
            "ns", 0,
            "ih",0,
            "gh",0,
            "mw", 0
    ));

    // here I want a map of the questionID and the answer selected for each
    // this will later be used to show it in user's profile.
    Map<String, String> questionAnswersSummaryMap = new HashMap<>();

    String userInputName;

    // when I run the questionnaire I'll get a user with all the values inside.

    public UserQComplete runQuestionnaire() throws IOException {

        List<String> fileLines = reader.readLines(filePath);
        List<Question> questionsList = buildQuestionnaire(fileLines);


        // intro + ask name + create UserQComplete
        System.out.println("Welcome to Supp Buddy! Let's get to know you a bit better :)");
        UserQComplete user = new UserQComplete(askName());
        userInputName = user.getUsername();

        for (Question question: questionsList) {

            question.askQuestion();

            questionAnswersSummaryMap.put(question.questionID, question.selectedAnswer);

            Map<String, Integer> answer = question.getNutriValues();
            nutriValuesSummaryMap.replace("ns",nutriValuesSummaryMap.get("ns") + answer.get("ns"));
            nutriValuesSummaryMap.replace("ih",nutriValuesSummaryMap.get("ih") + answer.get("ih"));
            nutriValuesSummaryMap.replace("gh",nutriValuesSummaryMap.get("gh") + answer.get("gh"));
            nutriValuesSummaryMap.replace("mw",nutriValuesSummaryMap.get("mw") + answer.get("mw"));
        }

        user.setQuestionsAnswersSummaryMap(getFinalAnswers());
        user.setNutriValuesSummaryMap(getFinalNutriValues());

        return user;
    }

    public Map<String, Integer> getFinalNutriValues(){
        return nutriValuesSummaryMap;
    }

    public Map<String, String> getFinalAnswers(){
        return questionAnswersSummaryMap;
    }

    // I want to read the csv with the questions and answers to build the questionnaire and run it

    private String askName(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("What's your name?");
        return userInput.nextLine();
    }

    private List<Question> buildQuestionnaire(List<String> fileLines){
        // skipping first line as it only has the csv structure

        List<Question> questionList = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); i++) {
            // I need to create a question for each line
            String line = fileLines.get(i);
            questionList.add(
                    new Question(parser.getQuestionID(line),
                            parser.getQuestionString(line),
                            parser.getAnswerOptions(line),
                            parser.getAnswersNutriValues(line)));
        }

        return questionList;
    }

}
