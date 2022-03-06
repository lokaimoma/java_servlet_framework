package com.koc.webapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.koc.webapp.entities.Todo;
import com.koc.webapp.utils.ConnectionManager;

public class TodoDaoMysql implements TodoDao {


	@Override
	public void insert(Todo todo) throws SQLException, Exception {
		String query = "insert into todos(title, description, dateTime) values (?,?,?)";
		PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);
		statement.setString(1, todo.getTitle());
		statement.setString(2, todo.getDescription());
		statement.setString(3, todo.getDateTime());
		statement.execute();
		statement.close();
	}

	@Override
	public void update(Todo todo) throws SQLException, Exception {
		String query = "update todos set title = ?, description = ?, dateTime = ? where id = ?";
		PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);
		statement.setString(1, todo.getTitle());
		statement.setString(2, todo.getDescription());
		statement.setString(3, todo.getDateTime());
		statement.setInt(4, todo.getId());
		statement.execute();
		statement.close();
	}

	@Override
	public Todo get(int id) throws SQLException, Exception {
		String query = "select * from todos where id = ?";
		PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return new Todo(
					result.getInt("id"),
					result.getString("title"),
					result.getString("description"),
					result.getString("dateTime")
			);
		}
		return null;
	}

	@Override
	public List<Todo> getAll() throws SQLException, Exception {
		String query = "select * from todos order by dateTime asc";
		Statement statement = ConnectionManager.getInstance().getConnection().createStatement();
		ResultSet result = statement.executeQuery(query);
		List<Todo> todos = new ArrayList<>();
		while(result.next()) {
			todos.add(new Todo(
					result.getInt("id"),
					result.getString("title"),
					result.getString("description"),
					result.getString("dateTime")
			));
		}
		statement.close();
		return todos;
	}

	@Override
	public void delete(int id) throws Exception {
		String query = "delete from todos where id =?";
		PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);
		statement.setInt(1, id);
		statement.execute();
		statement.close();
	}
}
