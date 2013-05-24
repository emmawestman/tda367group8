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
	private ResourceHandler rH;
	private final int ID;
	private int width;
	private int height;
	
	public MonsterView(AbstractMonster abstractMonster, int width, int height){
		this.abstractMonster=abstractMonster;
		anim=ResourceHandler.getInstance().getAntAnimation();
		healthBar = ResourceHandler.getInstance().getHealthbar();
		direction=true;
		ID=abstractMonster.getID();
		rH=ResourceHandler.getInstance();
		this.width = width;
		this.height = height;
	}
	
	public void draw(){
		if(abstractMonster.getXDirection()<0){
			if(direction==false){
				switch (ID) {
				case 1: anim=rH.getAntAnimation();
				break;
				case 2: anim=rH.getBirdAnimation();
				break;
				case 3: anim=rH.getScorpAnimation();
				break;				
				}

				direction=true;
			}
		}else{
			if(direction==true){
				switch (ID) {
				case 1: anim=rH.getAntFlipAnimation();
				break;
				case 2: anim=rH.getBirdFlipAnimation();
				break;
				case 3: anim=rH.getScorpFlipAnimation();
				break;
				}

				direction=false;
			}
		}
		if(anim.isStopped()){
			anim.start();	
		}				
		anim.draw(abstractMonster.getX(),abstractMonster.getY(), width, height);
		
		healthBar.draw(abstractMonster.getX() - anim.getWidth() * 0.1f, abstractMonster.getY() - anim.getWidth() * 0.2f, anim.getWidth() * abstractMonster.getPercentageOfHealth()*1.2f, anim.getWidth() * 0.3f);
			
	}

	public AbstractMonster getMonster() {
		return abstractMonster;
	}

	public boolean exists() {
		return abstractMonster.isAlive();
	}
	
	public void setResolution(int width, int height){
		this.height = height;
		this.width = width;
	}
}