package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	  private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/oncedesunidos";  // URL de conexión a la base de datos PostgreSQL.
      private static final String username = "postgres";  // Nombre de usuario para la conexión a la base de datos.
      private static final String password = "1234";  // Contraseña para la conexión a la base de datos.


    public static Connection getConnection() throws SQLException {
        //TO DO: devolver conexión a la base de datos, aquí
    	 return DriverManager.getConnection(jdbcUrl, username, password);
    	
      
       
    	
    	
    }
}
