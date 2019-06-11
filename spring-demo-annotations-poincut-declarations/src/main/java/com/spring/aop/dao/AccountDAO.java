package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.Account;

@Component
public class AccountDAO {

	public boolean addAcount() {
		
		System.out.println(getClass()+" doing db work");
		
		return false;
	}
	
	public void addAcount(Account account, boolean vipFlag) {
		
		System.out.println(getClass()+" adding account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ " doing some work");
		
		return false;
	}
}
