import controller.TankController;
import model.Tank;
import view.PanelTank;
import view.ViewTankInterface;

public class RunMVCTank {

	public static void main(String[] args) {
		Tank tank = new Tank(100);
		ViewTankInterface panelTank = new PanelTank();
		TankController controller = new TankController(tank, panelTank);
		tank.setTankLevelListener(controller);
		tank.setFullTankListener(controller);
		panelTank.setChangeFlowListener(controller);
		panelTank.initialize();		
	}

}
