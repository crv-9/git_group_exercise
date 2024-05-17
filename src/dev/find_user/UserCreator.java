package dev.find_user;

import dev.user_profile.data_classes.User;

import java.util.*;

public class UserCreator {
    // this class will create a user depending on the information available in the database userLine
    // this class receives userLine String[] as a parameter and returns a User object

    // method which decides which private method to use depending on what info is available in the userLine
    public Optional<User> createUser(String[] userLine){

        String valueID = userLine[0];
        String valueIsGatheredData = userLine[1];
        String valueIsQuestionnaireComplete = userLine[8];
        String valueAreProductsRecommended = userLine[11];

        // if ID is blank we do not return a user
        if (userLine[0].isBlank()){
            return Optional.empty();
        }
        // if ID is present, and we do not have booleans --> createBasicUser
        else if (!valueID.isEmpty() && (valueIsGatheredData.isBlank() && valueIsQuestionnaireComplete.isBlank() && valueAreProductsRecommended.isBlank())) {
            return Optional.of(createBasicUser(userLine));
        }
        // if ID is present and rest of booleans are false, we return user only with ID --> createBooleansUser
        else if (!valueID.isEmpty() && (valueIsGatheredData.equalsIgnoreCase("false") && valueIsQuestionnaireComplete.equalsIgnoreCase("false") && valueAreProductsRecommended.equalsIgnoreCase("false"))) {
            return Optional.of(createBooleansUser(userLine));
        }
        // if ID and isGatheredData = true and isQuestionnaireComplete = false and areProductsRecommended = false, we return --> createInfoUser
        else if (!valueID.isEmpty() && (valueIsGatheredData.equalsIgnoreCase("true") && valueIsQuestionnaireComplete.equalsIgnoreCase("false") && valueAreProductsRecommended.equalsIgnoreCase("false"))) {
            return Optional.of(createInfoUser(userLine));
        }
        // if ID and isGatheredData = false and isQuestionnaireComplete = true and areProductsRecommended = false--> createQCompleteUser
        else if (!valueID.isEmpty() && (valueIsGatheredData.equalsIgnoreCase("false") && valueIsQuestionnaireComplete.equalsIgnoreCase("true") && valueAreProductsRecommended.equalsIgnoreCase("false"))) {
            return Optional.of(createQCompleteUser(userLine));
        }
        // if ID and isGatheredData = false and isQuestionnaireComplete = true and areProductsRecommended = false-->  createProdRecommendedUser
        else if (!valueID.isEmpty() && (valueIsGatheredData.equalsIgnoreCase("false") && valueIsQuestionnaireComplete.equalsIgnoreCase("true") && valueAreProductsRecommended.equalsIgnoreCase("true"))) {
            return Optional.of(createProdRecommendedUser(userLine));
        }
        // if ID and isGatheredData = true and isQuestionnaireComplete = true and areProductsRecommended = true-->  createFullUser
        else if (!valueID.isEmpty() && (valueIsGatheredData.equalsIgnoreCase("true") && valueIsQuestionnaireComplete.equalsIgnoreCase("true") && valueAreProductsRecommended.equalsIgnoreCase("true"))) {
            return Optional.of(createFullUser(userLine));
        }

        else return Optional.empty();
    }

    private User createBasicUser(String[] userLine){
        return new User(Integer.parseInt(userLine[0]));
    }

    // creating a user with ID and boolean values
    private User createBooleansUser(String[] userLine){

        int idNumber = Integer.parseInt(userLine[0]);
        boolean isDataGathered = Boolean.parseBoolean(userLine[1]);
        boolean isQuestionnaireComplete = Boolean.parseBoolean(userLine[8]);
        boolean areProductsRecommended = Boolean.parseBoolean(userLine[11]);

        return new User(idNumber, isDataGathered, isQuestionnaireComplete, areProductsRecommended);
    }

    // creating a user with ID, booleans and all userData
    private User createInfoUser(String[] userLine){
        int idNumber = Integer.parseInt(userLine[0]);
        boolean isDataGathered = Boolean.parseBoolean(userLine[1]);
        String name = userLine[2];
        int  age = Integer.parseInt(userLine[3]);
        String email = userLine[4];
        String password = userLine[5];
        double weight = Double.parseDouble(userLine[6]);
        double height = Double.parseDouble(userLine[7]);
        boolean isQuestionnaireComplete = Boolean.parseBoolean(userLine[8]);
        boolean areProductsRecommended = Boolean.parseBoolean(userLine[11]);

        return new User(idNumber, isDataGathered, name, age, email, password, weight, height, isQuestionnaireComplete, areProductsRecommended);
    }

    // creating a user with booleans, and questionnaire maps
    private User createQCompleteUser(String[] userLine){
        int idNumber = Integer.parseInt(userLine[0]);
        boolean isDataGathered = Boolean.parseBoolean(userLine[1]);
        boolean isQuestionnaireComplete = Boolean.parseBoolean(userLine[8]);
        Map<String, Integer> nutriValuesSummaryMap = getNutriValuesSummaryMap(userLine[9]);
        Map<String, String> questionsAnswersSummaryMap = getQuestionsAnswersSummaryMap(userLine[10]);
        boolean areProductsRecommended = Boolean.parseBoolean(userLine[11]);

        return new User(idNumber, isDataGathered, isQuestionnaireComplete, nutriValuesSummaryMap, questionsAnswersSummaryMap,areProductsRecommended);
    }

    // creating a user with booleans, questionnaire maps and recommended products
    private User createProdRecommendedUser(String[] userLine){
        int idNumber = Integer.parseInt(userLine[0]);
        boolean isDataGathered = Boolean.parseBoolean(userLine[1]);
        boolean isQuestionnaireComplete = Boolean.parseBoolean(userLine[8]);
        Map<String, Integer> nutriValuesSummaryMap = getNutriValuesSummaryMap(userLine[9]);
        Map<String, String> questionsAnswersSummaryMap = getQuestionsAnswersSummaryMap(userLine[10]);
        boolean areProductsRecommended = Boolean.parseBoolean(userLine[11]);
        List<String> recommendedProductList = getRecommendedProductList(userLine[12]);

        return new User(idNumber, isDataGathered, isQuestionnaireComplete, nutriValuesSummaryMap, questionsAnswersSummaryMap,areProductsRecommended, recommendedProductList);
    }

    // creating a user with ID, booleans, userData, questionnaire maps and recommended products
    private User createFullUser(String[] userLine){
        int idNumber = Integer.parseInt(userLine[0]);
        boolean isDataGathered = Boolean.parseBoolean(userLine[1]);
        String name = userLine[2];
        int  age = Integer.parseInt(userLine[3]);
        String email = userLine[4];
        String password = userLine[5];
        double weight = Double.parseDouble(userLine[6]);
        double height = Double.parseDouble(userLine[7]);
        boolean isQuestionnaireComplete = Boolean.parseBoolean(userLine[8]);
        Map<String, Integer> nutriValuesSummaryMap = getNutriValuesSummaryMap(userLine[9]);
        Map<String, String> questionsAnswersSummaryMap = getQuestionsAnswersSummaryMap(userLine[10]);
        boolean areProductsRecommended = Boolean.parseBoolean(userLine[11]);
        List<String> recommendedProductList = getRecommendedProductList(userLine[12]);

        return new User(idNumber, isDataGathered, name, age, email, password, weight, height, isQuestionnaireComplete, nutriValuesSummaryMap, questionsAnswersSummaryMap, areProductsRecommended, recommendedProductList);

    }

    // Helpers - String Unwrappers

    // private create a method to unwrap the string into a map
    // {gh=7, mw=10, ns=12, ih=10}
    private Map<String, Integer> getNutriValuesSummaryMap(String mapString){
        // clean string - remove curly braces and whitespaces
        mapString = mapString.replaceAll("[{}\\s]", "");

        // split the string by commas
        String[] pairs = mapString.split(",");

        Map<String, Integer> resultMap = new HashMap<>();

        for (String pair: pairs) {
            // split each pair and separate key and value
            String[] keyValue = pair.split("=");
            resultMap.put(keyValue[0],Integer.parseInt(keyValue[1]));
        }
        return resultMap;
    }

    //private create a method to unwrap string into map
    // {ih_1_cold-infections=4 -Very often, mw_1_stress=3 -Occasionally, mw_3_sleep=1 -Never, ns_3_fruits-veggies=3 -Rarely (1 x week), gh_1_digestive-discomfort=3 -Occasionally, mw_2_focus-motivation=2 -Not very difficult, ns_1_weight-management=1 -Never, ih_3_environment=2 -Rarely, ns_2_diet-nutrients=2 -To some extent, gh_2_fermented-probiotics=1 -Very often, gh_3_sugary-fatty=2 -Rarely, ih_2_energy-levels=2 -Rarely}

    private Map<String, String> getQuestionsAnswersSummaryMap(String mapString){
        // clean string - remove curly braces and whitespaces
        mapString = mapString.replaceAll("[{}\\s]", "");

        // split the string by commas
        String[] pairs = mapString.split(",");

        Map<String, String> resultMap = new HashMap<>();

        for (String pair: pairs) {
            // split each pair and separate key and value
            String[] keyValue = pair.split("=");
            resultMap.put(keyValue[0],keyValue[1]);
        }
        return resultMap;
    }

    // get string list with products to be recommended
    private List<String> getRecommendedProductList(String listString){
        String[] products = listString.split(",");
        return new ArrayList<>(Arrays.asList(products));
    }



}
