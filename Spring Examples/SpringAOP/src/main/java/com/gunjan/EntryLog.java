package com.gunjan;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class EntryLog implements MethodBeforeAdvice{

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		StringBuilder builder = new StringBuilder();
		String methodName = arg0.getName();
		
		builder.append("Entry=>> "+arg2.getClass()+"." + methodName+"(");
		for (int i = 0; i < arg1.length; i++) {
			builder.append(arg1[i]);
			if(i < arg1.length -1){
				builder.append(",");
			}
		}
		builder.append(")");
		System.out.println(builder);
	}

}
