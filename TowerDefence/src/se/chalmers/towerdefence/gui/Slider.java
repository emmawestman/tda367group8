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
	private int length;
	private int width;
	private Color color;

	public Slider(int posX,int posY, int length, int width){
		this.posX=posX;
		this.posY=posY;
		this.length=length;
		this.width=width;
	}
	
	public void draw(Graphics g){
		g.drawRect(posX, posY, width, length);
	}
	
	public boolean inSpan(int x,int y){
		if( ( x >= posX && x <= posX + width) &&
				( y >= posY && y <= posY + length) ){
			return true;				  
		}else{
			return false;
		}
		
	}

	public void draw(int posX, int posY, Graphics g) {
		this.posX=posX;
		this.posY=posY;
		draw(g);
	}
	
}
