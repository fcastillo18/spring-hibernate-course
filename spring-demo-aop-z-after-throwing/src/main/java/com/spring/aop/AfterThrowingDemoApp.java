package com.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> listAccounts = null;
		
		try {
			boolean tripWire = true;
			listAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception ex) {
			System.out.println("\n Exception: " +ex);
		}
		System.out.println("\nMain program from AfterThrowingDemoAp");
		System.out.println("------");
		
		System.out.println(listAccounts);
		
		System.out.println("\n");
		
		//close the context
		context.close();
	}

}
