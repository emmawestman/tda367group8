package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.model.Level;
import se.chalmers.towerdefence.model.Player;

public class GameOverState extends BasicGameState{
	private static final int ID = 3;
	private StateController stateController;
	private Player player;
	private String stringCondition;
	private Level level;
	private Image start;
	private Image gameOverScreen;
	private int menuX=100;
    private int menuY=100;
	
	public int getID() {
	  return ID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		start= new Image("res/start.gif");
		gameOverScreen= new Image("res/GameOverScreen.gif");
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		gameOverScreen.draw(0, 0);
		g.drawString(stringCondition, 350, 200);
		start.draw(menuX,menuY);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sgb, int arg2) throws SlickException {

		Input input = gc.getInput();
		

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
				
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if( ( mouseX >= menuX && mouseX <= menuX + start.getWidth()) &&
			  ( mouseY >= menuY && mouseY <= menuY + start.getHeight()) ){
				  sgb.enterState(4);				  
			  }
		}
	}
	
	public void enter(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		stateController=StateController.getInstance();
		level=stateController.getLevel();
		player=level.getPlayer();
		
		if(player.getLives()==0){
			stringCondition="DEFEAT";
		}else{
			stringCondition="VICTORY";			
		}
	}
	  
}