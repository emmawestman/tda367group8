package se.chalmers.TowerDefence;

import se.chalmers.slickTD.ProjectileView;



public class AbstractProjectile {
	private float xPos;
	private float yPos;
	private float width;
	private ProjectileView pV;
	private AbstractMonster monster;
	private float speed = 2.5f;
	private int damage = 5;
	private boolean exists = true;
	private double angleX, angleY;
	public AbstractProjectile(float x, float y, AbstractMonster monster) {
		this.xPos = x + 20 + width;
		this.yPos = y + 20 + width;
		this.monster = monster;
		pV=new ProjectileView();
		width = 5;
	}
	
	public void draw() {
		pV.draw(xPos, yPos);
	}
	
	public void move() {
		if(!monster.isAlive()){
			exists = false;
		}
		double devider = 1/Math.sqrt(Math.pow(monster.getX() + 20 - width - xPos,2) + Math.pow(monster.getY() + 20 - width - yPos, 2));
		this.angleX =  devider * (monster.getX() + 20 - width - xPos);
		this.angleY =  devider * (monster.getY() + 20 - width - yPos);
		xPos += angleX * speed;
		yPos += angleY * speed;
		
		if(xPos>=monster.getX()+10-width && yPos>=monster.getY()+10-width && xPos<=monster.getX()+30-width && yPos<=monster.getY()+30-width){
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
