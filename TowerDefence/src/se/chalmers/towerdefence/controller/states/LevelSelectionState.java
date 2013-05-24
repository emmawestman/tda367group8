package se.chalmers.towerdefence.controller.states;

import java.util.List;

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
import se.chalmers.towerdefence.gui.ResourceHandler;
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
	private Button levelFourButton;
	private Button levelFiveButton;
	private Button levelSixButton;
	
	private Image background;
	private FileHandler fileHandler;
	
	private String mapName;
	private boolean level2;
	private boolean level3;
	private boolean level4;
	private boolean level5;
	private boolean level6;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		levelOneButton=new Button(ResourceHandler.getInstance().getSign(),100,100);
		levelOneButton.setResolution(50, 50);
		
		levelTwoButton=new Button(ResourceHandler.getInstance().getSign(),200,225);
		levelTwoButton.setResolution(50, 50);
		
		levelThreeButton=new Button(ResourceHandler.getInstance().getSign(),300,250);
		levelThreeButton.setResolution(50, 50);
		
		levelFourButton=new Button(ResourceHandler.getInstance().getSign(),365,300);
		levelFourButton.setResolution(50, 50);
		
		levelFiveButton=new Button(ResourceHandler.getInstance().getSign(),450,359);
		levelFiveButton.setResolution(50, 50);
		
		levelSixButton=new Button(ResourceHandler.getInstance().getSign(),415,470);
		levelSixButton.setResolution(50, 50);	
		
		fileHandler = new FileHandler();
		
		background= ResourceHandler.getInstance().getBackgroundLevelSelection();
		
		mapName = "level1";
	}
	public void enter(GameContainer container, StateBasedGame stateBasedGame) {
		level2 = fileHandler.isLevelUnlocked("level1");
		level3 = fileHandler.isLevelUnlocked("level2");
		level4 = fileHandler.isLevelUnlocked("level3");
		level5 = fileHandler.isLevelUnlocked("level4");
		level6 = fileHandler.isLevelUnlocked("level5");
	}
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		//to make sure that the high score file isn't empty 
		fileHandler.saveHighScore(new HighScore(0, "level0"));
		background.draw(0,0);
		
		levelOneButton.draw();
		if(level2){
			levelTwoButton.draw();
		}
		if(level3){
			levelThreeButton.draw();
		}
		if(level4){
			levelFourButton.draw();
		}
		if(level5){
			levelFiveButton.draw();
		}
		if(level6){
			levelSixButton.draw();
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
			  }else if(levelTwoButton.inSpan(mouseX, mouseY) && level2){
				  map = new TiledMap("res/Secondmap.tmx");
				  mapName = "level2";
				  changeLevel(sbg);	
			  }else if(levelThreeButton.inSpan(mouseX, mouseY) && level3){
				  map = new TiledMap("res/Thirdmap.tmx");
				  mapName = "level3";
				  changeLevel(sbg);		
			  }else if(levelFourButton.inSpan(mouseX, mouseY) && level4){
				  map = new TiledMap("res/Fourthmap.tmx");
				  mapName = "level4";
				  changeLevel(sbg);		
			  }else if(levelFiveButton.inSpan(mouseX, mouseY) && level5){
				  map = new TiledMap("res/Fifthmap.tmx");
				  mapName = "level5";
				  changeLevel(sbg);		
			  } else if(levelSixButton.inSpan(mouseX, mouseY) && level6){
				  map = new TiledMap("res/Sixthmap.tmx");
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
