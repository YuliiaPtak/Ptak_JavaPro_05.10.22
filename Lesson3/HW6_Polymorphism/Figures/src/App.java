public class App {
    public static void main(String[] args) {
        Figure triangle = new Triangle(10, 15, 8);
        Figure circle = new Circle(5);
        Figure square = new Square(7);

        System.out.println("Area of triangle = " + triangle.calculateArea() + " cm²");
        System.out.println("Area of circle = " + circle.calculateArea() + " cm²");
        System.out.println("Area of square = " + square.calculateArea() + " cm²");

        Figure[] figures = new Figure[]{triangle, circle, square};
        calculateSumOfAreas(figures);
    }

    public static void calculateSumOfAreas(Figure[] figures) {
        double sum = 0;
        for (Figure figure : figures) {
            sum = sum + figure.calculateArea();
        }
        System.out.println("Sum of areas = " + sum + " cm²");
    }
}
