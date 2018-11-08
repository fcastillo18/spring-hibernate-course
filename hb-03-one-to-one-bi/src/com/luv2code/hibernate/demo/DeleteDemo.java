package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transacction
			session.beginTransaction();
			
			//get Instructor by primary key
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("Found: "+ tempInstructor);
			
			if (tempInstructor != null) {
				System.out.println("Deleting: "+ tempInstructor);
				session.delete(tempInstructor);
			}
			//delete Instructor
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
