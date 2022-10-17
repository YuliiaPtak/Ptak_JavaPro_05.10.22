public class Triangle implements Figure {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double calculateArea() {
        double p = calculateSemiPerimeter(sideA, sideB, sideC);
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    private double calculateSemiPerimeter(double sideA, double sideB, double sideC) {
        return (sideA + sideB + sideC) / 2;
    }
}
