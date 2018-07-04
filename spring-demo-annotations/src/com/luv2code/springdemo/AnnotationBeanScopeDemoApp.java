package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		// call a method on the bean
		System.out.println("\n Poiting the same object: " + result);
		
		System.out.println("\n Memory location for the coach: " + theCoach);
		
		System.out.println("\n Memory location for the coach: " + alphaCoach);
				
		// close the context
		context.close();

	}

}
