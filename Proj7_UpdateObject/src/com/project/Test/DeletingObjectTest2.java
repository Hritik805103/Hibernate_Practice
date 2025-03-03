package com.project.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.Entity.Products;
import com.project.util.HibernateUtil;

public class DeletingObjectTest2 {

	public static void main(String[] args) {
		
		Session ses = null;
		Transaction tx = null;
		boolean flag = false;
		
		ses = HibernateUtil.getSession();
		tx = ses.beginTransaction();
		
		try {
			Products p = ses.get(Products.class, 4);
			
			if(p!=null) {
				ses.delete(p);
				flag = true;
				System.out.println("Object deleted successfullly...");
			}
			else {
				System.out.println("Record Not Found");
				return; 
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
