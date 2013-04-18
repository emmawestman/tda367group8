package se.chalmers.slickTD;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MonsterView {

	private Image image;
	public MonsterView(){
		try{
			image = new Image("res/monster.gif");
		}catch(SlickException e){
			System.out.println(e);
		}
	}
	
	public void draw(int x,int y){
		image.draw(x,y);	
	}
}
