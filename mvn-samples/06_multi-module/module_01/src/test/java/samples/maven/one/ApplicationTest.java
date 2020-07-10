package samples.maven.one;

import samples.maven.one.Application;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@SuppressWarnings("unchecked")
@RunWith(JUnitPlatform.class)
public class ApplicationTest {

    @Test
    void testObject() {
        assertThat(Application.class, hasValidBeanConstructor());
        assertThat(Application.class, hasValidGettersAndSetters());
        assertThat(Application.class, hasValidBeanToString());
    }
}
