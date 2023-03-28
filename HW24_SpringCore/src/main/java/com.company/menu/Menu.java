package com.company.menu;

import com.company.cart.Cart;
import com.company.config.Config;
import com.company.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Cart cart;

    public Menu() {
        var context = new AnnotationConfigApplicationContext(Config.class);
        cart = context.getBean(Cart.class);
        Cart cart1 = context.getBean(Cart.class);
    }

    public void run() {
        System.out.println("Menu options:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.ordinal() + " - " + option.toString().toLowerCase());
        }

        MenuOption option;
        do {
            option = selectOption();
            switch (option) {
                case DISPLAY_PRODUCTS -> displayProducts();
                case ADD_TO_CART -> addToCart();
                case REMOVE_FROM_CART -> removeFromCart();
                case DISPLAY_CART -> displayCart();
                case EXIT -> System.out.println("Bye, have a nice day!");
            }
        } while (!MenuOption.EXIT.equals(option));
    }

    private MenuOption selectOption() {
        System.out.println("--------------------");
        int userOption = readNumber("Choose option");
        MenuOption menuOption = MenuOption.getOption(userOption);
        if (menuOption == null) {
            System.out.println("Unknown option " + userOption);
            return selectOption();
        }
        return menuOption;
    }

    public void addToCart() {
        long id = readNumber("Enter product id:");
        try {
            cart.add(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFromCart() {
        long id = readNumber("Enter product id:");
        try {
            cart.delete(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayProducts() {
        print(cart.getProducts());
    }

    public void displayCart() {
        print(cart.getCart());
    }

    private static String readLine(String outputMessage) {
        System.out.println(outputMessage);

        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        if (next == null || next.isBlank()) {
            System.out.println("Incorrect input!");
            return readLine(outputMessage);
        }
        return next;
    }

    private static int readNumber(String outputMessage) {
        String next = readLine(outputMessage);
        try {
            return Integer.parseInt(next);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input!");
            return readNumber(outputMessage);
        }
    }

    private static void print(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Products not found!");
        } else {
            products.forEach(System.out::println);
        }
    }
}
