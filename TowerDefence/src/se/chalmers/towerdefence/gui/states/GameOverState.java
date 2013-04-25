package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.model.Player;

public class GameOverState extends BasicGameState{
	private static final int ID = 2;
	private StateController stateController;
	private Player player;
	private String stringCondition;
	
	public int getID() {
	  return ID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.drawString(stringCondition, 350, 350);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	
	}
	
	public void enter(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		stateController=StateController.getInstance();
		player=stateController.getPlayer();
		if(player.getLives()==0){
			stringCondition="DEFEAT";
		}else{
			stringCondition="VICTORY";			
		}
	}
	  
}