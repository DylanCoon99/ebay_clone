package org.example.repository;
import org.example.model.Product;

import java.util.List;

public interface ProductRepo {

    Product findById(int productId);

    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void delete(int productId);

}
