package se.chalmers.TowerDefence;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class TD extends BasicGame {
	  Level level;
	  Image ball;
	  int menuX=100;
	  int menuY=100;
	  
	  public TD(){
	     super("Tower Defence");
	  }
	 
	  @Override
	  public void init(GameContainer gc) throws SlickException{
		  level=new Level();
		  ball= new Image("res/ball.gif");
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
			  }
		  }
		
		  
		  level.update();
	  }
	 
	  @Override
	  public void render(GameContainer gc, Graphics g) throws SlickException{
		 ball.draw(menuX, menuY);
	  }
	 
	  public static void main(String[] args) throws SlickException{
	     AppGameContainer app = new AppGameContainer(new TD());
	 
	     app.setDisplayMode(800, 600, false);
	     app.start();
	  }
	  
	  private void startWave(){
		  level.startWave();
	  }

}
