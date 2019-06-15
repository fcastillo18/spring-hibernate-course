package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
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
