package events;

/**
 * 
 * @author Luis Buffoni
 * Event that informs the level of fluid currently contained by a tank
 */
public class TankLevelEvent {
	
	/**
	 * The level of fluid currently contained by the tank
	 */
	private int levelValue;
	
	/**
	 * Constructor of the TankLevelEvent
	 * @param levelValue: The level of fluid currently contained by the tank
	 */
	public TankLevelEvent(int levelValue) {
		this.levelValue = levelValue;
	}

	/**
	 * 
	 * @return the level of fluid currently contained by the tank
	 */
	public int getLevelValue() {
		return levelValue;
	}


}
