package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//Option 2: Hibernate query with HQL
			
			//get the instructor
			int theId = 4;
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", 
							Instructor.class);
			
			//set paramether
			query.setParameter("theInstructorId", theId);
			
			//execute query and get result
			Instructor tempInstructor = query.getSingleResult();
;			
			System.out.println("luv2code: Instructor: "+tempInstructor);
			
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\n The session is now closed \n");
			
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
