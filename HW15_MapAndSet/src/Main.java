import coffee.order.CoffeeOrderBoard;
import coffee.order.exceptions.OrderAmountException;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard COFFEE_ORDER_BOARD = new CoffeeOrderBoard();
            COFFEE_ORDER_BOARD.add("Bob");
            COFFEE_ORDER_BOARD.add("Jack");
            COFFEE_ORDER_BOARD.add("Rick");
            COFFEE_ORDER_BOARD.add("Tom");

            COFFEE_ORDER_BOARD.draw();
            COFFEE_ORDER_BOARD.deliver();
            COFFEE_ORDER_BOARD.draw();
            COFFEE_ORDER_BOARD.deliver(COFFEE_ORDER_BOARD.getNumber("Rick"));
            COFFEE_ORDER_BOARD.draw();
    }
}
