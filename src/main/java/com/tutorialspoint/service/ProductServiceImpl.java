package com.tutorialspoint.service;

import com.tutorialspoint.dao.ProductDao;
import com.tutorialspoint.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MarcinM on 2015-08-22.
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public void increasePriceOfAllProductsInCategory(String category) {
        List productsToChange = (List) this.productDao.loadProductsByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Product> findAllProducts() {
        return (List<Product>) this.productDao.findAllProducts();
    }

}
