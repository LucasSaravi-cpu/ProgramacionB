package events;

public class ChangeFlowEvent {

	/**
	 * The flow of fluid for full/empty the tank
	 */
	private int flow;

	public ChangeFlowEvent(int flow) {
		this.flow = flow;
	}

	/**
	 * Get the flow of fluid being used for full or empty the tank
	 */
	public int getFlow() {
		return flow;
	}

}
