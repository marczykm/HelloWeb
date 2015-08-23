package com.tutorialspoint.dao;

import org.hibernate.SessionFactory;

import java.util.Collection;

/**
 * Created by MarcinM on 2015-08-22.
 */
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection loadProductsByCategory(String category) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Product product where product.category=?").setParameter(0, category).list();
    }

    public Collection findAllProducts() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Product").list();
    }
}
