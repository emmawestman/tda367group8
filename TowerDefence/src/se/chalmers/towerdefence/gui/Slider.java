package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Color;

/**
 * A Class to handle the sound sliders
 * @author Jonathan, Oskar, Julia, Emma
 *
 */

public class Slider {
	private int posX;
	private int posY;
	private int maxLength;
	private int maxWidth;
	private int length;
	private float width;

	public Slider(int posX,int posY, int maxLength, int maxWidth){
		this.posX=posX;
		this.posY=posY;
		this.maxLength=maxLength;
		this.maxWidth=maxWidth;
		length=maxLength;
		width=maxWidth;
	}
	
	public void draw(){
		ResourceHandler.getInstance().getPalleteImage().draw(posX, posY, width, length,Color.red);
	}
	
	public boolean inSpan(int x,int y){
		if( ( x >= posX && x <= posX + maxWidth) &&
				( y >= posY && y <= posY + maxLength) ){
			width=x-posX;
			return true;				  
		}else{
			return false;
		}
		
	}
	
	public float changeSlider(int x){
			width=x-posX;
			return width/maxWidth;				  
	}

	public void draw(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		draw();
	}
	
}
