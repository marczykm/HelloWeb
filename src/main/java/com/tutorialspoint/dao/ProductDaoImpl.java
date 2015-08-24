package com.tutorialspoint.dao;

import com.tutorialspoint.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

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

    public Collection findAll() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Product").list();
    }

    public void add(Product product) {
        this.sessionFactory.getCurrentSession()
                .save(product);
    }

    public void update(Product product) {
        this.sessionFactory.getCurrentSession().update(product);
    }

    public void delete(Product product) {
        this.sessionFactory.getCurrentSession().delete(product);
    }

    public Product findById(Long id) {
        List<Product> result = sessionFactory.getCurrentSession()
                .createQuery("from Product where id=?").setParameter(0,id).list();
        if (!result.isEmpty())
            return result.get(0);
        return null;
    }
}
