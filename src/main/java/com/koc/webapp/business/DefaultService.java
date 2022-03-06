package com.koc.webapp.business;

import java.sql.SQLException;
import java.util.List;

import com.koc.webapp.dao.TodoDao;
import com.koc.webapp.dao.TodoDaoMysql;
import com.koc.webapp.entities.Todo;

public class DefaultService implements Service {
	
	private static DefaultService instance;
	private static TodoDao dao;
	
	private DefaultService() {}
	
	public static DefaultService getInstance() {
		if (instance != null) return instance;
		instance = new DefaultService();
		dao = new TodoDaoMysql();
		return instance;
	}

	@Override
	public void insertTodo(Todo todo) throws SQLException, Exception {
		dao.insert(todo);
	}

	@Override
	public void updateTodo(Todo todo) throws SQLException, Exception {
		dao.update(todo);
	}

	@Override
	public Todo getTodo(int id) throws SQLException, Exception {
		return dao.get(id);
	}

	@Override
	public List<Todo> getTodos() throws SQLException, Exception {
		return dao.getAll();
	}

	@Override
	public void deleteTodo(int id) throws SQLException, Exception {
		dao.delete(id);
	}

}
