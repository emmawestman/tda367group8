package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

import se.chalmers.towerdefence.model.AbstractMonster;
/**
 * A class with the responsibility to draw a monster
 * @author Jonathan
 *
 */

public class MonsterView implements IView{
	private AbstractMonster abstractMonster;
	private Animation anim;
	private boolean direction;
	private Image healthBar;
	public MonsterView(AbstractMonster abstractMonster){
		this.abstractMonster=abstractMonster;
		anim=ResourceHandler.getInstance().getAntAnimation();
		healthBar = ResourceHandler.getInstance().getHealthbar();
		direction=true;
	}
	
	public void draw(){
		if(abstractMonster.getXDirection()<0){
			if(direction==false){
				anim=ResourceHandler.getInstance().getAntAnimation();
				direction=true;
			}
		}else{
			if(direction==true){
				anim=ResourceHandler.getInstance().getAntFlipAnimation();
				direction=false;
			}
		}
		if(anim.isStopped()){
			anim.start();	
		}				
		anim.draw(abstractMonster.getX(),abstractMonster.getY());
		
		healthBar.draw(abstractMonster.getX() - anim.getWidth() * 0.1f, abstractMonster.getY() - anim.getWidth() * 0.2f, anim.getWidth() * abstractMonster.getPresentegeOfHealth()*1.2f, anim.getWidth() * 0.3f);
			
	}

	public AbstractMonster getMonster() {
		return abstractMonster;
	}

	public boolean exists() {
		return abstractMonster.isAlive();
	}
}