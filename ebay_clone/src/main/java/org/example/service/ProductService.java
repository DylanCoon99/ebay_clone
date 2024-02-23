package org.example.service;

import org.example.Product;
import org.example.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int productId) {
        Product product = productRepo.findById(productId);
        return Optional.ofNullable(product);
    }

    public void createProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        // Implement update logic
        productRepo.update(product);
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

}