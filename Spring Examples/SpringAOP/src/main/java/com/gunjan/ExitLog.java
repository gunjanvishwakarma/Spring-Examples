package com.gunjan;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ExitLog implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] arguments,
			Object target) throws Throwable {
		System.out.println("Exit=> "+ target.getClass()+"."+method.getName()+" return: "+returnValue);
	}

}
