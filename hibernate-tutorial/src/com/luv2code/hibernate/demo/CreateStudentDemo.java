package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student student = new Student("Franklin", "Castillo", "franklin_castillo@claro.com.do");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
