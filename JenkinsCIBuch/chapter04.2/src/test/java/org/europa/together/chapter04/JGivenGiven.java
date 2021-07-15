package org.europa.together.chapter04;

import com.tngtech.jgiven.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(JUnitPlatform.class)
public class JGivenGiven extends Stage<JGivenGiven> {

    JGivenGiven condition01() {
        System.err.println("Condition 01");
        assertTrue(true);

        return self();
    }

    JGivenGiven condition02() {
        System.err.println("Condition 02");
        assertTrue(true);

        return self();
    }

}
