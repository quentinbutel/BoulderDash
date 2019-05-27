package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Map;


public class DAOMap {
	private final Connection connection;
	public DAOMap(Connection connection) throws SQLException {
		this.connection = connection;
		// TODO Auto-generated constructor stub
	}

	
	public boolean create(Map map) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean delete(Map map) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean update(Map map) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Map find(int id) {
		Map map = new Map();

		try {
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(id, resultSet.getString("map"));
			}
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Connection getConnection() {
		return connection;
	}

	
	

}
