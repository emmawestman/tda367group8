package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TowerView {

	private Image image;
	public TowerView(){
		try{
			image = new Image("res/tower.gif");
		}catch(SlickException e){
			System.out.println(e);
		}
	}
	
	public void draw(float x,float y) {
		image.draw(x,y);
	}
	
}