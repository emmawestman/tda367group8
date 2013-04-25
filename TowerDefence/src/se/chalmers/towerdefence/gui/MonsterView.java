package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MonsterView implements IMonsterView {

	private Image image;
	public MonsterView(){
		try{
			image = new Image("res/monster.gif");
		}catch(SlickException e){
			System.out.println(e);
		}
	}
	
	public void draw(float x,float y){
		image.draw(x,y);	
	}
}