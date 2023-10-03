package model;

public class PlayerForRanking {
	
	private int playerID;
	private String nickname;
	private int playedGames;
	private int wonGames;
	private int questions;
	private int questionsOK;
	private int movesDone;
	private Country country;
	private String level;

	
	
	
	
	public PlayerForRanking(int playerID, String nickname,String level, int playedGames, int wonGames, int questions,int questionsOK, int movesDone,
			Country country) {
		super();
		this.playerID = playerID;
		this.nickname = nickname;
		this.playedGames = playedGames;
		this.wonGames = wonGames;
		this.questions = questions;
		this.questionsOK=questionsOK;
		this.movesDone = movesDone;
		this.country = country;
		this.level = level;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPlayedGames() {
		return playedGames;
	}
	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}
	public int getWonGames() {
		return wonGames;
	}
	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
	}
	public int getQuestions() {
		return questions;
	}
	public void setQuestions(int questions) {
		this.questions = questions;
	}
	public int getMovesDone() {
		return movesDone;
	}
	public void setMovesDone(int movesDone) {
		this.movesDone = movesDone;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
	public int getQuestionsOK() {
		return questionsOK;
	}
	public void setQuestionsOK(int questionsOK) {
		this.questionsOK = questionsOK;
	}
	
	
	
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int puntaje() {
		return 0;
	}
	@Override
	public String toString() {
		return nickname +"\t"+ level +"\t "+ country +"\t"+ playedGames+ "\t " + wonGames + "\t" + questions + "\t" + questionsOK+ "\t" + movesDone + "\t"  ;
	}
	

	
	
	
	
	
}
