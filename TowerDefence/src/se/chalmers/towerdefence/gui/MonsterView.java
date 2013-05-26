package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.sound.SoundFX;
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
	private int yOffset;
	private int xOffset;
	private boolean havePlayedDieSound;

	public MonsterView(AbstractMonster abstractMonster, int width, int height){
		this.abstractMonster=abstractMonster;
		anim=ResourceHandler.getInstance().getAntAnimation();
		healthBar = ResourceHandler.getInstance().getHealthbar();
		direction=true;
		ID=abstractMonster.getID();
		rH=ResourceHandler.getInstance();
		havePlayedDieSound=false;
		if(ID == 4){
			this.width = width*4;
			this.height = height*4;
			yOffset = this.height - height;
			xOffset = this.width - width*3;
		}else{
			this.width = width;
			this.height = height;
			yOffset = 0;
			xOffset = 0;
		}
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
				case 4: anim=rH.getGargamelAnimation();
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
				case 4: anim=rH.getGargamelFlipAnimation();
				}

				direction=false;
			}
		}
		if(anim.isStopped()){
			anim.start();	
		}				
		anim.draw(abstractMonster.getX() - xOffset,abstractMonster.getY() - yOffset, width, height);

		healthBar.draw(abstractMonster.getX() - width * 0.1f - xOffset, abstractMonster.getY() - height * 0.2f - yOffset, width * abstractMonster.getPercentageOfHealth()*1.2f, height * 0.3f);

	}

	public AbstractMonster getObject() {
		return abstractMonster;
	}

	public boolean exists() {
		
		if(!abstractMonster.isAlive() && havePlayedDieSound==false){
			try {
				SoundFX sound = SoundFX.getInstance();
				switch (ID) {
				case 1: sound.playAntSound();
				break;
				case 2: sound.playDuckSound();
				break;
				case 3: sound.playScorpionSound();
				break;
				case 4: sound.playGargamelSound();
				}
				havePlayedDieSound=true;
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return abstractMonster.isAlive();
	}

	public void setResolution(int width, int height){
		this.height = height;
		this.width = width;
	}
}