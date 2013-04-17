package se.chalmers.TowerDefence;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AbstractProjectile {
	private float xPos;
	private float yPos;
	private Image image;
	private Monster monster;
	private float speed=5f;
	public AbstractProjectile(float x, float y, Monster monster) throws SlickException {
		this.xPos = x*40;
		this.yPos = y*40;
		this.monster = monster;
		image = new Image("res/projectile.gif");
	}
	
	public void draw() {
		image.draw(xPos,yPos);
	}
	
	public void move() {
		if(xPos<monster.getX()){
			xPos+=speed;
		}else if(xPos>monster.getX()){
			xPos-=speed;
		}
		if(yPos<monster.getY()){
			yPos+=speed;
		}else if(yPos>monster.getY()){
			yPos-=speed;
		}
	}
	
}
