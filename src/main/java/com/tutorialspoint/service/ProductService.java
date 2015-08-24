package com.tutorialspoint.service;

import com.tutorialspoint.model.Product;

import java.util.List;

/**
 * Created by MarcinM on 2015-08-22.
 */
public interface ProductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public void add(Product product);
    public void update(Product product);
    public void delete(Product product);
}
