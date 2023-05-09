package com.example.webServlet.repository;

import com.example.webServlet.entity.Order;
import com.example.webServlet.entity.Product;
import com.example.webServlet.exception.OrderNotFoundException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Cola", new BigDecimal(15)));
        products.add(new Product(2L, "Fanta", new BigDecimal(20)));
        products.add(new Product(3L, "Sprite", new BigDecimal(25)));

        add(new Order(1L, LocalDate.now(), new BigDecimal(60), products));

        List<Product> newProducts = new ArrayList<>();
        newProducts.add(new Product(4L, "Pepsi", new BigDecimal(10)));
        newProducts.add(new Product(5L, "Mirinda", new BigDecimal(15)));
        newProducts.add(new Product(6L, "7up", new BigDecimal(20)));

        add(new Order(2L, LocalDate.now(), new BigDecimal(45), newProducts));

    }

    public Order findById(Long id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found"));
    }

    public List<Order> findAll() {
        return orders;
    }

    public void add(Order order) {
        orders.add(order);
    }
}
