package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.files.FileHandler;
import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.gui.ResourceHandler;
import se.chalmers.towerdefence.gui.Slider;
import se.chalmers.towerdefence.sound.BackgroundMusic;
import se.chalmers.towerdefence.sound.SoundFX;

public class OptionsState extends BasicGameState {
	private static final int ID = 5;
	private Slider musicSlider;
	private Button backButton;
	private Button clearButton;
	private FileHandler fileHandler;
	private Slider soundSlider;
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1)
			throws SlickException {
			ResourceHandler rH = ResourceHandler.getInstance();
			musicSlider=new Slider(100,100,20,200);
			soundSlider=new Slider(100,200,20,200);	
			musicSlider.changeSlider((int)(100+(200*BackgroundMusic.getInstance().getVolume())));

			soundSlider.changeSlider((int)(100+(200*SoundFX.getInstance().getVolume())));
			backButton=new Button(rH.getBackImage(),0,0, 50, 50);
			clearButton=new Button(rH.getStartOverImage(),100,300, 130, 46);
	
			fileHandler = new FileHandler();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
			g.setColor(Color.black);
			musicSlider.draw();
			soundSlider.draw();
			g.drawString("Music:|", 40, 100);
			g.drawString("Sound:|", 40, 200);
			g.drawString("|", 300, 100);
			g.drawString("|", 300, 200);
			g.setBackground(Color.lightGray);
			backButton.draw();
			clearButton.draw();
			
		
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
				fileHandler.saveSoundSettings();
			}else if(backButton.inSpan(mouseX, mouseY)){
				sbg.enterState(1);
			}else if(clearButton.inSpan(mouseX, mouseY)){
				resetHighscore();
			} else if(soundSlider.inSpan(mouseX, mouseY)){
				SoundFX.getInstance().setVolume(soundSlider.changeSlider(mouseX));
				SoundFX.getInstance().playDuckSound();
				fileHandler.saveSoundSettings();
			}				
		}		
	}

	private void resetHighscore() {
		fileHandler.clearHighScore();
	}

	@Override
	public int getID() {
		return ID;
	}

	
	
	
}
