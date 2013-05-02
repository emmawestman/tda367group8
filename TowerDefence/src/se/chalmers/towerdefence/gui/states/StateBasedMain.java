package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class StateBasedMain	extends StateBasedGame {
	 
	  public StateBasedMain() {
		super("Tower Defence");
	}

	

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new GamePlayState());
		addState(new GameOverState());
	}
	
}