package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.Color;
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
 * @author Jonathan, Julia, Oskar, Emma
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
	
	private int highScore1;
	private int highScore2;
	private int highScore3;
	private int highScore4;
	private int highScore5;
	private int highScore6;

	private Button backButton;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		levelOneButton=new Button(ResourceHandler.getInstance().getSign(),97,100);
		levelOneButton.setResolution(50, 50);

		levelTwoButton=new Button(ResourceHandler.getInstance().getSign(),197,210);
		levelTwoButton.setResolution(50, 50);

		levelThreeButton=new Button(ResourceHandler.getInstance().getSign(),314,250);
		levelThreeButton.setResolution(50, 50);

		levelFourButton=new Button(ResourceHandler.getInstance().getSign(),441,348);
		levelFourButton.setResolution(50, 50);

		levelFiveButton=new Button(ResourceHandler.getInstance().getSign(),412,460);
		levelFiveButton.setResolution(50, 50);

		levelSixButton=new Button(ResourceHandler.getInstance().getSign(),602,500);
		levelSixButton.setResolution(50, 50);	
		
		backButton=new Button(ResourceHandler.getInstance().getBackImage(),0,0, 50, 50);
		
		
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
		
		highScore1 = fileHandler.getHighScore("level1");
		highScore2 = fileHandler.getHighScore("level2");
		highScore3 = fileHandler.getHighScore("level3");
		highScore4 = fileHandler.getHighScore("level4");
		highScore5 = fileHandler.getHighScore("level5");
		highScore6 = fileHandler.getHighScore("level6");
	}
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		//to make sure that the high score file isn't empty 
		fileHandler.saveHighScore(new HighScore(0, "level0"));
		background.draw(0,0);
		
		levelOneButton.draw();
		g.setColor(Color.white);
		g.drawString("1", 120, 110);
		if (highScore1 != -1) {
			ResourceHandler.getInstance().getBannerHighScore().draw(80, 140, 90, 40);
			g.setColor(Color.black);
			g.drawString("" + highScore1, 108, 158);
		}

		if(level2){
			levelTwoButton.draw();
			g.setColor(Color.white);
			g.drawString("2", 220, 220);
			if (highScore2 != -1) {
				ResourceHandler.getInstance().getBannerHighScore().draw(180, 250, 90, 40);
				g.setColor(Color.black);
				g.drawString("" + highScore2, 208, 268);
			}
		}
		if(level3){
			levelThreeButton.draw();
			g.setColor(Color.white);
			g.drawString("3", 338, 260);
			if (highScore3 != -1) {
				ResourceHandler.getInstance().getBannerHighScore().draw(298, 290, 90, 40);
				g.setColor(Color.black);
				g.drawString("" + highScore3, 326, 308);
			}
		}
		if(level4){
			levelFourButton.draw();
			g.setColor(Color.white);
			g.drawString("4", 464, 358);
			if (highScore4 != -1) {
				ResourceHandler.getInstance().getBannerHighScore().draw(424, 388, 90, 40);
				g.setColor(Color.black);
				g.drawString("" + highScore4, 452, 406);
			}
		}
		if(level5){
			levelFiveButton.draw();
			g.setColor(Color.white);
			g.drawString("5", 435, 470);
			if (highScore5 != -1) {
				ResourceHandler.getInstance().getBannerHighScore().draw(395, 500, 90, 40);
				g.setColor(Color.black);
				g.drawString("" + highScore5, 423, 518);
			}
		}
		if(level6){
			levelSixButton.draw();
			g.setColor(Color.white);
			g.drawString("6", 625, 510);
			if (highScore6 != -1) {
				ResourceHandler.getInstance().getBannerHighScore().draw(585, 540, 90, 40);
				g.setColor(Color.black);
				g.drawString("" + highScore6, 613, 558);
			}
		}
		
		backButton.draw();

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
			  } else if(backButton.inSpan(mouseX, mouseY)){
				  sbg.enterState(1);				  
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
