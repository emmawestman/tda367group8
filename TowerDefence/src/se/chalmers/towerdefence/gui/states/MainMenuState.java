package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState{
	private static final int ID = 1;
	private Image start;
	private Image splash;
	private int menuX=100;
    private int menuY=300;
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		splash= new Image("res/splash.gif");
		start= new Image("res/start.gif");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		
		splash.draw(0,0);
		start.draw(menuX,menuY);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		

		Input input = gc.getInput();
		

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
				
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if( ( mouseX >= menuX && mouseX <= menuX + start.getWidth()) &&
			  ( mouseY >= menuY && mouseY <= menuY + start.getHeight()) ){
				  startGame(sbg);				  
			  }
		}
	}

	private void startGame(StateBasedGame sbg) {
		sbg.enterState(4);
	}

	@Override
	public int getID() {
		return ID;
	}
	
}
