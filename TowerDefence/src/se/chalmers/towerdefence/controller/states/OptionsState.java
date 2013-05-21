package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.gui.Slider;

public class OptionsState extends BasicGameState {
	private static final int ID = 5;
	Slider s;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
			s=new Slider(100,100,100,100);	
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
			s.draw(g);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}

	
	
	
}
