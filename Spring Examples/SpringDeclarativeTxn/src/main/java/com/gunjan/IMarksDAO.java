package com.gunjan;

import java.sql.SQLException;
import java.util.List;

public interface IMarksDAO {

	void cleanMarks();

	void insertMarks(int id, int marks, int year);

	List<Marks> getMarks() throws SQLException;

}
