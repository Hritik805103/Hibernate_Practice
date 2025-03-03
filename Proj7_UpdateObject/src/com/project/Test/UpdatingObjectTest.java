package com.project.Test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.Entity.Products;
import com.project.util.HibernateUtil;

public class UpdatingObjectTest {

	public static void main(String[] args) {
		
//		prepare entity class object and set the id value of existing object that you want to update
		Products p = new Products(); 
		
		p.setPid(5); /*Existing id from table */
		p.setPname("Soap"); /*New Values */
		p.setPrice(75.00f);
		p.setQty(5);
		
		Session ses =null;
		Transaction tx = null; 
		boolean flag = false;
		
		try {
			ses = HibernateUtil.getSession();
			tx = ses.beginTransaction();
			ses.update(p);
			flag = true;
			
			
		}
		catch (HibernateException e) {
			flag = false; 
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
			System.out.println("Record Updated");	
			}
			else {
				tx.rollback();
				System.out.println("Updation Failed");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
			
		}
		
	}
	
	
}
