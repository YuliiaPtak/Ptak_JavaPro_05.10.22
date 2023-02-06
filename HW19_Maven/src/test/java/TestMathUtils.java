import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMathUtils {

    @Test
    public void testCalculateCircleArea() {
        double actual = MathUtils.calculateCircleArea(30);
        LoggerService.getInstance().info("testCalculateCircleArea: expected - " + 2827.4333 + ", actual - " + actual);
        Assertions.assertEquals(2827.4333, actual, 0.0001);
    }

    @Test
    public void testCalculateTriangleArea() {
        double actual = MathUtils.calculateTriangleArea(30, 45, 50);
        LoggerService.getInstance().info("testCalculateTriangleArea: expected - " + 666.5852 + ", actual - " + actual);
        Assertions.assertEquals(666.5852, actual, 0.0001);
    }
}
