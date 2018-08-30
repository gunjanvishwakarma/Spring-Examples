package com.gunjan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentService implements IStudentService{
	private JdbcTemplate jdbcTemplate;
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createTable() {

		String sql3 = "CREATE TABLE IF NOT EXISTS Student ( \n" +
				"   id INT NOT NULL, \n" +
				"   name VARCHAR(50), \n" +
				"   age VARCHAR(20), \n" +
				"	PRIMARY KEY (id));";
		String sql4 = "CREATE TABLE IF NOT EXISTS Marks ( \n" +
				"   sid INT NOT NULL, \n" +
				"   marks INT, \n" +
				"   year INT, \n" +
				"	PRIMARY KEY (sid));";
		String sql1 = "delete from Student";
		String sql2 = "delete from Marks";
		jdbcTemplate.execute(sql3);
		jdbcTemplate.execute(sql4);
		jdbcTemplate.execute(sql1);
		jdbcTemplate.execute(sql2);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void execute() throws ClassNotFoundException {
		//createTable();
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
			IStudentDAO studentDao = (IStudentDAO) context.getBean("studentDao");
			IMarksDAO marksDao = (IMarksDAO) context.getBean("marksDao");
			//studentDao.cleanStudent();
			//marksDao.cleanMarks();
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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}