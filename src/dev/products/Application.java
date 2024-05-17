package dev.products;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> nutriValuesUser1 = Map.of("IH", 10, "NS", 5, "GH", 5, "MW", 2);
        Map<String, Integer> nutriValuesUser2 = Map.of("IH", 6, "NS", 6, "GH", 6, "MW", 6);
        Map<String, Integer> nutriValuesUser3 = Map.of("IH", 4, "NS", 9, "GH", 3, "MW", 5);
        Map<String, Integer> nutriValuesUser4 = Map.of("IH", 1, "NS", 2, "GH", 8, "MW", 5);

        ProductRecommender recommender = new ProductRecommender();
        List<Product> recommendedProducts = recommender.recommendProducts(nutriValuesUser4);
        for (Product product : recommendedProducts) {
            System.out.println(product.getName());
        }
    }
}
