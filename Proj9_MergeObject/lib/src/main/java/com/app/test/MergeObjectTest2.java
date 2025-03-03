package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.PassengerTicketEntity;
import com.app.util.HibernateUtil;

//Using session.merge() approach-2
public class MergeObjectTest2 {

	
	public static void main(String[] args) {
		PassengerTicketEntity pat = new PassengerTicketEntity();
		pat.setId(100);
		pat.setName("Hritik");
		pat.setPnr("2123220AKS");
		pat.setTicketPrice(1200);
		pat.setTrainNo(12398);
		
		Session sess =  HibernateUtil.getSession();
		Transaction tx = null;
		boolean flag = false;
		
		try {
			tx = sess.beginTransaction();
			sess.merge(pat);
			flag= true;
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
			
			HibernateUtil.closeSession(sess);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}
}
