package com.company.cart;

import com.company.model.Product;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final ProductRepository productRepository;

    private final Map<Long, List<Product>> productMap;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productMap = new HashMap<>();
    }

    public void add(long id) {
        productMap.computeIfAbsent(id, p -> new ArrayList<>())
                .add(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found by id " + id)));
    }

    public void delete(long id) {
        if (productMap.containsKey(id)) {
            List<Product> products = productMap.get(id);
            if (products.isEmpty()) {
                throw new RuntimeException("Product not found by id " + id);
            }
            products.remove(0);
        } else throw new RuntimeException("Product not found by id " + id);
    }

    public List<Product> getCart() {
        return productMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<Product> getProducts() {
        return productRepository.getAll();
    }
}
