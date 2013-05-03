package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MonsterView{

	private Animation image;
	public MonsterView(){
		image=ResourceHandler.getInstance().getAntAnimation();
	}
	
	public void draw(float x,float y,int ID){
		if(image.isStopped()){
			image.start();	
		}				
		image.draw(x,y);	
	}
}