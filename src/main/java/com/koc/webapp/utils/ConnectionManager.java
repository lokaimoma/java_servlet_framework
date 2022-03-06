package com.koc.webapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	private final String URL="jdbc:mysql://localhost:3306/bd_todo";
	private final String USER="wordpress";
	private final String PWP="";

	private Connection connection;
	private static ConnectionManager instance=null;
	private ConnectionManager() {
		
	}
	public static ConnectionManager getInstance() {
		if(instance==null)
			instance=new ConnectionManager();
		return instance;
	}
	public Connection getConnection() throws Exception {
		if(connection==null || connection.isClosed())
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(URL,USER,PWP);
		return connection;
	}
}
