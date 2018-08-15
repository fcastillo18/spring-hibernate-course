package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Daffy", "Duck", "daffy_duck@claro.com.do");
			
			session.beginTransaction();
			
			System.out.println(student);
			session.save(student);
			
			session.getTransaction().commit();
			
			//Reading object
			//find out the student's id
			System.out.println("Saved student. Generated id: "+ student.getId());	
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id
			System.out.println("\nGetting students with id: "+student.getId());
			
			Student studentFromDB = session.get(Student.class, student.getId());
			
			System.out.println("Get complete: "+ studentFromDB);
			
			//commit transaction			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
