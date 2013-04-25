package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.gui.GameBoardController;
import temp.Level;

public class GamePlayState extends BasicGameState {
	  private Level level;
	  private Image ball;
	  private int menuX=100;
	  private int menuY=100;
	  private TiledMap map;
	  private GameBoardController gbc;
	  private final int ID=1;

	  
	  private void startWave(){
		  level.startWave();
	  }

	@Override
	public void init(GameContainer arg0, StateBasedGame sbg)
			throws SlickException {
		 ball= new Image("res/ball.gif");
		 map = new TiledMap("res/Thirdmap.tmx");
		 gbc=new GameBoardController(map);
		level=new Level(gbc);
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		map.render(0, 0); 
		ball.draw(menuX, menuY);
		level.draw();
		g.drawString(level.getPlayer().toString(), 0, 30);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		  
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		  
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if( ( mouseX >= menuX && mouseX <= menuX + ball.getWidth()) &&
			  ( mouseY >= menuY && mouseY <= menuY + ball.getHeight()) ){
				  startWave();				  
			  }else{
				  level.buildTower(mouseX,mouseY);
			  }
			  
		 }
		 level.update();		
	}

	@Override
	public int getID() {
		return ID;
	}

}