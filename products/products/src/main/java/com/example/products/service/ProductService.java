package com.example.products.service;

import com.example.products.Entity.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductsByCategory(String category) {

        return productRepository.findByCategory(category);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}