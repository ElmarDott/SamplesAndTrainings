package org.europa.together.chapter04;

import com.tngtech.jgiven.Stage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(JUnitPlatform.class)
public class JGivenAction extends Stage<JGivenAction> {

    JGivenAction action01() {
        System.err.println("Action 01");
        assertTrue(true);

        return self();
    }
}
