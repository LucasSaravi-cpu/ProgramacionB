package DAO;

import model.Socio;
import model.Deporte;
import model.SocioVitalicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SociosDAO {
    private DeportesDAO petTypeDAO = new DeportesDAO();

    public void insertarSocio(String nombre, char genero, boolean vitalicio, List<Deporte> listaDeportes) throws SQLException {
     //   String sql = "INSERT INTO socios (idsocio, nombre, genero, vitalicio) VALUES (nextval('socios_idsocio'), ?, ?, ?) RETURNING idsocio";
        String sql = "INSERT INTO socios (nombre, genero, vitalicio) VALUES (?, ?, ?) RETURNING idsocio";
        long idSocio = -1;
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, String.valueOf(genero));
            pstmt.setBoolean(3, vitalicio);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idSocio = rs.getInt("idsocio");
                if (!listaDeportes.isEmpty()) {
                    sql = "INSERT INTO socios_deportes (idsocio, iddeporte) VALUES (?, ?)";
                    PreparedStatement pstmt2 = conn.prepareStatement(sql);
                    pstmt2 = conn.prepareStatement(sql);
                    for (Deporte deporte: listaDeportes) {
                        pstmt2.setLong(1, idSocio);
                        pstmt2.setLong(2, deporte.getIdDeporte());
                        pstmt2.executeUpdate();
                    }
                }
            }
        }
    }
    

    public void actualizarSocio(long idsocio, String nombre, char genero, boolean vitalicio, List<Deporte> listaDeportes) throws SQLException {
         
    
    	//TO DO: Actualizar el registro del socio, aquí

            //TO DO: Borrar los deportes que el socio tenía previamente registrados en la tabla socios_deportes (ver método eliminarDeportesSocio)

            //TO DO: Insertar los nuevos deportes del socio en la tabla socios_deportes, aquí
    	
    	 String sql = "UPDATE socios SET nombre = ?, genero = ?, vitalicio = ? WHERE idsocio = ?";
         
         try (Connection conn = DBConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {

             pstmt.setString(1, nombre);
             pstmt.setString(2, String.valueOf(genero));
             pstmt.setBoolean(3, vitalicio);
             pstmt.setLong(4, idsocio);
             pstmt.executeUpdate();
         }

        
         eliminarDeportesSocio(idsocio);

       
         if (!listaDeportes.isEmpty()) {
             String sqlInsert = "INSERT INTO socios_deportes (idsocio, iddeporte) VALUES (?, ?)";
             try (Connection conn = DBConnection.getConnection();
                  PreparedStatement pstmt2 = conn.prepareStatement(sqlInsert)) {
                 for (Deporte deporte : listaDeportes) {
                     pstmt2.setLong(1, idsocio);
                     pstmt2.setLong(2, deporte.getIdDeporte());
                     pstmt2.executeUpdate();
                 }
             }
         }
    	
    }

    public void eliminarSocio(long idsocio) throws SQLException {
        //TO DO: Borrar los registros de los deportes que practica el socio (tabla socios_deportes), aquí

        //TO DO: Borrar el registro del socio, aquí
    
        
        
        String sql = "DELETE FROM socios WHERE idsocio = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, idsocio);
            pstmt.executeUpdate();
        }
    	
    }

    public void eliminarDeportesSocio(long idsocio) throws SQLException {
        //TO DO: Borrar los registros de los deportes que practica el socio (tabla socios_deportes), aquí
    	
    	  String sql = "DELETE FROM socios_deportes WHERE idsocio = ?";
          try (Connection conn = DBConnection.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql)) {

              pstmt.setLong(1, idsocio);
              pstmt.executeUpdate();
          }
    }

    public List<Socio> getListaSocios() throws SQLException {
        List<Socio> listaSocios = new ArrayList<Socio>();

        //TO DO: Recuperar registros de la tabla socios y crearlos en la lista, aquí
        //       De cada socio recuperar los deportes que practica invocando al método getDeportesSocio(idSocio)
        
       
        String sql = "SELECT idsocio, nombre, genero, vitalicio FROM socios";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                long idSocio = rs.getLong("idsocio");
                String nombre = rs.getString("nombre");
                char genero = rs.getString("genero").charAt(0);
                boolean vitalicio = rs.getBoolean("vitalicio");

                List<Deporte> deportes = getDeportesSocio(idSocio);
                Socio socio;
                if (vitalicio) {
                    socio = new SocioVitalicio(idSocio, nombre, genero, vitalicio);
                } else {
                    socio = new Socio(idSocio, nombre, genero, vitalicio);
                }
                
                socio.setDeportes(deportes);
                listaSocios.add(socio);
            }
        }
        return listaSocios;

     
    }

    public List<Deporte> getDeportesSocio(Long idSocio) throws SQLException {
        //Recupera los deportes que practica el Socio y los devuelve en una lista
        List<Deporte> listaDeportesSocio = new ArrayList<Deporte>();
        
        String sql = "SELECT d.iddeporte, d.descripcion, d.valor " +"FROM socios_deportes sd " + "JOIN deportes d ON d.iddeporte = sd.iddeporte " +"WHERE sd.idsocio = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            stmt.setLong(1, idSocio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Deporte deporte = new Deporte(rs.getLong("iddeporte"),rs.getString("descripcion"), rs.getBigDecimal("valor"));
                listaDeportesSocio.add(deporte);
            }
        }
        return listaDeportesSocio;
    }

}
