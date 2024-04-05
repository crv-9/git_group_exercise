package products;

public class Product {
  private String name;
  private String price;
  private int immuneHealthScore;
  private int nutritionScore;
  private int gutHealthScore;
  private int mentalWellnessScore;

    public Product(String name, String price, int immuneHealthScore, int nutritionScore, int gutHealthScore, int mentalWellnessScore) {
        this.name = name;
        this.price = price;
        this.immuneHealthScore = immuneHealthScore;
        this.nutritionScore = nutritionScore;
        this.gutHealthScore = gutHealthScore;
        this.mentalWellnessScore = mentalWellnessScore;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImmuneHealthScore() {
        return immuneHealthScore;
    }

    public int getNutritionScore() {
        return nutritionScore;
    }

    public int getGutHealthScore() {
        return gutHealthScore;
    }

    public int getMentalWellnessScore() {
        return mentalWellnessScore;
    }
}
