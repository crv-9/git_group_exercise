package dev.user_persona.test_classes;

import dev.user_persona.data_classes.NutritionalValues;
import dev.user_persona.data_classes.User_Persona;
import dev.user_persona.service_classes.OrganizeNutritionalValues;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OrganizeNutritionalValuesTest {

    OrganizeNutritionalValues organizer = new OrganizeNutritionalValues();

    @Test
    void sortValues(){
        User_Persona testUser = new User_Persona(new NutritionalValues(7,9,6,8));

        // line below used only for visualization purposes
        //        System.out.println(organizer.sortValues(testUser));

        List<Map.Entry<String, Integer>> result = organizer.sortValues(testUser);

        List<Map.Entry<String, Integer>> expected = List.of(
                new AbstractMap.SimpleEntry<>("Gut Health",6),
                new AbstractMap.SimpleEntry<>("Immune Health",7),
                new AbstractMap.SimpleEntry<>("Mental Wellness",8),
                new AbstractMap.SimpleEntry<>("Nutritional Status",9)
        );

        assertEquals(expected, result);
    }


}
