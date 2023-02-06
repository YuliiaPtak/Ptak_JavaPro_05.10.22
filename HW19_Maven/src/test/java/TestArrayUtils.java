import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestArrayUtils {

    @Test
    public void testFindMinValue() {
        int actual = ArrayUtils.findMinValue(new int[]{1, 5, 3, 7, 9, -44, 6});
        LoggerService.getInstance().info("testFindMinValue: expected - " + -44 + ", actual - " + actual);
        Assertions.assertEquals(-44, actual);
    }

    @Test
    public void testFindMaxValue() {
        int actual = ArrayUtils.findMaxValue(new int[]{8, 35, 4, 47, 19, -94, 88});
        LoggerService.getInstance().info("testFindMinValue: expected - " + 88 + ", actual - " + actual);
        Assertions.assertEquals(88, actual);
    }
}
