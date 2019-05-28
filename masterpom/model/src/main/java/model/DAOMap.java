package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.IEntity;
import entity.IMap;
import entity.Map;
import entity.mobile.Boulder;
import entity.mobile.Diamond;
import entity.motionless.MotionLessEntityFactory;


public class DAOMap {

	private final  int width = 32;
	private final  int height = 16;
	private final Connection connection;
	public DAOMap(Connection connection) throws SQLException {
		this.connection = connection;
		// TODO Auto-generated constructor stub
	}

	
	public boolean create(IMap map) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean delete(IMap map) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean update(IMap map) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public IMap find(int id) throws IOException {
		IMap map1;
		try {
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map1 = new Map(new IEntity[width][height]);
				this.setmEntityOnMap(resultSet, map1);
			}
			resultSet.close();
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Connection getConnection() {
		return connection;
	}
	
	public void setmEntityOnMap(ResultSet result, IMap map1) throws SQLException, IOException {
		int currentX = 0;
		int currentY = 0;
		
		for (char c : result.getString("map").toCharArray()) {
			map1.setOnTheMapXY(MotionLessEntityFactory.getFromDBSymbol(c), currentX, currentY);
			
			if (c =='P') {
				map1.add(new Boulder(currentX, currentY, map1));
			}
			else if(c =='A') {
				map1.add(new Diamond(currentX, currentY, map1));
				map1.addDiamond();
			}
			currentX++;
		}
		
		if (currentX % width == 0 && currentX != 0) {
			currentX = 0;
			currentY++;
		}
		
		

	}

	
	

}
