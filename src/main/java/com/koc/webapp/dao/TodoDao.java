package com.koc.webapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.koc.webapp.entities.Todo;

public interface TodoDao {
	public void insert(Todo todo) throws SQLException, Exception;
	public void update(Todo todo) throws SQLException, Exception;
	public void delete(int id) throws Exception;
	public Todo get(int id)throws SQLException, Exception;
	public List<Todo> getAll()throws SQLException, Exception;
}
