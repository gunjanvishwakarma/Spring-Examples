package com.gunjan;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@org.springframework.boot.autoconfigure.SpringBootApplication

public class SpringBootApplication {


    public static void main(String[] args) throws ClassNotFoundException {

        SpringApplication.run(SpringBootApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        studentService.execute();
    }


}