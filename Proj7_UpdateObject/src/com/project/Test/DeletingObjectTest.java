package com.project.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.Entity.Products;
import com.project.util.HibernateUtil;

public class DeletingObjectTest {

	public static void main(String[] args) {
		
		Session ses = null;
		Transaction tx = null;
		boolean flag = false;
		
		ses = HibernateUtil.getSession();
		tx = ses.beginTransaction();
		
		try {
			Products p = new Products();
			p.setPid(6);
			ses.delete(p);
			flag = true;
			System.out.println("Object deleted...");
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
