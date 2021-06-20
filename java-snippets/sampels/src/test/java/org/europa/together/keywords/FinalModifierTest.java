package org.europa.together.keywords;

import org.europa.together.keywords.FinalModifier;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
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
