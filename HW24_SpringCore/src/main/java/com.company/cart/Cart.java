package com.company.cart;

import com.company.model.Product;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final ProductRepository productRepository;

    private final Map<Long, Product> productMap;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productMap = new HashMap<>();
        System.out.println("cart created");
    }

    public void add(long id) {
        productMap.put(id, productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found by id " + id)));
    }

    public void delete(long id) {
        productMap.remove(id, productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found by id " + id)));
    }

    public List<Product> getCart() {
        return new ArrayList<>(productMap.values());
    }

    public List<Product> getProducts() {
        return productRepository.getAll();
    }
}
