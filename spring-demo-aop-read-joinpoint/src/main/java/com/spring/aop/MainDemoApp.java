package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
//		theMembershipDAO.addAcount();
//		theMembershipDAO.goToSleep();
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the business method
		theAccountDAO.addAcount();
		
		Account account = new Account();
		account.setName("Franklin");
		account.setLevel("Level 1");
		theAccountDAO.addAcount(account, true);
		theAccountDAO.doWork();
		
		//call the accountDao getter/setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//close the context
		context.close();
	}

}
