package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import dataaccess.DBManager;
import model.Country;
import model.PlayerForRanking;
import model.PlayerForRankingExpert;
import model.PlayerForRankingRookie;

public class RacerController {
	private DBManager dbManager;
	private ArrayList<PlayerForRanking> players;
	private HashMap<Integer, Country> countries;
	
	public RacerController() {
		try {
			dbManager = new DBManager("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/racerDB", "postgres", "1234");
			this.initialize();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void initialize() {
		countries = new HashMap<Integer, Country>();
		players = new ArrayList<PlayerForRanking>();
		
		//TODO: completar las colecciones de países y de jugadores con los datos recuperados desde la Base de Datos 
 try {
		Connection connection = dbManager.getConnection();
		
		Statement statement1 = connection.createStatement();
		Statement statement2 = connection.createStatement();
	//	SELECT countryid, name FROM country
		
        String query1 = "SELECT countryid, name FROM country";
        String query2 = "SELECT playerID, nickname, level, playedGames, wonGames,questions, questionsOK, movesDone, countryID FROM player" ;
        
        ResultSet TablaCountry= statement1.executeQuery(query1);
        ResultSet TablaPlayers= statement2.executeQuery(query2);
       
	while(TablaCountry.next() ) { 
	
	int couid = TablaCountry.getInt("countryid");
	String countryname= TablaCountry.getString("name");
	Country country = new Country(couid,countryname);
	countries.put(couid, country);
		
	}
	
	while(TablaPlayers.next()) {
	int playerID = TablaPlayers.getInt("playerid");
	String nickname= TablaPlayers.getString("nickname");
	String level = TablaPlayers.getString("level");
	int playedGames = TablaPlayers.getInt("playedgames");
	int wonGames = TablaPlayers.getInt("wongames");
	int questions = TablaPlayers.getInt("questions");
	int questionsOK = TablaPlayers.getInt("questionsok");
	int moveDone = TablaPlayers.getInt("movesdone");
	int countryID = TablaPlayers.getInt("countryid");  // se obtiene el id de la base de datos y despues 

    //Se usa el id de lpais para obtener el objeto de country dentro del hashmap
    Country country = countries.get(countryID);

    if (level.equals("E")) {
		 PlayerForRankingExpert player= new PlayerForRankingExpert(playerID,nickname,level,playedGames,wonGames,questions,questionsOK,moveDone,country);
		 players.add(player);
		
	}
	if (level.equals("N")) {
		PlayerForRankingRookie player = new PlayerForRankingRookie(playerID,nickname,level,playedGames,wonGames,questions,questionsOK,moveDone,country);
		 players.add(player);
		
	
	}
    
  
	}
		
	


	
		
   statement1.close();
   statement2.close();
  connection.close();	
 }catch(SQLException e) {
	 e.printStackTrace();
	}

	}

	public String getRankingReport() {
		
		StringBuilder sb = new StringBuilder();
		Statement st;
		float max=0;
		String maxPuntaje=" ";
		int participantes = 0 ;
		sb.append("=============================================================================================================================================");
		sb.append("\n");
		sb.append("RANKING jugadores Racer");
		sb.append("\n");
		sb.append("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");		
		sb.append("\n");
		sb.append("Nickname" + "\t" + "Nivel" + "\t" + "Pais de origen" +  "\t" + "PJ" + "\t" + "PG" +  "\t" + "#?" + "\t" + "OK" + "\t" + "#Movidas" + "\t" + "MpP" +  "\t" + "Puntaje");
		sb.append("\n");
		sb.append("=============================================================================================================================================");
		sb.append("\n");
		
		//TODO: Completar el reporte del ranking a partir de los objetos
		
		for (PlayerForRanking player : players) {
	         float pun=0;
	         float por=0;
	         
	         
	         pun = player.puntaje();
	         por = player.getMovesDone()/player.getPlayedGames();
	         
	         sb.append(player.toString() + por +"\t"+ pun  +"\n");
	         
	         
	         if (pun>max) {
				   max=pun;
				  maxPuntaje= player.getNickname();}
	         
	         
	         participantes++;
	         
	      }
		
		
	     	sb.append("El ranking lo encabeza " +maxPuntaje+ "\n");
	     	sb.append("La cantidad de jugadores son "+participantes + "\n");
		
		return sb.toString();
	}

}
