package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Product;
import util.HibernateUtil;

public class InsertProduct {

    public static void main(String[] args) {

        // Open Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Insert product records
        session.save(new Product("Laptop", "Electronics", 60000, 5));
        session.save(new Product("Mouse", "Electronics", 500, 20));
        session.save(new Product("Keyboard", "Electronics", 1200, 15));
        session.save(new Product("Chair", "Furniture", 3500, 8));
        session.save(new Product("Table", "Furniture", 7000, 3));
        session.save(new Product("Bottle", "Kitchen", 300, 25));

        // Commit transaction
        tx.commit();

        // Close session
        session.close();

        System.out.println("Products inserted successfully!");
    }
}
