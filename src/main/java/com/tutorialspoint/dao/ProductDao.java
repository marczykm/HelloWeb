package com.tutorialspoint.dao;

import com.tutorialspoint.model.Product;

import java.util.Collection;

/**
 * Created by MarcinM on 2015-08-22.
 */
public interface ProductDao {
    public Collection findAll();
    public void add(Product product);
    public void update(Product product);
    public void delete(Product product);
    public Product findById(Long id);

}
