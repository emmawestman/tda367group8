package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A Class with the sole purpose to add states to the game.
 * @author Jonathan
 *
 */


public class SmurfTowerDefence	extends StateBasedGame {
	 
	  public SmurfTowerDefence() {
		super("Smurf Tower Defence");
	}

	

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainMenuState());
		addState(new GamePlayState());
		addState(new LevelSelectionState());
		addState(new OptionsState());
		addState(new LoreState());
		addState(new InstructionsState());
	}
	
}