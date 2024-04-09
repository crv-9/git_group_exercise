package dev.user_profile.data_classes;

public class User {
    private static int idCounter = 1000; //this will keep track of the ID

private final int idNumber; // Unique ID for each instence
    private String name;
    private int  age;
    private String email;
    private double weight;
    private double height;
    private String password; // Can be hashed 

    public User(String name, int age, String email, String password, double weight, double height) {
        this.idNumber = getNextID(); // Assign a unique ID to this instance
        this.name = name;
        this.age = age;
        this.email = email;
        this.weight = weight;
        this.height = height;
    }
     // Static method to increment and return the next ID
     private static synchronized int getNextID() {
        return ++idCounter;
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
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public int getIdNumber() {
        return idNumber;
    }
public void setName(String name) {
    this.name = name;
}
public void setAge(int age) {
    this.age = age;
}
public void setEmail(String email) {
    this.email = email;
}public void setHeight(double height) {
    this.height = height;
}
public void setWeight(double weight) {
    this.weight = weight;
} 
public void setPassword(String password) {
    this.password = password;
}   
}