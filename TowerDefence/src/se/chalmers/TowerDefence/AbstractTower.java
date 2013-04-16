package se.chalmers.TowerDefence;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AbstractTower {
	private float xPos;
	private float yPos;
	private Image image;

	public AbstractTower(float x, float y) throws SlickException {
		this.xPos = x;
		this.yPos = y;
		image = new Image("res/tower.gif");
	}
	
	public void draw() {
		image.draw(xPos,yPos);
	}

}
