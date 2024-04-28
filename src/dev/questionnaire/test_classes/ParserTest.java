package dev.questionnaire.test_classes;

import dev.questionnaire.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    Parser parser = new Parser();

    String inputLine = "ns_1_weight-management,Do you experience any difficulties in managing your weight?,1 -Never,2 -Rarely,3 -Sometimes,4 -Frequently,1,ns5,ih2,gh3,mw2,2,ns3,ih1,gh1,mw1,3,ns-1,ih0,gh0,mw0,4,ns-3,ih-1,gh-1,mw-1";

    @Test
    void getQuestionID(){
        String result = parser.getQuestionID(inputLine);
        System.out.println(result);
        assertEquals("ns_1_weight-management", result);
    }

    @Test
    void getQuestionString(){
        String result = parser.getQuestionString(inputLine);
        System.out.println(result);
        assertEquals("Do you experience any difficulties in managing your weight?", result);
    }

    @Test
    void getAnswerOptions(){
        List<String> result = parser.getAnswerOptions(inputLine);
        System.out.println(result);
    }

    @Test
    void getAnswersNutriValues(){
        Map<Integer, Map<String , Integer>> result = parser.getAnswersNutriValues(inputLine);
        System.out.println(result);
    }
}
