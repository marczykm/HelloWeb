package com.tutorialspoint.service;

import com.tutorialspoint.model.Product;

import java.util.List;

/**
 * Created by MarcinM on 2015-08-22.
 */
public interface ProductService {
    public void increasePriceOfAllProductsInCategory(final String category);
    public List<Product> findAllProducts();
}
