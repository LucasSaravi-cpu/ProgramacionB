package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import events.ChangeFlowEvent;
import events.ChangeFlowListener;
import events.FullTankEvent;
import events.FullTankListener;
import events.TankLevelEvent;
import events.TankLevelListener;
import model.Tank;
import view.ViewTankInterface;
/**
 * @author Luis Buffoni
 * Controller for the MVC Tank example. 
 */
public class TankController implements ChangeFlowListener, TankLevelListener, FullTankListener {
	
	/**
	 * Tank of fluids (model part of the MVC example) 
	 */
	private Tank tank;
	
	/**
	 * Panel for command the Tank of fluids (view part of the MVC example) 
	 */
	private ViewTankInterface panelTank;
	
	/**
	 * The timer used to simulate the filling/emptying of the Tank
	 */
	private Timer fluidSimulator;
	
    /**
     * Constructor of the tank Controller
     * @param tank: The tank to be controlled
     * @param panelTank: The Interfaz (GUI) of the panel that control/visualize the status of the tank
     */
	public TankController(Tank tank, ViewTankInterface panelTank) {
		this.tank = tank;
		this.panelTank = panelTank;
		fluidSimulator = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		    	  tank.updateLevel();		    }
		});
		fluidSimulator.start();
	}
	
	/**
	 * Process event generated when the level of the tank changes
	 */
	@Override
	public void listenLevelEvent(TankLevelEvent event) {
	   panelTank.showTankLevel(event.getLevelValue());	
	}

	/**
	 * Process event generated when the tank is full
	 */
	@Override
	public void listenFullTankEvent(FullTankEvent event) {
		panelTank.closeTank();				
	}

	/**
	 * Process event generated when the fluid flow changes
	 */
	@Override
	public void listenChangeFlowEvent(ChangeFlowEvent event) {
		tank.setFlow(event.getFlow());
		
	}

}
