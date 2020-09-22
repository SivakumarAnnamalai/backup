import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by sivakumaran on 11/5/2016.
 */
@RunWith(Parameterized.class)
public class CalculatorTest {
    enum Type {SUBSTRACT, ADD};
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {Type.SUBSTRACT, 3.0, 2.0, 1.0},
                {Type.ADD, 23.0, 5.0, 28.0}
        });
    }

    private Type type;
    private Double a, b, expected;

    public CalculatorTest(Type type, Double a, Double b, Double expected){
        this.type = type;
        this.a=a; this.b=b; this.expected=expected;
    }

    @Test
    public void testAdd(){
        Assume.assumeTrue(type == Type.ADD);
        assertEquals(expected, Calculator.add(a, b));
    }

    @Test
    public void testSubstract(){
        Assume.assumeTrue(type == Type.SUBSTRACT);
        assertEquals(expected, Calculator.substract(a, b));
    }
}
