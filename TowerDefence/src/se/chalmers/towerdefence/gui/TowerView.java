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
		anim=ResourceHandler.getInstance().getTowerAnimation();
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