package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAcount() {
		
		System.out.println(getClass()+" doing db work");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass()+" Im going to sleep now...");
	}

}
