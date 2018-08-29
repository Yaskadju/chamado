package me.yaskadju.java.backend.com.novo.infra;

import java.sql.*;

public interface ConexaoJDBC {
	
	public Connection getConnection();
	public void close();
	public void commit() throws SQLException;
	public void rollback();
		
}
