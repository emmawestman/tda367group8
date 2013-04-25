package se.chalmers.slickTD;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//TODO change name
public class Monster2View implements IMonsterView{

	private Image image;
	public Monster2View(){
		try{
			image = new Image("res/tower.gif");
		}catch(SlickException e){
			System.out.println(e);
		}
	}
	
	public void draw(float x,float y){
		image.draw(x,y);	
	}
}