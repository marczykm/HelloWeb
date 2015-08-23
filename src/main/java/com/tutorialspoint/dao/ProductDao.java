package com.tutorialspoint.dao;

import java.util.Collection;

/**
 * Created by MarcinM on 2015-08-22.
 */
public interface ProductDao {

    public Collection loadProductsByCategory(String category);
    public Collection findAllProducts();
}
