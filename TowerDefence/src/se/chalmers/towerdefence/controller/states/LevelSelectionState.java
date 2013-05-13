package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.controller.LevelController;

public class LevelSelectionState extends BasicGameState{
	private static final int ID = 4;
	
	private TiledMap map;
	 
	private int menuX=100;
    private int menuY=100;

	private int menu2X=200;
    private int menu2Y=200;

	private int menu3X=300;
    private int menu3Y=300;
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.drawOval(menuX, menuX, 100, 100);
		g.drawOval(menu2X, menu2X, 100, 100);
		g.drawOval(menu3X, menu3X, 100, 100);
		
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
				
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if( ( mouseX >= menuX && mouseX <= menuX + 100) &&
			  ( mouseY >= menuY && mouseY <= menuY + 100) ){
				map = new TiledMap("res/Firstmap.tmx");
				  changeLevel(sbg);				  
			  }else if( ( mouseX >= menu2X && mouseX <= menu2X + 100) &&
			  ( mouseY >= menu2Y && mouseY <= menu2Y + 100) ){
				  map = new TiledMap("res/Secondmap.tmx");
				  changeLevel(sbg);				  
			  } else if( ( mouseX >= menu3X && mouseX <= menu3X + 100) &&
			  ( mouseY >= menu3Y && mouseY <= menu3Y + 100) ){
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
