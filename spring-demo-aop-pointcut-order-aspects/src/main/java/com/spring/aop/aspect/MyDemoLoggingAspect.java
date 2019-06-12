package com.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.spring.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n =====> Executing @Before advice on method addAcount");
	}
	
}
