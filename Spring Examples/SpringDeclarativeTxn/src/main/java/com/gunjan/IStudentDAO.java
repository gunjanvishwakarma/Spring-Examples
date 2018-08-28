package com.gunjan;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {

	void cleanStudent();

	void insertStudents(List<Student> students);

	void insertStudent(int id, String name, int age) throws SQLException;

	void deleteStudent(int id);

	List<Student> getStudent();

}
