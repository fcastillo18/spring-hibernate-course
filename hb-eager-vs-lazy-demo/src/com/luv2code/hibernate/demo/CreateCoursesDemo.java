package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			//create some courses
			Course tempCourse1 = new Course("Air Guitar - The ultimate guide");
			Course tempCourse2 = new Course("The Pinbal MasterClass");
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit the transaction
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
