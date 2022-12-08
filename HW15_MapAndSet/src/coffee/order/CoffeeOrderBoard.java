package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private int number = 0;

    private final Queue<Order> orders = new LinkedList<>();

    public int add(String name) {
        orders.add(new Order(++number, name));
        return number;
    }

    public void deliver() {
        orders.poll();
    }

    public void deliver(int number) {
        for (Order order : orders) {
            if (order.number == number) {
                orders.remove(order);
                break;
            }
        }
    }

    public void draw() {
        System.out.println("=============\nNum   |  Name");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    public int getNumber(String name) {
        for (Order order : orders) {
            if (order.name.equals(name)) {
                return order.number;
            }
        }
        throw new IllegalArgumentException("Can not find order with name " + name);
    }

    private static class Order {
        private final int number;
        private final String name;

        public Order(int number, String name) {
            this.number = number;
            this.name = name;
        }


        @Override
        public String toString() {
            return number + "   |  " + name;
        }
    }
}
