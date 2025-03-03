package com.project.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.entity.StudentEntity;


public class LoadingObjectTeat {

	public static void main(String[] args) {
		
//		1. Bootstrap Hibernate
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session ses = factory.openSession();
		Transaction tx = null;
		
		
//		-------------Putting data----------------
//		StudentEntity st = new StudentEntity();
//		st.setId(12 );
//		st.setName("Kumar");
//		st.setCourse("BBA");
//		st.setEmail("hritik@gmail.com");
//				
//		ses.save(st);
//		tx = ses.beginTransaction();
//		
//		try {
//			tx.commit();
//			System.out.println("Object is Saved...");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			ses.close();
//			factory.close();
//		}
		
		
//		------------------Extracting Data-------------------
		StudentEntity st = ses.get(StudentEntity.class,10);
		System.out.println(st);
		
		System.out.println(st.getName());
		
		
		}
	
}
