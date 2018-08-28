package com.gunjan;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee.getBeanName());
		employee.getApplicationContext().publishEvent(new HolidayEvent(new HelloWorld()));
	}

}