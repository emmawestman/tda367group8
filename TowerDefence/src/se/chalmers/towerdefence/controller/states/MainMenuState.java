package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.gui.ResourceHandler;
import se.chalmers.towerdefence.sound.BackgroundMusic;

/**
 * A state where the player can start the game and change the options
 * @author Jonathan
 *
 */

public class MainMenuState extends BasicGameState{
	private static final int ID = 1;
	private Button startGameButton;
	private Image startScreen;
	private int levelSelectionState = 4;
	private Button optionsButton;
	private int optionsState= 5;
	private Button loreButton;
	private Button instructionsButton;
	private int loresState=6;
	private int instructionState = 7;
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1)
			throws SlickException {
		
		startScreen = ResourceHandler.getInstance().getStartScreen();
		startGameButton=new Button(ResourceHandler.getInstance().getStartImage(),350,300,130,46);
		instructionsButton=new Button(ResourceHandler.getInstance().getInstructionsImage(),350,360,130,46);
		optionsButton=new Button(ResourceHandler.getInstance().getOptionsImage(),350,420,130,46);
		loreButton=new Button(ResourceHandler.getInstance().getLoreImage(),350,480,130,46);
				
		gc.setShowFPS(false);
		BackgroundMusic.getInstance().loopMusic();
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		
		startScreen.draw(0,0);
		startGameButton.draw();
		optionsButton.draw();
		loreButton.draw();
		instructionsButton.draw();
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		

		Input input = gc.getInput();
		

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
				
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(startGameButton.inSpan(mouseX, mouseY)){
				changeState(sbg, levelSelectionState);				  
			}else if(optionsButton.inSpan(mouseX, mouseY)){
				changeState(sbg, optionsState);				  
			}else if(loreButton.inSpan(mouseX, mouseY)){
				changeState(sbg, loresState);				  
			}else if(instructionsButton.inSpan(mouseX, mouseY)){
				changeState(sbg, instructionState);
			}
			
		}
	}

	private void changeState(StateBasedGame sbg, int id) {
		sbg.enterState(id);
	}

	@Override
	public int getID() {
		return ID;
	}
	
}
