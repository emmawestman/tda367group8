package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;

import se.chalmers.towerdefence.model.AbstractTower;

/**
 * A class with the responsibility to draw a tower
 * @author Jonathan
 *
 */

public class TowerView implements IView{

	
	private Animation anim;
	private AbstractTower tower;
	
	public TowerView(AbstractTower tower){
		this.tower=tower;
		int ID = tower.getID();
		ResourceHandler rH = ResourceHandler.getInstance();
		switch (ID) {
		case 1: anim=rH.getTowerAnimation();
		break;
		case 2: anim=rH.getTowerHandyAnimation();
		break;
		case 3: anim=rH.getTowerTrowAnimation();
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
			anim.draw(tower.getX(),tower.getY());
		}else{
			if(!anim.isStopped()){
				anim.stop();
			}
			anim.draw(tower.getX(), tower.getY());
		}
	}

	public boolean exists() {
		return tower.exists();
	}
	
}