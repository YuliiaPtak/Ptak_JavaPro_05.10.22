package com.example.service;

import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long create(Product product) {
        return productRepository.save(product).getId();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("product with id " + id + " not found"));
    }

    public List<Product> findAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }
}
