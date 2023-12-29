package events;

/**
 * 
 * @author Luis Buffoni
 * Defines the methods that must implement the classes that listen a ChangeFlowEvent
 */
public interface ChangeFlowListener {
	/**
	 * 
	 * @param event: The ChangeFlowEvent received for the listener
	 */
	void listenChangeFlowEvent(ChangeFlowEvent event);

}
