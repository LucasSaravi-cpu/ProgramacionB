package model;

import events.FullTankEvent;
import events.FullTankListener;
import events.TankLevelEvent;
import events.TankLevelListener;

/**
 * @author Luis Buffoni
 * Class that represents a tank of fluids (MODEL)
 */
public class Tank {
   /**
	* Capacity of the tank (greater than 0)
	*/
	private int capacity;
	
	/**
	 * Current level of fluid that the tank contains
	 */
	private int level;
	
	/**
	 * Flow of fluid which the tank is filled/emptied
	 *		  0: The tank is in stationary mode.
	 *		> 0: The tank is being filled with this amount of fluid 
	 *		< 0: The tank is being emptied with this amount of fluid 
	 */
    private int flow;
	
	/**
	 * Listeners that receive a TankLevelEvent each time the Tank.level changes its value
	 */
	private TankLevelListener tankLevelListener;
	
	/**
	 * Listeners that receive a FullTankEvent when the Tank is full
	 */
	private FullTankListener fullTankListener;
	
	/**
	 * @param capacity: Capacity (volume) of the tank
	 */
	public Tank(int capacity) {
		super();
		this.capacity = capacity;
		level = 0;
	}
	
	/**
	 * Set a listener to the tankLevelListener 
	 * @param listener: The listener that will receive a TankLevelEvent each time the level of the tank changes 
	 */
	public void setTankLevelListener(TankLevelListener listener) {
		tankLevelListener = listener;
	}
	
	/**
	 * Set a listener to the fullTankListener
	 * @param listener: The listener that will receive a TankLevelEvent each time the tank is full 
	 */
	public void setFullTankListener(FullTankListener listener) {
		fullTankListener = listener;
	}

	/**
	 * Updates the level of the tank
	 * 
	 */
	public void updateLevel() {
		int newLevel = level + flow;
        if (newLevel > capacity) {
        	newLevel = capacity;
        }
        if (newLevel < 0) {
        	newLevel = 0;
        }
        boolean full = false;
        if (newLevel != level) {
        	level = newLevel;
        	full = (level == capacity);        	
        	tankLevelListener.listenLevelEvent(new TankLevelEvent(level));
        	if (full) {
        		fullTankListener.listenFullTankEvent(new FullTankEvent());
        	}
        }
	}
	
	/**
	 * @param flow sets the value of the flow 
	 */
	public void setFlow(int flow) {
		this.flow = flow;
	}
}
