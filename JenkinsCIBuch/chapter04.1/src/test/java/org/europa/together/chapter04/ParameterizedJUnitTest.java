package org.europa.together.chapter04;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ParameterizedJUnitTest {

    static Stream<Arguments> arrayStream() {
        return Stream.of(
                Arguments.of(2, 3, 6), // {0} = a
                Arguments.of(5, 3, 15), // {1} = b
                Arguments.of(6, 6, 36) // {2} = y
        );
    }

    @ParameterizedTest(name = "{index}: Test with {0} x {1} = {2} ")
    @MethodSource("arrayStream")
    void multiplyTest(int a, int b, int y) {
        ToTestClass tester = new ToTestClass();
        assertEquals(y, tester.multiply(a, b));

    }

    // class to be tested
    private class ToTestClass {

        public int multiply(int i, int j) {
            return i * j;
        }
    }
}
