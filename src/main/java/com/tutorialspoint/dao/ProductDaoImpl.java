package com.tutorialspoint.dao;

import com.tutorialspoint.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by MarcinM on 2015-08-22.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier(value = "mySessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection findAllProducts() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Product").list();
    }

    public void addProduct(Product product) {
        this.sessionFactory.getCurrentSession()
                .save(product);
    }
}
