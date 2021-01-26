package samples.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elmar DOtt
 */
public class Application {

    private String one;
    private String two;
    private String three;

    public Application() {
        // nothing to do...
    }

    @Override
    public String toString() {
        return "Application{"
                + "one=" + one + ", two=" + two + ", three=" + three
                + '}';
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

}
