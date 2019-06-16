package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//settup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//settup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("====>> in @Before: calling method: "+ theMethod);
		//System.out.println("====>> in @Before: calling method: "+ theMethod);
		
		//display the arguments
		Object[] args = joinPoint.getArgs();
		
		for (Object object : args) {
			logger.info("====>> argument: "+ object.toString());
		}
			
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
	
		//display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("====>> in @AfterReturning: from method: "+ theMethod);
		
		//data is returned
		logger.info("====>> result: "+ theResult);
	}
	
	
	
	//add @AfterReturning advice
}
