package com.project.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.entity.IStudentEntity;
import com.project.entity.StudentEntity;


public class LoadingObjectTest {

	public static void main(String[] args) {
		
//		1. Bootstrap Hibernate
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session ses = factory.openSession();
		Transaction tx = null;
		
		
		
//		Won't hit DB if no non-identifier object is called like getName(), getCourse();
		IStudentEntity s1 = ses.load(StudentEntity.class, 10); /* lazy loading by default
		 to make it Eager loading :-  <class name="com.project.entity.StudentEntity" lazy="false" table="student" dynamic-insert="true"> in Student.hbm.xml
		 */
		System.out.println(s1.getClass().getSuperclass());
		System.out.println(s1.getClass());
		System.out.println(s1);
//		System.out.println(s1.getName());
		
		}
	
}
