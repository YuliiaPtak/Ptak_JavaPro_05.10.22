import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {

    @Test
    public void testAdd() {
        Assertions.assertEquals(0.3, SimpleMathLibrary.add(0.1, 0.2), 0.00001);
    }

    @Test
    public void testAddNegative() {
        Assertions.assertEquals(-0.3, SimpleMathLibrary.add(-0.1, -0.2), 0.00001);
    }

    @Test
    public void testAddWithZero() {
        Assertions.assertEquals(0.3, SimpleMathLibrary.add(0.3, 0), 0.00001);
    }

    @Test
    public void testMinus() {
        Assertions.assertEquals(0.5, SimpleMathLibrary.minus(0.7, 0.2), 0.00001);
    }

    @Test
    public void testMinusNegative() {
        Assertions.assertEquals(-0.5, SimpleMathLibrary.minus(-0.7, -0.2), 0.00001);
    }

    @Test
    public void testMinusWithZero() {
        Assertions.assertEquals(0.7, SimpleMathLibrary.minus(0.7, 0), 0.00001);
    }
}