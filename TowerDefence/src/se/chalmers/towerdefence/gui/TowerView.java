package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import se.chalmers.towerdefence.model.towers.AbstractTower;

/**
 * A class with the responsibility to draw a tower
 * @author Jonathan
 *
 */

public class TowerView implements IView{

	
	private Animation anim;
	private AbstractTower tower;
	private int width;
	private int height;
	
	public TowerView(AbstractTower tower, int width, int height){
		this.tower=tower;
		this.width = width;
		this.height = height;
		int ID = tower.getID();
		ResourceHandler rH = ResourceHandler.getInstance();
		switch (ID) {
		case 1: anim=rH.getTowerAnimation();
		break;
		case 2: anim=rH.getTowerHandyAnimation();
		break;
		case 3: anim=rH.getTowerBrainyAnimation();
		break;		
		case 4: anim=rH.getTowerTrowAnimation();
		break;
		case 5: anim=rH.getTowerPapaAnimation();
		break;
		case 6: anim=rH.getTowerSmurfetteAnimation();
		break;
		}
	}
	
	public AbstractTower getTower(){
		return tower;
	}
	
	public void draw() {
		if(tower.isShooting()){
			if(anim.isStopped()){
				anim.start();
				
			}
			anim.setSpeed(tower.getReloadTime()/4);
			anim.draw(tower.getX(),tower.getY(), width, height);
		}else{
			if(!anim.isStopped()){
				anim.stop();
			}
			anim.draw(tower.getX(), tower.getY(), width, height);
		}
	}

	public boolean exists() {
		return tower.exists();
	}
	
	public void setResolution(int width, int height){
		this.height = height;
		this.width = width;
	}
	
	public void drawRange(Graphics g){
		g.setColor(new Color(123, 123, 123, 123));
		g.fillOval(tower.getX()+tower.getWidth()/2-tower.getRange(), tower.getY()+tower.getHeight()/2-tower.getRange(), tower.getRange()*2, tower.getRange()*2);
		g.setColor(new Color(0,0,0));
		g.drawOval(tower.getX()+tower.getWidth()/2-tower.getRange(), tower.getY()+tower.getHeight()/2-tower.getRange(), tower.getRange()*2, tower.getRange()*2);
	}
}