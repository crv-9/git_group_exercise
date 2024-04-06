package dev.user_persona.test_classes;

import dev.user_persona.data_classes.NutritionalValues;
import dev.user_persona.data_classes.User_Persona;
import dev.user_persona.service_classes.CalculateUserHealthType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculateUserHealthTypeTest {

    CalculateUserHealthType calculator = new CalculateUserHealthType();

    @Test
    public void calculateHealthType(){
        User_Persona testUser = new User_Persona(new NutritionalValues(8,9,8,8));

        String result = calculator.calculateHealthType(testUser);

        String expected = "healthy";

        assertEquals(expected, result);
    }

}
