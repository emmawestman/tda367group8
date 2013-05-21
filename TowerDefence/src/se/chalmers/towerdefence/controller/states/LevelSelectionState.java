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
import se.chalmers.towerdefence.files.FileHandler;
import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.model.HighScore;
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
	private Button level4Button;
	private Button level5Button;
	private Button level6Button;
	
	private Image background;
	private FileHandler fileHandler;
	
	private String mapName;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		levelOneButton=new Button(new Image("res/ball.gif"),100,100);
		levelTwoButton=new Button(new Image("res/ball.gif"),200,225);
		levelThreeButton=new Button(new Image("res/ball.gif"),365,300);
		level4Button=new Button(new Image("res/ball.gif"),400,300);
		level5Button=new Button(new Image("res/ball.gif"),450,300);
		level6Button=new Button(new Image("res/ball.gif"),500,300);
		fileHandler = new FileHandler();
		
		background= new Image("res/LevelSelection.png");
		
		mapName = "level1";
	}
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		//to make sure that the high score file isn't empty 
		fileHandler.saveHighScore(new HighScore(0, "level0"));
		background.draw(0,0);
		
		levelOneButton.draw();
		if(fileHandler.isLevelUnlocked("level1")){
			levelTwoButton.draw();
		}
		if(fileHandler.isLevelUnlocked("level2")){
			levelThreeButton.draw();
		}
		if(fileHandler.isLevelUnlocked("level3")){
			level4Button.draw();
		}
		if(fileHandler.isLevelUnlocked("level4")){
			level5Button.draw();
		}
		if(fileHandler.isLevelUnlocked("level5")){
			level6Button.draw();
		}

		gc.setShowFPS(false);
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
				mapName = "level1";  
				changeLevel(sbg);
			  }else if(levelTwoButton.inSpan(mouseX, mouseY) && fileHandler.isLevelUnlocked("level1")){
				  map = new TiledMap("res/Secondmap.tmx");
				  mapName = "level2";
				  changeLevel(sbg);	
			  }else if(levelThreeButton.inSpan(mouseX, mouseY) && fileHandler.isLevelUnlocked("level2")){
				  map = new TiledMap("res/Secondmap.tmx");
				  mapName = "level3";
				  changeLevel(sbg);		
			  }else if(level4Button.inSpan(mouseX, mouseY) && fileHandler.isLevelUnlocked("level3")){
				  map = new TiledMap("res/Secondmap.tmx");
				  mapName = "level4";
				  changeLevel(sbg);		
			  }else if(level5Button.inSpan(mouseX, mouseY) && fileHandler.isLevelUnlocked("level4")){
				  map = new TiledMap("res/Secondmap.tmx");
				  mapName = "level5";
				  changeLevel(sbg);		
			  } else if(level6Button.inSpan(mouseX, mouseY) && fileHandler.isLevelUnlocked("level5")){
				  map = new TiledMap("res/Thirdmap.tmx");
				  mapName = "level6";
				  changeLevel(sbg);				  
			  }
		}
	}
	private void changeLevel(StateBasedGame sbg) {
		LevelController.getInstance().setMap(map);
		LevelController.getInstance().setMapName(mapName);
		sbg.enterState(2);
	}
	@Override
	public int getID() {
		return ID;
	}
}
