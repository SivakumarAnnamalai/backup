/**
 * Created by sivakumaran on 11/4/2016.
 */

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunit1  extends TestCase{
    @Test
    public void testAdd() {
        //test data
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";

        //check for equality
        assertEquals("Junit is working fine", str);

        //check for false condition
        assertFalse(num > 6);

        //check for not null value
        assertNotNull(str);
    }
}

