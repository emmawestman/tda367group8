package se.chalmers.towerdefence;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import se.chalmers.towerdefence.gui.StateBasedMain;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     AppGameContainer app;
		try {
			app = new AppGameContainer(new StateBasedMain());
			 app.setTargetFrameRate(120);
		     app.setDisplayMode(800, 600, false);
		     app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
