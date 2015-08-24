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
    public List<Product> findAll() {
        return (List<Product>) this.productDao.findAll();
    }

    @Transactional
    public void add(Product product) {
        this.productDao.add(product);
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Transactional
    public void update(Product product) {
        productDao.update(product);
    }

    @Transactional
    public void delete(Product product) {
        productDao.delete(product);
    }
}
