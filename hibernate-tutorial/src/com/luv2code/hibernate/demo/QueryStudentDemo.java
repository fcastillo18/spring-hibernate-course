package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//query students
			List<Student> listStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(listStudents);
			
			System.out.println("\nStudents who lastName = ?");
			//query students: lastName Castillo
			listStudents = session.createQuery("from Student s where s.lastName='Perez'").getResultList();
			displayStudents(listStudents);
			
			System.out.println("\nStudents who lastName = ? or firstName = ?");
			listStudents = session.createQuery("from Student s where s.lastName='Perez' or firstName = 'Andy'").getResultList();
			displayStudents(listStudents);
			
			System.out.println("\nStudents using like");
			listStudents = session.createQuery("from Student s "
												+ "where s.email like '%com.do'").getResultList();
			displayStudents(listStudents);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> listStudents) {
		for (Student student : listStudents) {
			System.out.println("The student: "+student);
		}
	}

}
