package dev.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class/methods created for a line with the following structure
// question key, question string, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer,firstAnswerInt,nsValue,ihValue,ghValue,mwValue,secondAnswerInt,nsValue,ihValue,ghValue,mwValue,thirdAnswerInt,nsValue,ihValue,ghValue,mwValue,fourthAnswerInt,nsValue,ihValue,ghValue,mwValue

public class Parser {
    public void parseLine(String line){

        getQuestionID(line);
        getQuestionString(line);
        getAnswerOptions(line);
        getAnswersNutriValues(line);
    }

    public Map<Integer, Map<String , Integer>> getAnswersNutriValues(String line){
        String[] splitLine = doLineSplit(line);
        Map<Integer, Map<String, Integer>> answersNutriValuesMap = new HashMap<>();

        // these are the indexes of where the number of the question is located in the csv
        List<Integer> indexIntList = List.of(6,11,16,21);

        // here I go through every index and get the number and the nutriValues for the specific answer and add that to the final map
        for (Integer index: indexIntList) {
            Map<String, Integer> currentAnswerNutrivaluesMap = new HashMap<>();
            for (int i = index+1; i < index+5; i++) {
                // the values are combined in the csv and I need to split them to get the nutriArea and nutriValue map
                currentAnswerNutrivaluesMap.put(splitLine[i].substring(0,2), Integer.parseInt(splitLine[i].substring(2)));
            }
            answersNutriValuesMap.put(Integer.parseInt(splitLine[index]),currentAnswerNutrivaluesMap);
        }
        return answersNutriValuesMap;
    }

    public String getQuestionID(String line){
        String[] splitLine = doLineSplit(line);

        return splitLine[0];
    }

    public String getQuestionString(String line){
        String[] splitLine = doLineSplit(line);
        return splitLine[1];
    }

    public List<String> getAnswerOptions(String line){
        String[] splitLine = doLineSplit(line);
        List<String> answers = new ArrayList<>();
        for (int i = 2; i <6 ; i++) {
            answers.add(splitLine[i]);
        }
        return answers;
    }

    private String[] doLineSplit(String line){
        return line.split(",");
    }


}
