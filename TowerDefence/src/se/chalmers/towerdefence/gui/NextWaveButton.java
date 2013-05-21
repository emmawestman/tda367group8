package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

import se.chalmers.towerdefence.model.ISquare;

public class NextWaveButton {

	private Image image;
	private int x, y;

	public NextWaveButton(Image image){
		this.image = image;
		this.x = 0;
		this.y = 0;
	}
	

	public void draw() {
		image.draw(x, y);
	}
	
	public boolean inSpan(int x,int y){
		if( ( x >= this.x && x <= this.x + image.getWidth()) &&
				( y >= this.y && y <= this.y + image.getHeight()) ){
			return true;				  
		}else{
			return false;
		}
	}
	
	public void setNewPosition(ISquare Square){
		this.x = Square.getX() + Square.getWidth();
		this.y = Square.getY();
	}
}
