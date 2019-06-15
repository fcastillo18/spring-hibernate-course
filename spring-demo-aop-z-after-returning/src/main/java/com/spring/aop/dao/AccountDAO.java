package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public List<Account> findAccounts(){
		
		List<Account> listAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platium");
		Account temp3 = new Account("Luca", "Gold");
		
		listAccounts.add(temp1);
		listAccounts.add(temp2);
		listAccounts.add(temp3);
		
		return listAccounts;
		
	}
	
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

	public String getName() {
		System.out.println(getClass()+ " in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ " in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ " in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ " in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
