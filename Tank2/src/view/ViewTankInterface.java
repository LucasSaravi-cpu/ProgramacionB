package view;

import events.ChangeFlowListener;

public interface ViewTankInterface {

	/**
	 * Shows the content of the Tank in the Level's digital display and in the graphical representation of the Tank
	 */	
	public void showTankLevel(Integer levelValue);
	
	/**
	 * Sets the tank to the stationary mode: The tank is not receiving/releasing fluid
	 */	
	public void closeTank();	
	/**
	 * Register the Controller as a listener of events generated from the View
	 */	
	public void setChangeFlowListener(ChangeFlowListener listener);
	
	public void initialize();

}
