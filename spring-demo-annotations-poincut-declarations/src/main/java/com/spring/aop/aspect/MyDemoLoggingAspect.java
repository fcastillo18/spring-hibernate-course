package com.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our relate advises for logs
	
	//lets start with @Before advice
	
	@Pointcut("execution(* com.spring.aop.dao.*.*(..) )")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n =====> Executing @Before advice on method addAcount");
	}
	
	@Before("forDaoPackage()")
	public void perfomApiAnalytics() {
		System.out.println("\n =====> Performin API analytics");
	}
	
	@Pointcut("execution(* com.spring.aop.dao.*.get*(..) )")
	private void getter() {}
	
	@Pointcut("execution(* com.spring.aop.dao.*.set*(..) )")
	private void setter() {}
	
	//Combine pointcut: include packages... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice2() {
		System.out.println("\n =====> Executing @Before forDaoPackageNoGetterSetter on method addAcount");
	}
}
