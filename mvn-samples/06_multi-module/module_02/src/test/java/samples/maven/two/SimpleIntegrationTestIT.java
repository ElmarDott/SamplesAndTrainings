package samples.maven.two;

import samples.maven.two.Application;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@SuppressWarnings("unchecked")
@RunWith(JUnitPlatform.class)
public class SimpleIntegrationTestIT {

    @Test
    void simpleTestCase() {
        //Arrange
        Application app = new Application();
        //Act
        app.setOne("one");
        //Assume
        assertEquals("one", app.getOne());
        assertNotEquals("two", app.getOne());
    }
}
