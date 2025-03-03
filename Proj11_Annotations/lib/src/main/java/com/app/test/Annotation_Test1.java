package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.FacultyDetails;
import com.app.util.HibernateUtil;

public class Annotation_Test1 {

	public static void main(String[] args) {
		
	
	Session ses = HibernateUtil.getSession();
	Transaction tx = null;
	boolean flag = false;
	
	FacultyDetails fac = new FacultyDetails();
	fac.setId(1);
	fac.setName("ABCD");
	fac.setSalary(25000f);
	fac.setSubject("Maths");
	
	try {
		tx = ses.beginTransaction();
		ses.save(fac);
		flag = true;
	}
	catch (Exception e) {
		e.printStackTrace();
		flag= false;
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