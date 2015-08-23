package com.tutorialspoint.service;

import com.tutorialspoint.dao.ProductDao;
import com.tutorialspoint.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MarcinM on 2015-08-22.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    @Qualifier(value = "myProductDao")
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional(readOnly = true)
    public List<Product> findAllProducts() {
        return (List<Product>) this.productDao.findAllProducts();
    }

    @Transactional
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }
}
