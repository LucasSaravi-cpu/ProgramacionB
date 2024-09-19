package DAO;  // Define el paquete donde se encuentra esta clase.

import java.sql.Connection;  // Importa la interfaz Connection desde el paquete java.sql, que se utiliza para establecer una conexión con una base de datos.
import java.sql.DriverManager;  // Importa la clase DriverManager desde el paquete java.sql, que se utiliza para obtener una conexión con una base de datos.
import java.sql.SQLException;  // Importa la clase SQLException desde el paquete java.sql, que maneja errores de SQL.

public class DBConnection {  // Define la clase DBConnection.

    // Define constantes para los parámetros de conexión a la base de datos.
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/petDB";  // URL de conexión a la base de datos PostgreSQL.
    private static final String username = "postgres";  // Nombre de usuario para la conexión a la base de datos.
    private static final String password = "1234";  // Contraseña para la conexión a la base de datos.

    // Método estático para obtener una conexión a la base de datos.
    public static Connection getConnection() throws SQLException {  // Declara el método getConnection que lanza una SQLException si ocurre un error.
        return DriverManager.getConnection(jdbcUrl, username, password);  // Utiliza DriverManager para obtener una conexión a la base de datos usando la URL, el nombre de usuario y la contraseña proporcionados.
    }
}