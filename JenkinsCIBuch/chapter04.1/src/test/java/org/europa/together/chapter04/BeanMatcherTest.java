package org.europa.together.chapter04;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class BeanMatcherTest {

    @Test
    void testObject() {
        assertThat(SystemUnderTest.class, hasValidBeanConstructor());
        assertThat(SystemUnderTest.class, hasValidBeanToString());
        assertThat(SystemUnderTest.class, hasValidBeanHashCodeFor());
        assertThat(SystemUnderTest.class, hasValidBeanEqualsFor());
    }

}
