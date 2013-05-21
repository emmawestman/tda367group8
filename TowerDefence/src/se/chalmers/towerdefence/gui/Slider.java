package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * A Class to handle Buttons
 * @author Jonathan
 *
 */

public class Slider {
	private int posX;
	private int posY;
	private int maxLength;
	private int maxWidth;
	private Color color;
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
	
	public void draw(Graphics g){
		ResourceHandler.getInstance().getHealthbar().draw(posX, posY, width, length);
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

	public void draw(int posX, int posY, Graphics g) {
		this.posX=posX;
		this.posY=posY;
		draw(g);
	}
	
}
