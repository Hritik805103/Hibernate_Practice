package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.ProjectEntity;
import com.app.util.HibernateUtil;

public class Annotation2Test {

	public static void main(String[] args) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		boolean flag = false;
		
		
		ProjectEntity ent = new ProjectEntity();
		ent.setId(2);
		ent.setName("ECommerce2");
		ent.setDescription("Happy Shopping");
		ent.setDeveloper("Hritik");
		
		try{
			ses.save(ent);
			flag=true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			flag = false;
			
		}
		finally {
			if (flag) {
				tx.commit();
			}
			else {
				tx.rollback();
			}
			
			ses.close();
		}
		
	}
	 
}
