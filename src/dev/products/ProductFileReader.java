package dev.products;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductFileReader {
    public List<Product> read(String filePath) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Split considering quoted commas
                try {
                    Product product = new Product(
                            values[0], // name
                            values[1], // price
                            Integer.parseInt(values[5]), // immune health score
                            Integer.parseInt(values[6]), // nutrition score
                            Integer.parseInt(values[7]), // gut health score
                            Integer.parseInt(values[8])  // mental wellness score
                    );
                    products.add(product);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing product: " + String.join(",", values));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}

