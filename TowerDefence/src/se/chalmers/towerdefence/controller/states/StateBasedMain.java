package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;




public class StateBasedMain	extends StateBasedGame {
	 
	  public StateBasedMain() {
		super("Smurf Tower Defence");
	}

	

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainMenuState());
		addState(new GamePlayState());
		addState(new LevelSelectionState());
	}
	
}