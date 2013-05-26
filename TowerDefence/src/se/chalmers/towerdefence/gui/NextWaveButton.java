package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

import se.chalmers.towerdefence.model.ISquare;

public class NextWaveButton extends Button{

	public NextWaveButton(Image image, int width, int height){
		super(image, 0, 0, width, height);
	}
	
	public void setNewPosition(ISquare Square){
		this.posX = Square.getX() + Square.getWidth()+10;
		this.posY = Square.getY();
	}
}
