package run;

import java.awt.EventQueue;

import controller.RacerController;
import dataaccess.DBManager;
import view.RankingWindow;

public class App 
{
    public static void main( String[] args )
    {   
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
			    		RacerController racerController = new RacerController();
						RankingWindow window = new RankingWindow(racerController);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}    
        
}
