public class MathUtils {
    public static double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double calculateTriangleArea(double sideA, double sideB, double sideC) {
        double p = calculateSemiPerimeter(sideA, sideB, sideC);
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    private static double calculateSemiPerimeter(double sideA, double sideB, double sideC) {
        return (sideA + sideB + sideC) / 2;
    }
}
