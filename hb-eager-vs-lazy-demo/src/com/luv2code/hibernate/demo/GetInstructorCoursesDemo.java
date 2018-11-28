package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
	
			//start transacction
			session.beginTransaction();
			
			//get the instructor
			int theId = 4;
			Instructor tempInstructor = session.get(Instructor.class, theId)
;			
			System.out.println("Instructor: "+tempInstructor);
			
			System.out.println("Courses: "+tempInstructor.getCourses());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
