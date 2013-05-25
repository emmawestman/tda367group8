package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

public class TowerButton extends Button {
	private Image disabledImage;
	private Image normalImage;

	public TowerButton(Image normalImage, int posX, int posY, Image disabledImage) {
		super(normalImage, posX, posY);
		this.disabledImage = disabledImage;
		this.normalImage = normalImage;
	}
	
	public TowerButton(Image normalImage,int posX,int posY, int width, int height, Image disabledImage) {
		super(normalImage, posX, posY, width, height);
		this.disabledImage = disabledImage;
		this.normalImage = normalImage;
	}

	public void canAfford(boolean canAfford) {
		if(canAfford) {
			setImage(normalImage);
		}else{
			setImage(disabledImage);
		}
	}
}
