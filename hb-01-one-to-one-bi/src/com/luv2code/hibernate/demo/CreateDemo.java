package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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

			//create object /*
//			Instructor tempInstructor = new Instructor("Franklin", "Castillo", "franklincastillo18@gmail.com");
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail("https://mypage.com/videos", "Luv to code!!!");
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhi.patel@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://mypage.com/videos", "Guitar!");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start transacction
			session.beginTransaction();
			
			//save the instructor
			/*
			 * Note: this will ALSO save the details object because of CascadeType.ALL
			 * 
			 * */
			
			System.out.println("Saving instructor: "+ tempInstructor.toString());
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
