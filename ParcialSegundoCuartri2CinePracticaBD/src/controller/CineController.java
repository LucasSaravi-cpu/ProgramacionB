package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cartelera;
import model.Estrenos;
import model.Peliculas;










public class CineController {
	
	private ArrayList<Peliculas>  peliculas;

   public CineController() {
	   
	   this.inicio();
	   
   }
	
		
	private void inicio() {	
		
		peliculas = new ArrayList<Peliculas>();
		String driver="org.postgresql.Driver";
		
		
		try {
		Class.forName(driver);
		
		String url = "jdbc:postgresql://localhost:5432/Peliculas";
		String user ="postgres" , password="1234";
					
		Connection connection = DriverManager.getConnection(url,user,password);
		
		Statement statement1 = connection.createStatement();
		Statement statement2 = connection.createStatement();
		
		String query ="SELECT *FROM estrenos";
		String query2 ="SELECT * FROM cartelera";
		
		ResultSet tablaEstrenos= statement1.executeQuery(query);
		ResultSet tablaCartelera= statement2.executeQuery(query2);
	
		
		
		

		while(tablaCartelera.next()) {
			
			
			String nombr = tablaCartelera.getString("nombre");
			String tip = tablaCartelera.getString("tipo");
			String fech = tablaCartelera.getString("AñoEstreno");
			
			int cantida =tablaCartelera.getInt("cantidadEntradas");
			
         Cartelera cartelera  =new Cartelera(nombr,fech,tip,cantida); 
		peliculas.add(cartelera);
		
		}
	
		while(tablaEstrenos.next()) {
		
		
			String nombre = tablaEstrenos.getString("nombre");
			String tipo = tablaEstrenos.getString("Tipo");
			String fecha = tablaEstrenos.getString("AñoEstreno");		
			int cantidad =tablaEstrenos.getInt("cantidadEntradas");
			
         Estrenos estreno  =new Estrenos(nombre,fecha,tipo,cantidad); 
		peliculas.add(estreno);
		
	
		}
		
		
		
	
		
		
		
		
		
		
		statement1.close();
		statement2.close();
		connection.close();
		
		
		
		} catch(ClassNotFoundException cnfe) {
			System.out.println("NO EXISTE EL DRIVER:"+ driver);
			    
		}catch(SQLException se) {
			  System.out.println("SQLException:" + se);
		}
		
	
		
		
		
		
		
	}
	
	
	
	public String getMonto() {
		
		StringBuilder sb = new StringBuilder();
	
		sb.append("Cartelera del dia ");
		sb.append("\n");
		sb.append("--------------------------------------------------------------------------------");		
		sb.append("\n");
		sb.append("nombre \t      " +            "          año \t "  + "tipo \t"  + "      entradas \t"  + "Recaudacion \n");
		sb.append("=================================================================================");
		sb.append("\n");
		 float recaudacionTotal=0;
		for (Peliculas peli: peliculas) {
		    float recaudacion=0;
		   
			recaudacion = peli.costoEntrada();
			sb.append(peli.toString() +  "          \t" + recaudacion +"\n");
			
			
			recaudacionTotal=recaudacionTotal+recaudacion;
			
	        	}	
	
		
		    sb.append("\n");
	     	sb.append("El total es de  "+ recaudacionTotal+ "\n");
		
		return sb.toString();
	}
	
	
}
