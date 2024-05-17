package dev.products;

import java.util.*;

public class ProductRecommender {
    ProductFileReader fileReader = new ProductFileReader();
    public List<Product> recommendProducts(Map<String, Integer> nutriValuesSummaryMap) {
        List<Product> products = loadProducts();
        if (products.isEmpty()) {
            System.out.println("No products loaded.");
            return new ArrayList<>();
        }

        List<Product> recommendedProducts = new ArrayList<>();
        Map<Product, Integer> productScores = new HashMap<>();

        int userIH = nutriValuesSummaryMap.get("IH");
        int userNS = nutriValuesSummaryMap.get("NS");
        int userGH = nutriValuesSummaryMap.get("GH");
        int userMW = nutriValuesSummaryMap.get("MW");

        for (Product product : products) {
            int score = (userIH * product.getImmuneHealthScore()) +
                    (userNS * product.getNutritionScore()) +
                    (userGH * product.getGutHealthScore()) +
                    (userMW * product.getMentalWellnessScore());
            productScores.put(product, score);
        }

        productScores.entrySet()
                .stream()
                .sorted(Map.Entry.<Product, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> recommendedProducts.add(entry.getKey()));

        return recommendedProducts;
    }

    private List<Product> loadProducts() {
        List<Product> products = fileReader.read("src/dev/products/supp-buddy-products.csv");
        //System.out.println("Loaded " + products.size() + " products.");
        return products;
    }
}

/*

Calculate Scores for Each Product: For each product, calculate a score based on how well it matches the user's needs in each area. This is done by summing the products of the user's values and the corresponding product values for each area.

Sort Products by Score: Sort the products based on the calculated scores in descending order.

Select Top Three Products: Choose the top three products from the sorted list.
 */