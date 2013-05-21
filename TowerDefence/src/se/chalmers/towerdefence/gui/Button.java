package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

/**
 * A Class to handle Buttons
 * @author Jonathan
 *
 */

public class Button {
	private Image image;
	private int posX;
	private int posY;

	public Button(Image image,int posX,int posY){
		this.image=image;
		this.posX=posX;
		this.posY=posY;
	}
	
	public void setImage(Image image){
		this.image=image;
	}
	
	public void draw(){
		image.draw(posX, posY);
	}
	
	public boolean inSpan(int x,int y){
		if( ( x >= posX && x <= posX + image.getWidth()) &&
				( y >= posY && y <= posY + image.getHeight()) ){
			return true;				  
		}else{
			return false;
		}
		
	}

	public void draw(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		draw();
	}
	
}
