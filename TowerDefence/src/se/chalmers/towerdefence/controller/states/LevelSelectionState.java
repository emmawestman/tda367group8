package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.controller.LevelController;
import se.chalmers.towerdefence.gui.Button;
/**
 * A state where the player chooses a map to play
 * @author Jonathan
 *
 */
public class LevelSelectionState extends BasicGameState{
	private static final int ID = 4;
	
	private TiledMap map;
	
	private Button levelOneButton;
	private Button levelTwoButton;
	private Button levelThreeButton;	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		levelOneButton=new Button(new Image("res/ball.gif"),100,100);
		levelTwoButton=new Button(new Image("res/ball.gif"),200,200);
		levelThreeButton=new Button(new Image("res/ball.gif"),300,300);
	}
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		levelOneButton.draw();
		levelTwoButton.draw();
		levelThreeButton.draw();
		
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
				
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(levelOneButton.inSpan(mouseX, mouseY)){
				map = new TiledMap("res/Firstmap.tmx");
				  changeLevel(sbg);				  
			  }else if(levelTwoButton.inSpan(mouseX, mouseY)){
				  map = new TiledMap("res/Secondmap.tmx");
				  changeLevel(sbg);				  
			  } else if(levelThreeButton.inSpan(mouseX, mouseY)){
				  map = new TiledMap("res/Thirdmap.tmx");
				  changeLevel(sbg);				  
			  }
		}
	}
	private void changeLevel(StateBasedGame sbg) {
		LevelController.getInstance().setMap(map);
		sbg.enterState(2);
	}
	@Override
	public int getID() {
		return ID;
	}
}
