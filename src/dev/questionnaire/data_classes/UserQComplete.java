package dev.questionnaire.data_classes;

import java.util.Map;

public class UserQComplete {

    // when an instance of this class is created it should store the basic important info
    // for this user, which we will then send to the profile
    // this class instance will contain:
    // user name/ID
    // map of nutrivalues summary
    // map of questions answers summary

    String username;
    Map<String, Integer> nutriValuesSummaryMap;
    Map<String, String> questionsAnswersSummaryMap;

    public UserQComplete(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Integer> getNutriValuesSummaryMap() {
        return nutriValuesSummaryMap;
    }

    public void setNutriValuesSummaryMap(Map<String, Integer> nutriValuesSummaryMap) {
        this.nutriValuesSummaryMap = nutriValuesSummaryMap;
    }

    public Map<String, String> getQuestionsAnswersSummaryMap() {
        return questionsAnswersSummaryMap;
    }

    public void setQuestionsAnswersSummaryMap(Map<String, String> questionsAnswersSummaryMap) {
        this.questionsAnswersSummaryMap = questionsAnswersSummaryMap;
    }
}
