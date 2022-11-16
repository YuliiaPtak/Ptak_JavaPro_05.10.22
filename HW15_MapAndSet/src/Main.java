import coffee.order.CoffeeOrderBoard;
import coffee.order.exceptions.OrderAmountException;

public class Main {
    private static final CoffeeOrderBoard COFFEE_ORDER_BOARD = new CoffeeOrderBoard();

    public static void main(String[] args) {
            addOrder("Bob");
            addOrder("Jack");
            addOrder("Rick");
            addOrder("Tom");

            COFFEE_ORDER_BOARD.draw();
            COFFEE_ORDER_BOARD.deliver();
            COFFEE_ORDER_BOARD.draw();
            COFFEE_ORDER_BOARD.deliver(COFFEE_ORDER_BOARD.getNumber("Rick"));
            COFFEE_ORDER_BOARD.draw();
    }

    public static void addOrder(String name) {
        try {
            System.out.println("Order number " + COFFEE_ORDER_BOARD.add(name) + " has been added");
        } catch (OrderAmountException e) {
            System.out.println("Too many orders, please, try again later");
        }
    }
}
