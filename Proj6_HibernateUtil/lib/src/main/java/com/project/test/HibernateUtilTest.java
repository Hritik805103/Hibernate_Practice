package com.project.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.StudentEntity;
import com.project.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {
		
//		Entity
		StudentEntity s1 = new StudentEntity();
		s1.setId(23);
		s1.setName("PQR");
		s1.setCourse("BCom");
		s1.setEmail("pqr@abc.com");
		
//		Saving into DB
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
				
		try {
			session.save(s1);
			tx.commit();
			System.out.println("Record is saved into DB");
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Record is not saved into DB");
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}
	
}
