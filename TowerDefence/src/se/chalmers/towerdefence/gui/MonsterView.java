package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;

import se.chalmers.towerdefence.model.AbstractMonster;


public class MonsterView{
	private AbstractMonster abstractMonster;
	private Animation anim;
	private boolean direction;
	public MonsterView(AbstractMonster abstractMonster){
		this.abstractMonster=abstractMonster;
		anim=ResourceHandler.getInstance().getAntAnimation();
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
	}

	public AbstractMonster getMonster() {
		return abstractMonster;
	}

	public boolean exists() {
		return abstractMonster.isAlive();
	}
}