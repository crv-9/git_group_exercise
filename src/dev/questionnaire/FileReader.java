package dev.questionnaire;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public static List<String> readLines(Path filePath) throws IOException {

        return getAllFileLines(filePath);
    }

    public static List<String> getAllFileLines(Path filePath) throws IOException{
        return Files.readAllLines(filePath);
    }
}
