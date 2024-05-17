package dev.find_user.test_classes;

import dev.find_user.UserCreator;
import dev.find_user.UserLineParser;
import dev.user_profile.data_classes.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UserCreatorTest {
    UserCreator userCreator = new UserCreator();
    UserLineParser userLineParser = new UserLineParser();


    @Test
    void userCreator(){
        String string = "0003,FALSE,,,,,,,TRUE,{gh=21, mw=24, ns=22, ih=24},{ih_1_cold-infections=2 -Rarely, mw_1_stress=2 -Rarely, mw_3_sleep=2 -Rarely, ns_3_fruits-veggies=1 -Very frequently (5-7 x week), gh_1_digestive-discomfort=1 -Never, mw_2_focus-motivation=1 -Not difficult at all, ns_1_weight-management=1 -Never, ih_3_environment=2 -Rarely, ns_2_diet-nutrients=2 -To some extent, gh_2_fermented-probiotics=2 -Occasionally, gh_3_sugary-fatty=1 -Never, ih_2_energy-levels=1 -Never},TRUE,[p7, p8, p9]";
        String[] array = userLineParser.getCSVLineParser(string);

        Optional<User> result = userCreator.createUser(array);

        System.out.println(result.get().getNutriValuesSummaryMap());
        System.out.println(result.get().isDataGathered());

    }

}
