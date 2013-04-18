package se.chalmers.slickTD;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ProjectileView {
	private Image image;
	public ProjectileView(){
		try{
			image = new Image("res/projectile.gif");
		}catch(SlickException e){
			System.out.println(e);
		}
	}
	
	public void draw(float x,float y){
		image.draw(x,y);	
	}
}
