package com.project.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.Entity.Products;
import com.project.util.HibernateUtil;

public class UpdatingObjectTest2 {

	public static void main(String[] args) {
		
		Session ses = null;
		Transaction tx = null;
		boolean flag = false;
		
		ses = HibernateUtil.getSession();
		tx = ses.beginTransaction();
		
		try {
			Products p = ses.get(Products.class, 5);
			
			if(p!=null) {
				p.setPname("Cream");
				p.setPrice(70.0f);
				ses.save(p);
				flag = true;
			}
		}
		
		catch(Exception e) {
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
