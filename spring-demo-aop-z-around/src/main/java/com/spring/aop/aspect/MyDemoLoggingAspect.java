package com.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.spring.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(
					ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n =====> Executing @Aroung advice with Exception handler on method: "+method);
		
		Object result = null;
				
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			System.out.println("@Around advice: We have a problem "+e);
			
			//handle and give default fortune... use this approach with caution
			result = "Nothing exciting here. Move along";
			
			// OR throw the exception
			throw e;
		}
				
		return result;
	}
	
//	@Around("execution(* com.spring.aop.service.*.getFortune(..))")
//	public Object aroundGetFortune(
//					ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
//		String method = theProceedingJoinPoint.getSignature().toShortString();
//		System.out.println("\n =====> Executing @Aroung advice on method: "+method);
//		
//		long begin = System.currentTimeMillis();
//		
//		Object result = theProceedingJoinPoint.proceed();
//				
//		long end = System.currentTimeMillis();
//		
//		long duration = end - begin;
//		
//		System.out.println("\n =====> Duration:  "+duration / 1000.0 + " seconds");
//		
//		return "My fortune is: "+result;
//	}
	
	@After("execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =====> Executing @After advice on method: "+method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =====> Executing @AfterThrowing advice on method: "+method);
		
		System.out.println("\n =====> the exception is: "+theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturnFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =====> Executing @AfterReturning advice on method: "+method);
		
		System.out.println("\n =====> result is: "+result);
		
		//modify "result" list: add, modify, delete
		//convert the names to uppercase
		convertAccountNameToUpperCase(result);
		
		System.out.println("\n =====> result is: "+result);
		
	}
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		
		for (Account account : result) {
			//get the uppercase version
			String theUpperCase = account.getName().toUpperCase();
			//update the new name on object
			account.setName(theUpperCase);
		}
	}


	@Before("com.spring.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice(JoinPoint joinPoint) {
		System.out.println("\n =====> Executing @Before advice on method addAcount");
		
		//display method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		//display method argument
		
		//get args
		Object[] args = joinPoint.getArgs();
		
		//loop thru args
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				
				System.out.println("Account name: "+account.getName());
				System.out.println("Account level: "+account.getLevel());
			}
		}
	}
	
}
