package se.chalmers.towerdefence.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.gui.states.GameOverState;
import se.chalmers.towerdefence.gui.states.GamePlayState;
import se.chalmers.towerdefence.gui.states.LevelSelectionState;
import se.chalmers.towerdefence.gui.states.MainMenuState;


public class StateBasedMain	extends StateBasedGame {
	 
	  public StateBasedMain() {
		super("Smurf Tower Defence");
	}

	

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainMenuState());
		addState(new GamePlayState());
		addState(new GameOverState());
		addState(new LevelSelectionState());
	}
	
}