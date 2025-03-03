package com.app.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory =null;
	
	static {
//		Configuration Object
		Configuration cfg = null;
		
		try {
			cfg = new Configuration();
//			cfg.configure();
			cfg.configure("com/app/cfgs/hibernate.cfg.xml");
			
//			SessionFactory object
			factory = cfg.buildSessionFactory();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		if(factory!=null)
			return factory.openSession();	
		else
			return null;	
	}
	
//	Close Session
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
//	Close SessionFactory
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	
}
