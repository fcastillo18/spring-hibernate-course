package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			//get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstrutorDetail =
					session.get(InstructorDetail.class, theId);
			
			//print instructor
			System.out.println("tempInstrutorDetail: "+tempInstrutorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor: "+tempInstrutorDetail.getInstructor());
			
			session.getTransaction().commit();
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}

	}

}
