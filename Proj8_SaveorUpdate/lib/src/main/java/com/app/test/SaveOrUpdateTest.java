package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.StudentEntity;
import com.app.util.HibernateUtil;

public class SaveOrUpdateTest {

	

	public static void main(String[] args) {
		
		StudentEntity s1 = new StudentEntity();
		s1.setId(6);
		s1.setName("kumar");
		s1.setEmail("kumarritik868@gmail.com");
		s1.setPassword("AAsdf.1234");
		
		Session ses = null;
		Transaction tx = null;
		boolean flag = false;
		
		ses =HibernateUtil.getSession();
		
		try {
			tx = ses.beginTransaction();
			ses.saveOrUpdate(s1);
			flag = true;
			System.out.println("Successful...");
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
			flag = false;	
		}
		finally {
		if(flag)
			tx.commit();
		else
			tx.rollback();
		
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		}
	}
}
