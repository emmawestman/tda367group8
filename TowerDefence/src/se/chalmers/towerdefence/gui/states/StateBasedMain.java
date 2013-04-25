package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class StateBasedMain	extends StateBasedGame {
	 
	  public StateBasedMain() {
		super("Tower Defence");
	}

	public static void main(String[] args) throws SlickException{
	     AppGameContainer app = new AppGameContainer(new StateBasedMain());
	     app.setTargetFrameRate(120);
	     app.setDisplayMode(800, 600, false);
	     app.start();
	  }

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new GamePlayState());
		addState(new GameOverState());
		StateController.setInstance(this);
	}
	
}