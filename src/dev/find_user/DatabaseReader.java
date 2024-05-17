package dev.find_user;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader {

    public static List<String> getUsersLines(){
        List<String> usersLines = new ArrayList<>();
        List<String> databaseLines = getDatabaseLines();

        for (int i = 2; i < databaseLines.size(); i++) {
            usersLines.add(databaseLines.get(i));
        }
        return usersLines;
    }
    private static List<String> getDatabaseLines(){
        try {
            return new ArrayList<>(DatabaseReader.getDatabaseAllLines());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getDatabaseAllLines() throws IOException {
        // TODO update the database path from Content Root
        String databasePathString = "src/dev/find_user/database_file_examples.csv";
        Path databasePath = Path.of(databasePathString);

        return readDatabaseLines(databasePath);
    }

    public static List<String> readDatabaseLines(Path databasePath) throws IOException{
        return Files.readAllLines(databasePath);
    }
}
