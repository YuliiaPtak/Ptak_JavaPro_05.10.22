package com.hillel.service;

import com.hillel.entity.Order;
import com.hillel.entity.Product;
import com.hillel.exception.OrderNotFoundException;
import com.hillel.exception.ProductNotFoundException;
import com.hillel.repository.OrderRepository;
import com.hillel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public void addProduct(Long orderId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ProductNotFoundException("product with id " + productId + " not found"));

        Order order = getById(orderId);
        order.setCost(order.getCost().add(product.getCost()));
        product.setOrder(order);

        productRepository.save(product);
        orderRepository.save(order);
    }

    public Long createOrder(Order order) {
        return orderRepository.save(order).getId();
    }

    public Order getById(Long id) {
        log.info("searching order by id " + id);
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found"));
    }

    public List<Order> getAll() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}
