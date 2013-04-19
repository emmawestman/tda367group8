package se.chalmers.slickTD;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.TowerDefence.Level;

public class TD extends BasicGame {
	  Level level;
	  Image ball;
	  int menuX=100;
	  int menuY=100;
	  TiledMap map;
	  GameBoardController gbc;
	  
	  public TD(){
	     super("Tower Defence");
	  }
	 
	  @Override
	  public void init(GameContainer gc) throws SlickException{
		  ball= new Image("res/ball.gif");
		  map = new TiledMap("res/Thirdmap.tmx");
		  gbc=new GameBoardController(map);
		level=new Level(gbc, "level1");
		  
	  }
	 
	  @Override
	  public void update(GameContainer gc, int delta) throws SlickException{
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
	  public void render(GameContainer gc, Graphics g) throws SlickException{
		map.render(0, 0); 
		ball.draw(menuX, menuY);
		level.draw();
		g.drawString(level.getPlayer().toString(), 0, 30);
	  }
	 
	  public static void main(String[] args) throws SlickException{
	     AppGameContainer app = new AppGameContainer(new TD());
	     app.setTargetFrameRate(120);
	     app.setDisplayMode(800, 600, false);
	     app.start();
	  }
	  
	  private void startWave(){
		  level.startWave();
	  }

}