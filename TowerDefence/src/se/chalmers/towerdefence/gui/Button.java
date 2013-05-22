package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

/**
 * A Class to handle Buttons
 * @author Jonathan
 *
 */

public class Button {
	protected Image image;
	protected int posX;
	protected int posY;
	protected int height;
	protected int width;
	
	public Button(Image image, int posX, int posY){
		this.image = image;
		
		this.posX = posX;
		this.posY = posY;
		this.height = 50;
		this.width = 50;
	}
	
	public Button(Image image,int posX,int posY, int width, int height){
		this(image, posX, posY);
	
		this.height = height;
		this.width = width;
	}
	
	public void setImage(Image image){
		this.image=image;
	}
	
	public void draw(){
		image.draw(posX, posY, width, height);
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
	
	public void setResulution(int width, int height){
		this.height = height;
		this.width = width;
	}
	
}
