package DAO;  // Define el paquete donde se encuentra esta clase.

import model.Pet;  // Importa la clase Pet desde el paquete model.
import model.PetType;  // Importa la clase PetType desde el paquete model.

import java.sql.*;  // Importa todas las clases del paquete java.sql para manejar la conexión y operaciones con bases de datos.
import java.util.ArrayList;  // Importa la clase ArrayList para manejar listas dinámicas.
import java.util.List;  // Importa la interfaz List para manejar colecciones de objetos.

public class PetDAO {  // Define la clase PetDAO, que maneja las operaciones de acceso a datos para la entidad Pet.
    private PetTypeDAO petTypeDAO = new PetTypeDAO();  // Crea una instancia de PetTypeDAO para acceder a los datos de tipos de mascotas.

    // Método para insertar una nueva mascota en la base de datos.
    public void insertPet(String name, int yearofbirth, String notes, long pettypeId) throws SQLException {  // Declara el método insertPet que lanza SQLException si ocurre un error.
        String sql = "INSERT INTO pet (pet, name, yearofbirth, notes, pettype) VALUES (nextval('pet_pet_seq'), ?, ?, ?, ?)";  // SQL para insertar una nueva mascota, generando un nuevo ID con una secuencia.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para evitar inyecciones SQL y permitir parámetros dinámicos.

            pstmt.setString(1, name);  // Establece el nombre de la mascota en el primer parámetro de la consulta.
            pstmt.setInt(2, yearofbirth);  // Establece el año de nacimiento de la mascota en el segundo parámetro de la consulta.
            pstmt.setString(3, notes);  // Establece las notas sobre la mascota en el tercer parámetro de la consulta.
            pstmt.setLong(4, pettypeId);  // Establece el ID del tipo de mascota en el cuarto parámetro de la consulta.
            pstmt.executeUpdate();  // Ejecuta la consulta de actualización en la base de datos.
        }
    }

    // Método para actualizar los detalles de una mascota existente en la base de datos.
    public void updatePet(long petId, String newName, int newYearofbirth, String newNotes, long newPettypeId) throws SQLException {  // Declara el método updatePet que lanza SQLException si ocurre un error.
        String sql = "UPDATE pet SET name = ?, yearofbirth = ?, notes = ?, pettype = ? WHERE pet = ?";  // SQL para actualizar los detalles de una mascota existente.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para permitir parámetros dinámicos.

            pstmt.setString(1, newName);  // Establece el nuevo nombre de la mascota en el primer parámetro de la consulta.
            pstmt.setInt(2, newYearofbirth);  // Establece el nuevo año de nacimiento en el segundo parámetro de la consulta.
            pstmt.setString(3, newNotes);  // Establece las nuevas notas en el tercer parámetro de la consulta.
            pstmt.setLong(4, newPettypeId);  // Establece el nuevo ID del tipo de mascota en el cuarto parámetro de la consulta.
            pstmt.setLong(5, petId);  // Establece el ID de la mascota a actualizar en el quinto parámetro de la consulta.
            pstmt.executeUpdate();  // Ejecuta la consulta de actualización en la base de datos.
        }
    }

    // Método para eliminar una mascota de la base de datos.
    public void deletePet(long petId) throws SQLException {  // Declara el método deletePet que lanza SQLException si ocurre un error.
        String sql = "DELETE FROM pet WHERE pet = ?";  // SQL para eliminar una mascota de la base de datos.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Prepara la declaración SQL para permitir parámetros dinámicos.

            pstmt.setLong(1, petId);  // Establece el ID de la mascota a eliminar en el primer parámetro de la consulta.
            pstmt.executeUpdate();  // Ejecuta la consulta de eliminación en la base de datos.
        }
    }

    // Método para obtener una lista de todas las mascotas en la base de datos.
    public List<Pet> getAllPets() throws SQLException {  // Declara el método getAllPets que lanza SQLException si ocurre un error.
        String sql = "SELECT pet, name, yearofbirth, notes, pettype FROM pet";  // SQL para seleccionar todos los registros de mascotas.
        List<Pet> pets = new ArrayList<>();  // Crea una lista para almacenar las mascotas obtenidas.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             Statement stmt = conn.createStatement();  // Crea un Statement para ejecutar la consulta SQL.
             ResultSet rs = stmt.executeQuery(sql)) {  // Ejecuta la consulta y obtiene el conjunto de resultados.

            while (rs.next()) {  // Recorre el conjunto de resultados.
                long petId = rs.getLong("pet");  // Obtiene el ID de la mascota del resultado actual.
                String name = rs.getString("name");  // Obtiene el nombre de la mascota del resultado actual.
                int yearofbirth = rs.getInt("yearofbirth");  // Obtiene el año de nacimiento de la mascota del resultado actual.
                String notes = rs.getString("notes");  // Obtiene las notas sobre la mascota del resultado actual.
                long pettypeId = rs.getLong("pettype");  // Obtiene el ID del tipo de mascota del resultado actual.

                PetType pettype = petTypeDAO.getPetTypeById(pettypeId); // Llama al método getPetTypeById() de PetTypeDAO para obtener el tipo de mascota correspondiente.
                Pet pet = new Pet(petId, name, yearofbirth, notes, pettype);  // Crea una nueva instancia de Pet con los datos obtenidos.
                pets.add(pet);  // Agrega la mascota a la lista de mascotas.
            }
        }

        return pets;  // Devuelve la lista de mascotas.
    }

    // Método para mostrar todas las mascotas en la consola.
    public void displayAllPets() throws SQLException {  // Declara el método displayAllPets que lanza SQLException si ocurre un error.
        String sql = "SELECT pet, name, yearofbirth, notes, pettype FROM pet";  // SQL para seleccionar todos los registros de mascotas.

        try (Connection conn = DBConnection.getConnection();  // Obtiene una conexión a la base de datos usando el método estático getConnection() de DBConnection.
             Statement stmt = conn.createStatement();  // Crea un Statement para ejecutar la consulta SQL.
             ResultSet rs = stmt.executeQuery(sql)) {  // Ejecuta la consulta y obtiene el conjunto de resultados.

            while (rs.next()) {  // Recorre el conjunto de resultados.
                long petId = rs.getLong("pet");  // Obtiene el ID de la mascota del resultado actual.
                String name = rs.getString("name");  // Obtiene el nombre de la mascota del resultado actual.
                int yearofbirth = rs.getInt("yearofbirth");  // Obtiene el año de nacimiento de la mascota del resultado actual.
                String notes = rs.getString("notes");  // Obtiene las notas sobre la mascota del resultado actual.
                long pettypeId = rs.getLong("pettype");  // Obtiene el ID del tipo de mascota del resultado actual.
                // Imprime los detalles de la mascota en la consola.
                System.out.println("Pet ID: " + petId + ", Name: " + name + ", Year of birth: " + yearofbirth +
                        ", Notes: " + notes + ", Pet Type ID: " + pettypeId);
            }
        }
    }
}
