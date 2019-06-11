package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our relate advises for logs
	
	//lets start with @Before advice
	
	//@Before("execution(public void addAcount())")
	//@Before("execution(public void com.spring.aop.dao.AccountDAO.addAcount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())") //*modifier at the beginning is optional
	//@Before("execution(* add*(com.spring.aop.Account))")
	//@Before("execution(* add*(com.spring.aop.Account, boolean))")
	//@Before("execution(* add*(com.spring.aop.Account, ..))")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.spring.aop.dao.*.*(..) )")
	public void beforeAddAcountAdvice() {
		System.out.println("\n =====> Executing @Before advice on method addAcount");
	}
}
