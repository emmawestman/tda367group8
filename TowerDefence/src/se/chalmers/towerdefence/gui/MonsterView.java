package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MonsterView{

	private Image image;
	public MonsterView(){

	}
	
	public void draw(float x,float y,int ID){
		try{
			if(ID==1){
				image = new Image("res/monster.gif");
			}else if(ID==2){
				image = new Image("res/tower.gif");
			}
		}catch(SlickException e){
			System.out.println(e);
		}		
		image.draw(x,y);	
	}
}