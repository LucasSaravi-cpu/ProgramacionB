package model;

public class PlayerForRankingRookie extends PlayerForRanking {

	
	public PlayerForRankingRookie(int playerID, String nickname,int playedGames, int wonGames, int questions,
			int questionsOK, int movesDone, Country country) {
		super(playerID, nickname, playedGames, wonGames, questions, questionsOK, movesDone, country);
		// TODO Auto-generated constructor stub
	}



@Override
public int puntaje() {
	
	int pun = getPlayedGames() + getWonGames()*125 + getQuestions() + getQuestionsOK()*3 + getMovesDone()/getPlayedGames();
  
	
	return pun;
}
	

public String getlevel() {
	
	return "Novato";
}
	
}


