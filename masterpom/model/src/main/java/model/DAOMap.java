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


public class DAOMap{

	private static int x = 0;
	private static int y = 0;
	private final Connection connection;
	public DAOMap(Connection connection) throws SQLException {
		this.connection = connection;
		// TODO Auto-generated constructor stub
	}


	
	public static  IMap find(int id) throws IOException {
		IMap map1 = null;
		try {
			final String sql = "call level" + id;
			final CallableStatement call =prepareCall(sql);
		
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			/*while (resultSet.next()) {
				//System.out.print(resultSet.getString("item"));
				 map1 = setmEntityOnMap(resultSet, id);
				
				//DAOMap.setmEntityOnMap(resultSet, id);
			}*/
			map1 = setmEntityOnMap(resultSet, id);
			return map1;
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Connection getConnection() {
		return connection;
	}
	
	public static  IMap setmEntityOnMap(ResultSet result, int level) throws SQLException, IOException {
		
		IMap map1 = new Map(new IEntity[Map.getWidth()][Map.getHeight()], level);
		while (result.next()) {
		for (char c : result.getString("item").toCharArray()) {

			//for (int y = 0; y < Map.getHeight(); y++) {
				//for (int x = 0; x < Map.getWidth(); x++) {
			if (x == Map.getWidth()) {
				x = 0;
				y++;
			}
				
			
					map1.setOnTheMapXY(MotionLessEntityFactory.getFromDBSymbol(c), x, y);
					
					if (c =='B') {
						map1.add(new Boulder(x, y, map1));
					}
					else if(c =='D') {
						map1.add(new Diamond(x, y, map1));
						map1.addDiamond();
					}
					x++;
					
				//}
			//}
			
		}
		}
		return map1;

	}
	public static CallableStatement prepareCall(final String query) throws SQLException {
	        return DBConnection.getInstance().getConnection().prepareCall(query);
	    }

	
	

}



