package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductRepo;
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

    public Product createProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    public Product updateProduct(Product product) {
        // Implement update logic
        productRepo.update(product);
        return productRepo.findById(product.getProductID());
    }

    public void deleteProduct(int productId) {
        productRepo.delete(productId);
    }

}
