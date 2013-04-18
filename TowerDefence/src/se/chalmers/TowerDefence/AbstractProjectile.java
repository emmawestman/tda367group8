package se.chalmers.TowerDefence;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AbstractProjectile {
	private float xPos;
	private float yPos;
	private Image image;
	private AbstractMonster monster;
	private float speed=5f;
	private int damage = 5;
	private boolean exists = true;
	public AbstractProjectile(float x, float y, AbstractMonster monster) throws SlickException {
		this.xPos = x;
		this.yPos = y;
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
		if(xPos==monster.getX() && yPos==monster.getY()){
			damage();
			exists = false;
		}
	}

	public void damage(){
		monster.hurt(damage);
	}
	
	public boolean exists(){
		return exists;
	}
	
	
}
