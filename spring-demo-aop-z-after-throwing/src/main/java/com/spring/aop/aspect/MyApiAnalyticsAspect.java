package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.spring.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void perfomApiAnalytics() {
		System.out.println("\n =====> Performin API analytics");
	}
}
