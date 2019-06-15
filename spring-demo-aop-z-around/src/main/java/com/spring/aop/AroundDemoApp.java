package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\nMain program from AroundDemoAp");
		System.out.println("Calling getFortune()");
		
		System.out.println(theFortuneService.getFortune());
		
		System.out.println("\nFinished");
		
		//close the context
		context.close();
	}

}
