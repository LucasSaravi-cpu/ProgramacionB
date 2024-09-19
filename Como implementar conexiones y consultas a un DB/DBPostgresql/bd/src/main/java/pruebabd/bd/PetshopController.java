package pruebabd.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PetshopController {
	private DBManager gestorBD;
	
	public PetshopController() {
		try {
			gestorBD = new DBManager("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/petshop", "petshop", "postgres", "1234");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void processPets() {
		
		Connection conn = gestorBD.getConnection();
		Statement st;
		System.out.println("========================================================================================");
		System.out.println("Mascotas");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Nombre" + "\t " + "Tipo" + "\t" + "F. Nacimiento" + "\t" + "Notas");
		System.out.println("========================================================================================");
		
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT pet.name, pet.birthdate, pet.notes, pettype.description FROM pet " +
			                               "inner join pettype on pettype.pettype = pet.pettype");
			int cant = 0;
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t " + rs.getString(4) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				cant++;
			}
			System.out.println("----------------------------------------------------------------------------------------");

			System.out.println(cant + " mascotas encontradas\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}  		
	}

}
