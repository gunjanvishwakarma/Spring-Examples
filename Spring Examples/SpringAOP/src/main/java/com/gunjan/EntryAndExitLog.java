package com.gunjan;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class EntryAndExitLog implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] objects = invocation.getArguments();
		StringBuilder builder = new StringBuilder();
		
		builder.append("Entry=>> "+invocation.getThis().getClass()+"." + invocation.getMethod().getName()+"(");
		for (int i = 0; i < objects.length; i++) {
			builder.append(objects[i]);
			if(i < objects.length -1){
				builder.append(",");
			}
		}
		builder.append(")");
		System.out.println(builder);
		
		
		Object returnValue = invocation.proceed();
		
		
		System.out.println("Exit=> "+ invocation.getThis().getClass()+"."+invocation.getMethod().getName()+" return: "+returnValue);
		
		
		return returnValue;
	}

}
