package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE;

	/** The connection. */
	private Connection					connection;
	private Statement statement;
	/** The login. */
    private static String                  user     = "root";

    /** The password. */
    private static String                  password = "";

    /** The url. */
    private static String                  url      ="jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false";

	public static void setINSTANCE(DBConnection iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (INSTANCE == null) {
			setINSTANCE(new DBConnection());
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(DBConnection.url, DBConnection.user, DBConnection.password);
			this.statement = this.connection.createStatement();
			return true;
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	

	
    
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
