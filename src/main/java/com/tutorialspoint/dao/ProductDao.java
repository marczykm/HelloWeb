package com.tutorialspoint.dao;

import com.tutorialspoint.model.Product;

import java.util.Collection;

/**
 * Created by MarcinM on 2015-08-22.
 */
public interface ProductDao {
    public Collection findAllProducts();
    public void addProduct(Product product);

}
