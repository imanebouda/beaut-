package com.management.services;

import com.management.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    void deleteProductById(Long id);
    void deleteAllProduct();



}
