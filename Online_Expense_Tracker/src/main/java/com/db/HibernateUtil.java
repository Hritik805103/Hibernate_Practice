package com.db;


import java.util.Properties;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.entity.Expense;
import com.entity.User;

import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static SessionFactory sessionF;

    public static SessionFactory getSessionFactory() {
        if (sessionF == null) {
            try {
                Configuration config = new Configuration();
                Properties prop = new Properties();

                // Database connection settings
                prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                prop.put(Environment.URL, "jdbc:mysql://localhost:3307/expense_tracker_db");
                prop.put(Environment.USER, "root");
                prop.put(Environment.PASS, "hritik0000");
                prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                
                // Hibernate settings for SQL logging
                prop.put(Environment.HBM2DDL_AUTO, "update");
                prop.put(Environment.SHOW_SQL, true);
                prop.put(Environment.FORMAT_SQL, true);

                
                config.setProperties(prop);
                // Register the annotated class *before* building SessionFactory
                config.addAnnotatedClass(User.class);
                config.addAnnotatedClass(Expense.class);



                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties()).build();

                sessionF = config.buildSessionFactory(serviceRegistry);
                
                System.out.println("SessionFactory initialized");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionF;
    }

   
}
