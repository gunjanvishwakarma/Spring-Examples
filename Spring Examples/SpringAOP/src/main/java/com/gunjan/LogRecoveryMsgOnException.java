package com.gunjan;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LogRecoveryMsgOnException implements ThrowsAdvice {
	public void afterThrowing(Throwable throwable) {
		System.out.println(throwable.getMessage());
	}

	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable throwable) {
		System.out.println("Message="+throwable.getMessage());
		
		System.out.println("Exit=> "+ target.getClass()+"."+method.getName()+" Exception Message: "+throwable.getMessage() + " Recovery Option: Please do not pass zero for second argument for div method");
	}

}
