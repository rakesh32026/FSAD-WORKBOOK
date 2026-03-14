package com.klu.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class ProductCRUD {

    public static void main(String[] args) {

        // INSERT
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        // RETRIEVE
        session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, 1);
        System.out.println("Retrieved: " + product.getName());
        session.close();

        // UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product updateProduct = session.get(Product.class, 1);
        updateProduct.setPrice(70000);
        updateProduct.setQuantity(8);

        tx.commit();
        session.close();

        // DELETE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product deleteProduct = session.get(Product.class, 2);
        session.delete(deleteProduct);

        tx.commit();
        session.close();

        HibernateUtil.getSessionFactory().close();
    }
}
