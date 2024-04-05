package products;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductFileReader {
    private final ProductParser parser = new ProductParser();
    public List<Product> read(String filePath) {
        Path path = Path.of(filePath);
        try {
            return Files.lines(path)
                    .skip(1)
                    .map(parser::parseLine)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
