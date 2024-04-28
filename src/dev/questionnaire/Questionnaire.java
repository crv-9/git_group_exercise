package dev.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questionnaire {
    Parser parser = new Parser();

    // this class will call all question classes and host all question answers

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

    // after I run the questionnaire I want to have
    // the nutriValues summary
    // the map of each question and answer

    public List<Map<?,?>> runQuestionnaire(List<String> fileLines) {
        List<Question> questionsList = buildQuestionnaire(fileLines);

        // this ? wildcard helps us create a list with maps that have different data types inside each map
        List<Map<?, ?>> finalAnswersList = new ArrayList<>();
        for (Question question: questionsList) {

            question.askQuestion();

            questionAnswersSummaryMap.put(question.questionID, question.selectedAnswer);

            Map<String, Integer> answer = question.getNutriValues();
            nutriValuesSummaryMap.replace("ns",nutriValuesSummaryMap.get("ns") + answer.get("ns"));
            nutriValuesSummaryMap.replace("ih",nutriValuesSummaryMap.get("ih") + answer.get("ih"));
            nutriValuesSummaryMap.replace("gh",nutriValuesSummaryMap.get("gh") + answer.get("gh"));
            nutriValuesSummaryMap.replace("mw",nutriValuesSummaryMap.get("mw") + answer.get("mw"));
        }

        finalAnswersList.add(getFinalAnswers());
        finalAnswersList.add(getFinalNutriValues());

        return finalAnswersList;
    }

    public Map<String, Integer> getFinalNutriValues(){
        return nutriValuesSummaryMap;
    }

    public Map<String, String> getFinalAnswers(){
        return questionAnswersSummaryMap;
    }

    // I want to read the csv with the questions and answers to build the questionnaire and run it
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
