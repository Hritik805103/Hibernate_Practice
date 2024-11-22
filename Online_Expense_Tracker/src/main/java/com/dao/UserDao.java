package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.User;
import org.hibernate.Query;


@SuppressWarnings("deprecation")
public class UserDao {

	private SessionFactory factory = null;;
	private Session session = null;
	private org.hibernate.Transaction tx = null;
	

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveuser(User user) {
		boolean f = false;
	
		try {
			
			session=factory.openSession();
			tx = session.beginTransaction();
			
			session.save(user);
			tx.commit();
			f = true;
			
			
		} catch (Exception e) {
			
			if(tx != null) {
				f = false;
				e.printStackTrace();
			}
		}
		
		
		
		return f;
	}
	
	
	
	
	
	public User login(String email, String password) {
		User u = null;
		
		session = factory.openSession();
		
		 Query<User> q = session.createQuery("from User where email = :em and password = :ps", User.class);		q.setParameter("em", email);
		q.setParameter("ps", password);

		u = (User)q.uniqueResult();
		
		
		
		return u;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
