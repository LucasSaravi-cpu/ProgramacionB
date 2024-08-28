package events;

/**
 * 
 * @author Luis Buffoni
 * Defines the methods that must implement the classes that listen a TankLevelEvent
 */
public interface TankLevelListener {

	/**
	 * 
	 * @param event: The TankLevelEvent received for the listener
	 */
	void listenLevelEvent(TankLevelEvent event);
}
