package model;

public class PlayerForRankingExpert extends PlayerForRanking {

	
	

public PlayerForRankingExpert(int playerID, String nickname,String level, int playedGames, int wonGames, int questions,
			int questionsOK, int movesDone, Country country) {
		super(playerID, nickname,level, playedGames, wonGames, questions, questionsOK, movesDone, country);
		// TODO Auto-generated constructor stub
	}



@Override
public int puntaje() {
	
	int pun = getPlayedGames() + (getWonGames()*100) +getQuestions() + getQuestionsOK()*2;
  
	System.out.println(pun);
	return pun;
}


	
	
}
