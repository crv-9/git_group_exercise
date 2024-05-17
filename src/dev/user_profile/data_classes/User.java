package dev.user_profile.data_classes;

import java.util.List;
import java.util.Map;

public class User {
    private static int idCounter = 1000; //this will keep track of the ID

    private final int idNumber; // Unique ID for each instance
    private boolean isDataGathered;
    private String name;
    private int  age;
    private String email;
    private String password; // Can be hashed
    private double weight;
    private double height;
    private boolean isQuestionnaireComplete;
    Map<String, Integer> nutriValuesSummaryMap;
    Map<String, String> questionsAnswersSummaryMap;
    private boolean areProductsRecommended;
    private List<String> recommendedProductList;

// CONSTRUCTORS


    // create user only with ID
    public User(int idNumber) {
        this.idNumber = idNumber;
    }

    // create user only with ID number and booleans
    public User(int idNumber, boolean isDataGathered, boolean isQuestionnaireComplete, boolean areProductsRecommended) {
        this.idNumber = idNumber;
        this.isDataGathered = isDataGathered;
        this.isQuestionnaireComplete = isQuestionnaireComplete;
        this.areProductsRecommended = areProductsRecommended;
    }

    // create user with ID, booleans and all userData
    public User(int idNumber, boolean isDataGathered, String name, int age, String email, String password, double weight, double height, boolean isQuestionnaireComplete, boolean areProductsRecommended) {
        this.idNumber = idNumber;
        this.isDataGathered = isDataGathered;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.isQuestionnaireComplete = isQuestionnaireComplete;
        this.areProductsRecommended = areProductsRecommended;
    }

    // create user with ID, booleans, all userData and questionnaire maps
    public User(int idNumber, boolean isDataGathered, String name, int age, String email, String password, double weight, double height, boolean isQuestionnaireComplete, Map<String, Integer> nutriValuesSummaryMap, Map<String, String> questionsAnswersSummaryMap, boolean areProductsRecommended) {
        this.idNumber = idNumber;
        this.isDataGathered = isDataGathered;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.isQuestionnaireComplete = isQuestionnaireComplete;
        this.nutriValuesSummaryMap = nutriValuesSummaryMap;
        this.questionsAnswersSummaryMap = questionsAnswersSummaryMap;
        this.areProductsRecommended = areProductsRecommended;
    }

    // create user with ID, booleans and questionnaire maps

    public User(int idNumber, boolean isDataGathered, boolean isQuestionnaireComplete, Map<String, Integer> nutriValuesSummaryMap, Map<String, String> questionsAnswersSummaryMap, boolean areProductsRecommended) {
        this.idNumber = idNumber;
        this.isDataGathered = isDataGathered;
        this.isQuestionnaireComplete = isQuestionnaireComplete;
        this.nutriValuesSummaryMap = nutriValuesSummaryMap;
        this.questionsAnswersSummaryMap = questionsAnswersSummaryMap;
        this.areProductsRecommended = areProductsRecommended;
    }

    // create user with ID, booleans and questionnaire maps

    public User(int idNumber, boolean isDataGathered, boolean isQuestionnaireComplete, Map<String, Integer> nutriValuesSummaryMap, Map<String, String> questionsAnswersSummaryMap, boolean areProductsRecommended, List<String> recommendedProductList) {
        this.idNumber = idNumber;
        this.isDataGathered = isDataGathered;
        this.isQuestionnaireComplete = isQuestionnaireComplete;
        this.nutriValuesSummaryMap = nutriValuesSummaryMap;
        this.questionsAnswersSummaryMap = questionsAnswersSummaryMap;
        this.areProductsRecommended = areProductsRecommended;
        this.recommendedProductList = recommendedProductList;
    }

    //  Full User - create user with ID, booleans, all userData, questionnaire maps and productRecommendations
    public User(int idNumber, boolean isDataGathered, String name, int age, String email, String password, double weight, double height, boolean isQuestionnaireComplete, Map<String, Integer> nutriValuesSummaryMap, Map<String, String> questionsAnswersSummaryMap, boolean areProductsRecommended, List<String> recommendedProductList) {
        this.idNumber = idNumber;
        this.isDataGathered = isDataGathered;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.isQuestionnaireComplete = isQuestionnaireComplete;
        this.nutriValuesSummaryMap = nutriValuesSummaryMap;
        this.questionsAnswersSummaryMap = questionsAnswersSummaryMap;
        this.areProductsRecommended = areProductsRecommended;
        this.recommendedProductList = recommendedProductList;
    }

    // TODO this needs to be updated with new fields-   UserService class must be updated too
    public User(String name, int age, String email, String password, double weight, double height) {
        this.idNumber = getNextID(); // Assign a unique ID to this instance
        this.name = name;
        this.age = age;
        this.email = email;
        this.weight = weight;
        this.height = height;
    }

// GETTERS
    // Static method to increment and return the next ID
     private static synchronized int getNextID() {
        return ++idCounter;
    }

    public int getIdNumber() {
        return idNumber;
    }
    public boolean isDataGathered() {
        return isDataGathered;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public boolean isQuestionnaireComplete() {
        return isQuestionnaireComplete;
    }
    public Map<String, Integer> getNutriValuesSummaryMap() {
        return nutriValuesSummaryMap;
    }
    public Map<String, String> getQuestionsAnswersSummaryMap() {
        return questionsAnswersSummaryMap;
    }
    public boolean isAreProductsRecommended() {
        return areProductsRecommended;
    }
    public List<String> getRecommendedProductList() {
        return recommendedProductList;
    }

// SETTERS
    public void setDataGathered(boolean dataGathered) {
        isDataGathered = dataGathered;
    }
    public void setName(String name) {
    this.name = name;
}
    public void setAge(int age) {
    this.age = age;
}
    public void setEmail(String email) {
    this.email = email;
}

    public void setPassword(String password) {
        this.password = password;
    }
    public void setWeight(double weight) {
    this.weight = weight;
}
    public void setHeight(double height) {
        this.height = height;
    }

    public void setQuestionnaireComplete(boolean questionnaireComplete) {
        isQuestionnaireComplete = questionnaireComplete;
    }

    public void setNutriValuesSummaryMap(Map<String, Integer> nutriValuesSummaryMap) {
        this.nutriValuesSummaryMap = nutriValuesSummaryMap;
    }

    public void setQuestionsAnswersSummaryMap(Map<String, String> questionsAnswersSummaryMap) {
        this.questionsAnswersSummaryMap = questionsAnswersSummaryMap;
    }

    public void setAreProductsRecommended(boolean areProductsRecommended) {
        this.areProductsRecommended = areProductsRecommended;
    }

    public void setRecommendedProductList(List<String> recommendedProductList) {
        this.recommendedProductList = recommendedProductList;
    }
}