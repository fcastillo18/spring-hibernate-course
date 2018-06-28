package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load the Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//call methos on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//calling new fortune method.
		System.out.println(theCoach.getDaiyFortune());
		
		//close the context
		context.close();
	}

}
