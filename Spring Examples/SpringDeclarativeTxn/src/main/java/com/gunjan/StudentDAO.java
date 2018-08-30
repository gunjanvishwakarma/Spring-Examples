package com.gunjan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentDAO implements IStudentDAO{

	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void cleanStudent() {
		String sql1 = "delete from Student";
		jdbcTemplate.execute(sql1);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void insertStudents(final List<Student> students) {
		String sql = "insert into Student set ID = ? , NAME = ? , AGE = ?";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int index)
					throws SQLException {
				Student student = students.get(index);
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setInt(3, student.getAge());
			}

			public int getBatchSize() {
				return students.size();
			}
		});
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void insertStudent(int id, String name, int age) {
		String sql = "insert into Student set ID = ? , NAME = ? , AGE = ?";
		Object[] args = new Object[] { id, name, age };
		int[] argTypes = new int[] { Types.INTEGER, Types.VARCHAR,
				Types.INTEGER };
		jdbcTemplate.update(sql, args, argTypes);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void deleteStudent(int id) {
		String sql = "delete from Student where ID = ?";
		Object[] args = new Object[] { id };
		int[] argTypes = new int[] { Types.INTEGER };
		jdbcTemplate.update(sql, args, argTypes);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Student> getStudent() {
		String sql = "select * from Student";

		Object obj = jdbcTemplate.query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				return student;
			}

		});
		return (List<Student>) obj;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
