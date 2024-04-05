package products;

import java.util.List;
import java.util.Optional;

public class ProductParser {
    private final int elementsPerLine = 10; private final int nameIndex = 0; private final int priceIndex = 1;
    private final int immuneHealthScoreIndex = 5; private final int nutritionalStatusScoreIndex = 6;
    private final int gutHealthScoreIndex = 7; private final int mentalWellnessScoreIndex = 8;

    public Optional<Product> parseLine(String line) {
        List<String> elements = List.of(line.split(";", -1));

        if (elements.size() != elementsPerLine) {
            return Optional.empty();
        }

    return parseValues(elements.get(nameIndex), elements.get(priceIndex), elements.get(immuneHealthScoreIndex), elements.get(nutritionalStatusScoreIndex),
            elements.get(gutHealthScoreIndex), elements.get(mentalWellnessScoreIndex));
    }

    Optional<Product> parseValues(String name, String price, String immuneHealthScoreString, String nutritionalStatusScoreString,
                                  String gutHealthScoreString, String mentalWellnessScoreString) {
        try {
            int immuneHealthScore = Integer.parseInt(immuneHealthScoreString);
            int nutritionalStatusScore = Integer.parseInt(nutritionalStatusScoreString);
            int gutHealthScore = Integer.parseInt(gutHealthScoreString);
            int mentalWellnessScore = Integer.parseInt(mentalWellnessScoreString);
            Product product = new Product(name, price, immuneHealthScore, nutritionalStatusScore, gutHealthScore, mentalWellnessScore);
            return Optional.of(product);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
