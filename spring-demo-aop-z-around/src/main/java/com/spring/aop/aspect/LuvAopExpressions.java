package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	//this is where we add all of our relate advises for logs
	
		//lets start with @Before advice
		
		@Pointcut("execution(* com.spring.aop.dao.*.*(..) )")
		public void forDaoPackage() {}
		
		@Pointcut("execution(* com.spring.aop.dao.*.get*(..) )")
		public void getter() {}
		
		@Pointcut("execution(* com.spring.aop.dao.*.set*(..) )")
		public void setter() {}
		
		//Combine pointcut: include packages... exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {
		}
		
}
