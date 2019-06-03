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

/**
 * the class DAOMap
 * @author Quentin
 *
 */
public class DAOMap{

	private static int x = 0;
	private static int y = 0;
	/** a connection*/
	private final Connection connection;
	/**
	 * Instantiates a DAOMap
	 * @param connection
	 * a connection
	 * @throws SQLException
	 * 	the SQL exception
	 */
	public DAOMap(Connection connection) throws SQLException {
		this.connection = connection;
		// TODO Auto-generated constructor stub
	}


	/**
	 * Retrieves a map from the DataBase
	 * @param id
	 * the level
	 * @return map
	 * our map
	 * @throws IOException
	 * Signal an IOexception
	 */
	public static  IMap find(int id) throws IOException {
		IMap map1 = null;
		try {
			final String sql = "call level" + id;
			final CallableStatement call =prepareCall(sql);
		
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			map1 = setmEntityOnMap(resultSet);
			return map1;
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * gets the connection
	 * @return connection
	 * our connection
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * sets motionLess and mobile entities on the map according to the DataBase
	 * @param result
	 * a resultSet attribute
	 * @return map
	 * our map
	 * @throws SQLException
	 * 		the SQL exception
	 * @throws IOException
	 * Signal an IOexception
	 */
	public static  IMap setmEntityOnMap(ResultSet result) throws SQLException, IOException {
		
		IMap map1 = new Map(new IEntity[Map.getWidth()][Map.getHeight()]);
		while (result.next()) {
		for (char c : result.getString("item").toCharArray()) {

			
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
					
				
			
		}
		}
		return map1;

	}
	
	public static CallableStatement prepareCall(final String query) throws SQLException {
	        return DBConnection.getInstance().getConnection().prepareCall(query);
	    }

	
	

}



