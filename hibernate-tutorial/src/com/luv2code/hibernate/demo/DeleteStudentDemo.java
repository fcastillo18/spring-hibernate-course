package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id
			System.out.println("\nGetting students with id: "+studentId);
			
			Student studentFromDB = session.get(Student.class, studentId);
			
			System.out.println("Deleting student... ");
			session.delete(studentFromDB);
			
			//commit transaction			
			session.getTransaction().commit();
			
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//UPDATE EMAIL ALL STUDENTS
			session.createQuery("delete from Student where id = 8").executeUpdate();
			
			//commit transaction			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
