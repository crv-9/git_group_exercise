package dev.questionnaire;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {



    public static void main(String[] args) throws IOException {
        Questionnaire questionnaire = new Questionnaire();
        FileReader reader = new FileReader();
        String fileString = "src/dev/questionnaire/files/Supp_Buddy_questions-input.csv";
        Path filePath = Path.of(fileString);

        List<Map<?,?>> answersMapsList = questionnaire.runQuestionnaire(reader.readLines(filePath));

        for (Map<?,?> map: answersMapsList) {
            System.out.println(map);
        }
        
    }
}
