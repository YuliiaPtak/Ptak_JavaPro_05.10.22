package com.company.repository;

import com.company.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
        products.put(1L, new Product(1, new BigDecimal(5), "cola"));
        products.put(2L, new Product(2, new BigDecimal(10), "fanta"));
        products.put(3L, new Product(3, new BigDecimal(7), "sprite"));
        products.put(4L, new Product(4, new BigDecimal(15), "coffee"));
    }

    public Optional<Product> findById(long id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }
}