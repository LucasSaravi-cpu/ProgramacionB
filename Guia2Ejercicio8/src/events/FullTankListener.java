package events;

/**
 * 
 * @author Luis Buffoni
 * Defines the methods that must implement the classes that listen a FullTankEvent
 */
public interface FullTankListener {
	/**
	 * 
	 * @param event: The FullTankEvent received for the listener
	 */
	void listenFullTankEvent(FullTankEvent event);

}
