package org.europa.together.chapter04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SystemUnderTestTest {

    @Test
    void testGetterAndSetter() {
        //Arrange
        int parameter = 1;
        SystemUnderTest sut = new SystemUnderTest();
        // Act
        sut.setParameter(parameter);
        //Assume
        assertEquals(parameter, sut.getParameter());
    }

    @Test
    void testCalculatePower() {
        //Arrange
        int result = 16;
        SystemUnderTest sut = new SystemUnderTest();
        // Act
        sut.setParameter(4);
        //Assume
        assertEquals(result, sut.power());
    }

    @Test
    void testFailCalculatePower() {
        //Arrange
        SystemUnderTest sut = new SystemUnderTest();
        // Act
        int result = sut.power();
        //Assume
        assertEquals(0, result);
    }
}
