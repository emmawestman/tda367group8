package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.gui.ResourceHandler;
import se.chalmers.towerdefence.gui.Slider;
import se.chalmers.towerdefence.sound.BackgroundMusic;

public class OptionsState extends BasicGameState {
	private static final int ID = 5;
	private Slider musicSlider;
	private Button backButton;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
			musicSlider=new Slider(100,100,20,200);	
			backButton=new Button(ResourceHandler.getInstance().getBallImage(),0,0);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
			musicSlider.draw(g);
			g.drawString("Music: ", 40, 100);
			g.setBackground(Color.cyan);
			backButton.draw();
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(musicSlider.inSpan(mouseX, mouseY)){
				BackgroundMusic.getInstance().setVolume(musicSlider.changeSlider(mouseX));
			}else if(backButton.inSpan(mouseX, mouseY)){
				sbg.enterState(1);
			}
		}		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}

	
	
	
}