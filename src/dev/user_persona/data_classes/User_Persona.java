package dev.user_persona.data_classes;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User_Persona {
    String userHealthType; // Sick, Normal, Healthy -- This will be calculated
    NutritionalValues userNutritionalValues; // [IH, NS, GH, MW] -- this will receive the values from the profile,
    List<Map.Entry<String, Integer>> sortedNutritionalValues; // values sorted from lowest to highest
    boolean isBalanced; // true/false -- this will be defined by the variance from values in NutritionalValues


    // constructors
    public User_Persona(String userHealthType, NutritionalValues userNutritionalValues, boolean isBalanced) {
        this.userHealthType = userHealthType;
        this.userNutritionalValues = userNutritionalValues;
        this.isBalanced = isBalanced;
    }

    public User_Persona(NutritionalValues userNutritionalValues) {
        this.userNutritionalValues = userNutritionalValues;
    }


    // getters
    public String getUserHealthType() {
        return userHealthType;
    }

    public NutritionalValues getUserNutritionalValues() {
        return userNutritionalValues;
    }
    public List<Map.Entry<String, Integer>> getSortedNutritionalValues() {
        return sortedNutritionalValues;
    }
    public boolean isBalanced() {
        return isBalanced;
    }

    // setters


    public void setUserHealthType(String userHealthType) {
        this.userHealthType = userHealthType;
    }

    public void setUserNutritionalValues(NutritionalValues userNutritionalValues) {
        this.userNutritionalValues = userNutritionalValues;
    }
    public void setSortedNutritionalValues(List<Map.Entry<String, Integer>> sortedNutritionalValues) {
        this.sortedNutritionalValues = sortedNutritionalValues;
    }

    public void setBalanced(boolean balanced) {
        isBalanced = balanced;
    }

    // equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_Persona that = (User_Persona) o;
        return isBalanced == that.isBalanced && Objects.equals(userHealthType, that.userHealthType) && Objects.equals(userNutritionalValues, that.userNutritionalValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userHealthType, userNutritionalValues, isBalanced);
    }
}
