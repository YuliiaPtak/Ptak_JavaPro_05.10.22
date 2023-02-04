import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {
    @Test
    public void testGetNumbersAfterLastFour() {
        Assertions.assertArrayEquals(
                ArrayUtils.getNumbersAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                new int[]{1, 7}
        );
    }

    @Test
    public void testGetNumbersAfterLastFour_withoutFour() {
        Assertions.assertArrayEquals(
                ArrayUtils.getNumbersAfterLastFour(new int[]{1, 2, 2, 3, 1, 7}),
                new int[]{}
        );
    }

    @Test
    public void testGetNumbersAfterLastFour_endWithFour() {
        Assertions.assertArrayEquals(
                ArrayUtils.getNumbersAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7, 4}),
                new int[]{}
        );
    }

    @Test
    public void testIsConsistOfFourAndOne() {
        Assertions.assertTrue(ArrayUtils.isConsistOfFourAndOne(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    public void testIsConsistOfFourAndOne_ifConsistOfOne() {
        Assertions.assertFalse(ArrayUtils.isConsistOfFourAndOne(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void testIsConsistOfFourAndOne_ifConsistOfFour() {
        Assertions.assertFalse(ArrayUtils.isConsistOfFourAndOne(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void testIsConsistOfFourAndOne_ifContainsOtherNumber() {
        Assertions.assertFalse(ArrayUtils.isConsistOfFourAndOne(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }
}
