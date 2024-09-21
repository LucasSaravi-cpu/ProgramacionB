package run;

import java.awt.EventQueue;

import controller.ClinicController;
import dataaccess.DBManager;
import view.PrescriptionsWindow;

public class App 
{
    public static void main( String[] args )
    {   
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
			    		ClinicController clinicController = new ClinicController();
						PrescriptionsWindow window = new PrescriptionsWindow(clinicController);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}    
        
}
