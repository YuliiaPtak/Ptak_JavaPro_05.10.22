import exceptions.ArrayDataException;
import exceptions.ArraySizeException;

public class App {
    public static void main(String[] args) {
        String[][] strings = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println(ArrayValueCalculator.calculateNumbers(strings));
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("UNKNOWN ERROR!");
            e.printStackTrace();
        }
    }
}