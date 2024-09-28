package DAO;

import model.Deporte;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DeportesDAO {

    public void insertarDeporte(String descripcion, BigDecimal valor) throws SQLException {
        //TO DO: Insertar nuevo deporte en la tabla deportes, aquí
    	   String sql = "INSERT INTO deportes (descripcion, valor) VALUES (?, ?) RETURNING iddeporte";
           try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

               pstmt.setString(1, descripcion);
               pstmt.setBigDecimal(2, valor);
               ResultSet rs = pstmt.executeQuery();
               if (rs.next()) {
                   long idDeporte = rs.getLong("iddeporte");
                   System.out.println("Deporte insertado con ID: " + idDeporte);
               }
           }
    	
    	
    }

    public void actualizarDeporte(long iddeporte, String descripcion, BigDecimal valor) throws SQLException {
        //TO DO: Actualizar registro en la tabla deportes, aquí
    	
    	  String sql = "UPDATE deportes SET descripcion = ?, valor = ? WHERE iddeporte = ?";
          try (Connection conn = DBConnection.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql)) {

              pstmt.setString(1, descripcion);
              pstmt.setBigDecimal(2, valor);
              pstmt.setLong(3, iddeporte);
              pstmt.executeUpdate();
          }
    }

    public void borrarDeporte(long iddeporte) throws SQLException {
        //TO DO: Eliminar registro en la tabla deportes, aquí
    	
    	   String sql = "DELETE FROM deportes WHERE iddeporte = ?";
    	
    	  try (Connection conn = DBConnection.getConnection();
    			  
    	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

    	            pstmt.setLong(1, iddeporte);
    	            pstmt.executeUpdate();
    	        }
    	
    	
    }

    public List<Deporte> getListaDeportes() throws SQLException {
        List<Deporte> listaDeportes = new ArrayList<>();

        //TO DO: Recuperar registros de la tabla deportes y crearlos en la lista, aquí
        
        String sql = "SELECT iddeporte, descripcion, valor FROM deportes";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Deporte deporte = new Deporte(rs.getLong("iddeporte"),
                                               rs.getString("descripcion"),
                                               rs.getBigDecimal("valor"));
                listaDeportes.add(deporte);
            }
        }

        return listaDeportes;
    }


}

