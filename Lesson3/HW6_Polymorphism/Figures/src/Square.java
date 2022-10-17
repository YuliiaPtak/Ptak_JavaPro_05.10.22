public class Square implements Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return Math.pow(side, 2);
    }
}
