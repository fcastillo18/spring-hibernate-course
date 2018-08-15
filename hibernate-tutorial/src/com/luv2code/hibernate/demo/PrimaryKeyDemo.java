package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating Student");
			Student student = new Student("Andy", "Castillo", "andy.castillo@claro.com.do");
			Student student2 = new Student("Jose", "Ramon", "jose.ramon@claro.com.do");
			Student student3 = new Student("Pedro", "Perez", "pedro.perez@claro.com.do");
			
			session.beginTransaction();
			
			session.save(student);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
