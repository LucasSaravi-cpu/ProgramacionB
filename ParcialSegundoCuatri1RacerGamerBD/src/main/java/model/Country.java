package model;

public class Country {
	
	private int countryID;
	private String name;
	
	
	
	
	public Country(int countryID, String name) {
		super();
		this.countryID = countryID;
		this.name = name;
	}
	
	
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name ;
	}
		
		
	

	
}
