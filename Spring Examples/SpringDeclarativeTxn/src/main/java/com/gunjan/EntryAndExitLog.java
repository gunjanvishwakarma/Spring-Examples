package com.gunjan;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class EntryAndExitLog implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] objects = invocation.getArguments();
		StringBuilder builder = new StringBuilder();
		
		builder.append("Entry=>> "+ invocation.getMethod()+"(");
		for (int i = 0; i < objects.length; i++) {
			builder.append(objects[i]);
			if(i < objects.length -1){
				builder.append(",");
			}
		}
		builder.append(")");
		System.out.println(builder);
		
		long startTime = System.currentTimeMillis();
		Object returnValue = invocation.proceed();
		long endTime = System.currentTimeMillis();
		
		
		System.out.println("Exit=> "+invocation.getMethod()+" return: "+returnValue+ " | Total Time Spend:"+(endTime - startTime));
		
		
		return returnValue;
	}

}
