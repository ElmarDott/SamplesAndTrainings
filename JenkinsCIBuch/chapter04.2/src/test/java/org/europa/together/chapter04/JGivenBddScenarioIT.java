package org.europa.together.chapter04;

import com.tngtech.jgiven.junit5.ScenarioTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class JGivenBddScenarioIT extends
        ScenarioTest<JGivenGiven, JGivenAction, JGivenOutcome> {

    @Test
    void testBddExample() {
        //Arrange
        given().condition01()
                .and().condition02();
        // Act
        when().action01();
        //Assume
        then().assume01();
    }
}
