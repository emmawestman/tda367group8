package se.chalmers.towerdefence.controller.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.towerdefence.files.FileHandler;
import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.gui.ResourceHandler;

public class LoreState extends BasicGameState {
	private static final int ID = 6;
	

	private Button backButton;
	private String lore;

	private FileHandler fileHandler;


	private Button downButton;
	private Button upButton;


	private int yOffset;	
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1)
			throws SlickException {
			ResourceHandler rH = ResourceHandler.getInstance();
			backButton=new Button(rH.getBackImage(),0,0, 50, 50);
			upButton=new Button(rH.getUpImage(),gc.getWidth(),0, 50, 50);
			downButton=new Button(rH.getDownImage(),gc.getWidth(),gc.getHeight(), 50, 50);
			
			upButton.setPosition(upButton.getX()-upButton.getWidth(),upButton.getY());
			downButton.setPosition(downButton.getX()-upButton.getWidth(),downButton.getY()-upButton.getHeight());
			backButton.setPosition(backButton.getX(),backButton.getY());
			
			fileHandler = new FileHandler();
			lore = fileHandler.readFromFile("Lore.txt");
			yOffset=0;			
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.setColor(Color.black);
		g.setBackground(Color.cyan);
		backButton.draw();
		upButton.draw();
		downButton.draw();
		g.drawString(lore, 0, backButton.getHeight()+yOffset);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		
		
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(backButton.inSpan(mouseX, mouseY)){
				sbg.enterState(1);
			}else if(upButton.inSpan(mouseX, mouseY)){
				yOffset+=100;
			}else if(downButton.inSpan(mouseX, mouseY)){
				yOffset-=100;
			}
		}		
	}


	@Override
	public int getID() {
		return ID;
	}	
	
}
