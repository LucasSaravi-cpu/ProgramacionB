package pruebabd.bd;

import java.sql.*;

public class DBManager {
	private String databaseName;
	private String url;
	private String port;
	private String username;
	private String password;
	private String driver;
	private Connection connection;

	public DBManager(String driver, String _url, String _dbName, String _usr, String _password) {
		super();
		try { 
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
		}
		this.setDriver(driver);
		this.setUrl(_url);
		this.setPort(port);
		this.setDatabaseName(_dbName);
		this.setUsername(_usr);
		this.setPassword(_password);
		
		try {
			connection = DriverManager.getConnection(
			        this.url, this.username, this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	
	

}
