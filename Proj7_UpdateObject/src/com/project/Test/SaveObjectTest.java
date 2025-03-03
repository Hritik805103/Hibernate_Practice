package com.project.Test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.Entity.Products;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("com/project/cfgs/hibernate.cfg.xml");
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		Products prod = null;
		
//		Configuration
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		
//		Entity
		prod = new Products();
		prod.setPid(6);
//		prod.setPname("Soap");
//		prod.setPrice(30.00f);
//		prod.setQty(1);
		
		try {
			tx = session.beginTransaction();
			
//			saving the object in Level-1 Cache
			session.save(prod); 
			
			tx.commit();
			System.out.println("Object is Saved");
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
	
}
