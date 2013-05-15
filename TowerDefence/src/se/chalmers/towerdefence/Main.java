package se.chalmers.towerdefence;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import se.chalmers.towerdefence.controller.states.SmurfTowerDefence;
/**
 * A  main class to run it as a 
 * @author Jonathan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     AppGameContainer app;
		try {
			app = new AppGameContainer(new SmurfTowerDefence());
			 app.setTargetFrameRate(120);
		     app.setDisplayMode(800, 600, false);
		     app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
