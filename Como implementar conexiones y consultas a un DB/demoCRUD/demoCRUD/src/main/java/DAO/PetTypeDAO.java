package DAO;  // Define el paquete donde se encuentra esta clase.

import model.PetType;  // Importa la clase PetType desde el paquete model.

import java.sql.*;  // Importa todas las clases del paquete java.sql para manejar la conexión y operaciones con bases de datos.
import java.util.ArrayList;  // Importa la clase ArrayList para manejar listas dinámicas.
import java.util.List;  // Importa la interfaz List para manejar colecciones de objetos.

public class PetTypeDAO {  // Define la clase PetTypeDAO, que maneja las operaciones de acceso a datos para la entidad PetType.

    // Método para insertar un nuevo tipo de mascota en la base de datos.
    public void insertPetType(String description) throws SQLException {  // Declara el método insertPetType que lanza SQLException si ocurre un error.
        String sql = "INSERT INTO pettype (pettype, description) VALUES (nextval('pettype_pettype_seq'), ?)";  // SQL para insertar un nuevo tipo de mascota, generando un nuevo ID con una secuencia.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para evitar inyecciones SQL y permitir parámetros dinámicos.

            pstmt.setString(1, description);  // Establece la descripción del tipo de mascota en el primer parámetro de la consulta.
            pstmt.executeUpdate();  // Ejecuta la consulta de inserción en la base de datos.
        }
    }

    // Método para actualizar la descripción de un tipo de mascota existente en la base de datos.
    public void updatePetType(long pettypeId, String newDescription) throws SQLException {  // Declara el método updatePetType que lanza SQLException si ocurre un error.
        String sql = "UPDATE pettype SET description = ? WHERE pettype = ?";  // SQL para actualizar la descripción de un tipo de mascota existente.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para permitir parámetros dinámicos.

            pstmt.setString(1, newDescription);  // Establece la nueva descripción del tipo de mascota en el primer parámetro de la consulta.
            pstmt.setLong(2, pettypeId);  // Establece el ID del tipo de mascota a actualizar en el segundo parámetro de la consulta.
            pstmt.executeUpdate();  // Ejecuta la consulta de actualización en la base de datos.
        }
    }

    // Método para eliminar un tipo de mascota de la base de datos.
    public void deletePetType(long pettypeId) throws SQLException {  // Declara el método deletePetType que lanza SQLException si ocurre un error.
        String sql = "DELETE FROM pettype WHERE pettype = ?";  // SQL para eliminar un tipo de mascota de la base de datos.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para permitir parámetros dinámicos.

            pstmt.setLong(1, pettypeId);  // Establece el ID del tipo de mascota a eliminar en el primer parámetro de la consulta.
            pstmt.executeUpdate();  // Ejecuta la consulta de eliminación en la base de datos.
        }
    }

    // Método para mostrar todos los tipos de mascotas en la consola.
    public void displayAllPetTypes() throws SQLException {  // Declara el método displayAllPetTypes que lanza SQLException si ocurre un error.
        String sql = "SELECT pettype, description FROM pettype";  // SQL para seleccionar todos los registros de tipos de mascotas.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             Statement stmt = conn.createStatement();  // Crea un Statement para ejecutar la consulta SQL.
             ResultSet rs = stmt.executeQuery(sql)) {  // Ejecuta la consulta y obtiene el conjunto de resultados.

            while (rs.next()) {  // Recorre el conjunto de resultados.
                long pettypeId = rs.getLong("pettype");  // Obtiene el ID del tipo de mascota del resultado actual.
                String description = rs.getString("description");  // Obtiene la descripción del tipo de mascota del resultado actual.
                // Imprime los detalles del tipo de mascota en la consola.
                System.out.println("Pet Type ID: " + pettypeId + ", Description: " + description);
            }
        }
    }

    // Método para obtener una lista de todos los tipos de mascotas en la base de datos.
    public List<PetType> getAllPetTypes() throws SQLException {  // Declara el método getAllPetTypes que lanza SQLException si ocurre un error.
        String sql = "SELECT pettype, description FROM pettype order by description";  // SQL para seleccionar todos los registros de tipos de mascotas y ordenarlos por descripción.
        List<PetType> petTypes = new ArrayList<>();  // Crea una lista para almacenar los tipos de mascotas obtenidos.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             Statement stmt = conn.createStatement();  // Crea un Statement para ejecutar la consulta SQL.
             ResultSet rs = stmt.executeQuery(sql)) {  // Ejecuta la consulta y obtiene el conjunto de resultados.

            while (rs.next()) {  // Recorre el conjunto de resultados.
                long pettypeId = rs.getLong("pettype");  // Obtiene el ID del tipo de mascota del resultado actual.
                String description = rs.getString("description");  // Obtiene la descripción del tipo de mascota del resultado actual.
                PetType petType = new PetType(pettypeId, description);  // Crea una nueva instancia de PetType con los datos obtenidos.
                petTypes.add(petType);  // Agrega el tipo de mascota a la lista de tipos de mascotas.
            }
        }
        return petTypes;  // Devuelve la lista de tipos de mascotas.
    }

    // Método para obtener un tipo de mascota por su ID.
    public PetType getPetTypeById(long id) throws SQLException {  // Declara el método getPetTypeById que lanza SQLException si ocurre un error.
        String sql = "SELECT pettype, description FROM pettype WHERE pettype = ?";  // SQL para seleccionar un tipo de mascota específico por su ID.
        PetType petType = null;  // Inicializa una variable para almacenar el tipo de mascota obtenido.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para permitir parámetros dinámicos.

            pstmt.setLong(1, id);  // Establece el ID del tipo de mascota a buscar en el primer parámetro de la consulta.
            try (ResultSet rs = pstmt.executeQuery()) {  // Ejecuta la consulta y obtiene el conjunto de resultados.
                if (rs.next()) {  // Si hay resultados.
                    long pettypeId = rs.getLong("pettype");  // Obtiene el ID del tipo de mascota del resultado actual.
                    String description = rs.getString("description");  // Obtiene la descripción del tipo de mascota del resultado actual.
                    petType = new PetType(pettypeId, description);  // Crea una nueva instancia de PetType con los datos obtenidos.
                }
            }
        }

        return petType;  // Devuelve el tipo de mascota obtenido (o null si no se encontró).
    }
}