package com.koc.webapp.business;

import java.sql.SQLException;
import java.util.List;

import com.koc.webapp.entities.Todo;

public interface Service {
	public void insertTodo(Todo todo) throws SQLException, Exception;
	public void updateTodo(Todo todo) throws SQLException, Exception;
	public void deleteTodo(int id) throws SQLException, Exception;
	public Todo getTodo(int id) throws SQLException, Exception;
	public List<Todo> getTodos() throws SQLException, Exception;
}
