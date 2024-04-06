package dev.user_persona.data_classes;

public class NutritionalValues {
    int immuneHealth;
    int nutritionalStatus;
    int gutHealth;
    int mentalWellness;


    // constructors


    public NutritionalValues(int immuneHealth, int nutritionalStatus, int gutHealth, int mentalWellness) {
        this.immuneHealth = immuneHealth;
        this.nutritionalStatus = nutritionalStatus;
        this.gutHealth = gutHealth;
        this.mentalWellness = mentalWellness;
    }

    // getters
    public int getImmuneHealth() {
        return immuneHealth;
    }

    public int getNutritionalStatus() {
        return nutritionalStatus;
    }

    public int getGutHealth() {
        return gutHealth;
    }

    public int getMentalWellness() {
        return mentalWellness;
    }

    // setters
    public void setImmuneHealth(int immuneHealth) {
        this.immuneHealth = immuneHealth;
    }

    public void setNutritionalStatus(int nutritionalStatus) {
        this.nutritionalStatus = nutritionalStatus;
    }

    public void setGutHealth(int gutHealth) {
        this.gutHealth = gutHealth;
    }

    public void setMentalWellness(int mentalWellness) {
        this.mentalWellness = mentalWellness;
    }
}
