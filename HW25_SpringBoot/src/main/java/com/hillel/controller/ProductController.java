package com.hillel.controller;

import com.hillel.entity.Product;
import com.hillel.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Long create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/get/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }
}
