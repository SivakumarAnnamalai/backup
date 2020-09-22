/**
 * Created by sivakumaran on 11/4/2016.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }

    @Test
    public void testAdd2() {
        String str = "Junit is working not fine";
        assertEquals("Junit is working fine",str);
    }
}
