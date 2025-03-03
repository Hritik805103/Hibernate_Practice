package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.BankAccount;
import com.app.util.HibernateUtil;

public class Hbm2Ddl_Auto_Test1 {

	public static void main(String[] args) {
		Session ses =  HibernateUtil.getSession();
		Transaction tx = null;
		BankAccount b1 = new BankAccount();
		BankAccount b2= new BankAccount();
		
		b1.setId(5);
		b1.setAcHolderName("Hritik");
		b1.setAcNumber(123456789L);
		b1.setBalance(1000.f);
		
		b2.setId(3);
		b2.setAcHolderName("Deepak");
		b2.setAcNumber(123456789L);
		b2.setBalance(1000.f);
		
		boolean flag = false;
		
		try {
			tx = ses.beginTransaction();
			ses.save(b1);
			ses.save(b2);
			flag =true;
		}
		catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			
			ses.close();
		}
	}
	
}
