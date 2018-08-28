package com.gunjan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		IMath math = context.getBean("proxyMathImpl", MathImpl.class);
		math.add(1, 2);
		math.sub(3, 4);
		math.mul(5, 6);
		math.div(18, 0);
	}

}
