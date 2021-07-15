package org.europa.together.keywords;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.Test;

/**
 *
 * @author ed
 */
@SuppressWarnings("unchecked")
@RunWith(JUnitPlatform.class)
public class FinalModifierTest {

    @Test
    public void testFoo() {
        FinalModifier test = new FinalModifier();
        test.foo();
    }

}
