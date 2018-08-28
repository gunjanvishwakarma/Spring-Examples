package com.gunjan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class MarksDAO implements IMarksDAO{

	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void cleanMarks() {
		String sql2 = "delete from Marks";
		jdbcTemplate.execute(sql2);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertMarks(int id, int marks, int year) {
		String sql = "insert into Marks set SID = ? , MARKS = ? , YEAR = ?";
		Object[] args = new Object[] { id, marks, year };
		int[] argTypes = new int[] { Types.INTEGER, Types.INTEGER,
				Types.INTEGER };
		jdbcTemplate.update(sql, args, argTypes);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Marks> getMarks() throws SQLException {
		String sql = "select * from Marks";
		Object obj = jdbcTemplate.query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Marks marks = new Marks();
				marks.setSid(rs.getInt(1));
				marks.setMarks(rs.getInt(2));
				marks.setYear(rs.getInt(3));
				return marks;
			}

		});
		return (List<Marks>) obj;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
