package com.hillel.controller;

import com.hillel.entity.Order;
import com.hillel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/get/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping("/create")
    public Long create() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setCost(new BigDecimal(0));
        return orderService.createOrder(order);
    }

    @PutMapping("/add-product/{orderId}/{productId}")
    public void addProduct(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.addProduct(orderId, productId);
    }

    @DeleteMapping("delete/{orderId}")
    public void delete(@PathVariable Long orderId) {
        orderService.delete(orderId);
    }
}
