package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.gui.Button;

/**
 * A state where the player can start the game and change the options
 * @author Jonathan
 *
 */

public class MainMenuState extends BasicGameState{
	private static final int ID = 1;
	private Button startGameButton;
	private Image splash;
	private int levelSelectionState = 4;
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		splash= new Image("res/splash.gif");
		startGameButton=new Button(new Image("res/start.gif"),140,300);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		
		splash.draw(0,0);
		startGameButton.draw();
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		

		Input input = gc.getInput();
		

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
				
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(startGameButton.inSpan(mouseX, mouseY)){
				  startGame(sbg);				  
			  }
		}
	}

	private void startGame(StateBasedGame sbg) {
		sbg.enterState(levelSelectionState);
	}

	@Override
	public int getID() {
		return ID;
	}
	
}
