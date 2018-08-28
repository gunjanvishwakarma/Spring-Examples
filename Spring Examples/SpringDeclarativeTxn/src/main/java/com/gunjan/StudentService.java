package com.gunjan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentService implements IStudentService{
	static ApplicationContext context;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		IStudentService studentService =  (IStudentService) context
				.getBean("studentService");
		studentService.execute();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void execute() throws ClassNotFoundException {
		try {
			IStudentDAO studentDao = (IStudentDAO) context.getBean("studentDao");
			IMarksDAO marksDao = (IMarksDAO) context.getBean("marksDao");
			studentDao.cleanStudent();
			marksDao.cleanMarks();
			studentDao.insertStudent(5, "shayam", 31);
			List<Student> students = new ArrayList<Student>();
			students.add(new Student(1, "name1", 31));
			students.add(new Student(2, "name2", 32));
			students.add(new Student(3, "name3", 33));
			students.add(new Student(4, "name4", 34));
			studentDao.insertStudents(students);
			
			marksDao.insertMarks(1, 98, 2014);
			marksDao.insertMarks(2, 80, 2014);
			studentDao.getStudent();
			marksDao.getMarks();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}