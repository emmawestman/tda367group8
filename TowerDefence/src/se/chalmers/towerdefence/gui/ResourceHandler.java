package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * A class so that resources only have to be read from file one time
 * @author Jonathan
 *
 */

public class ResourceHandler {
	private static ResourceHandler instance;
	private SpriteSheet towerSheet;
	private Animation towerAnim;
	private SpriteSheet antSheet;
	private Animation antAnim;
	private Image apple;
	private Animation antFlipAnim;
	private SpriteSheet antFlipSheet;
	
	private ResourceHandler() {
		try{
			towerSheet = new SpriteSheet("res/TowerSpriteSheet.png", 30, 36);
			towerAnim = new Animation(towerSheet, 250);
			apple = new Image("res/apple.gif");
			antSheet = new SpriteSheet("res/AntSpriteSheet.png", 32, 28);
			antAnim = new Animation(antSheet, 250);
			antFlipSheet = new SpriteSheet("res/AntSpriteSheetFlip.png", 32, 28);
			antFlipAnim = new Animation(antFlipSheet, 250);
		}catch(SlickException e){
			System.out.println(e);
		}
	}
	
	public static ResourceHandler getInstance() {
	      if(instance == null) {
	         instance = new ResourceHandler();
	      }
	      return instance;
	 }
	
	public SpriteSheet getTowerSpriteSheet(){
		return (SpriteSheet) towerSheet.copy();
	}
	
	public Animation getTowerAnimation(){
		return towerAnim.copy();
	}
	
	public Image getAppleImage(){
		return apple.copy();
	}
	public SpriteSheet getAntSpriteSheet(){
		return (SpriteSheet) antSheet.copy();
	}
	
	public Animation getAntAnimation(){
		return antAnim.copy();
	}

	public Animation getAntFlipAnimation() {
		return antFlipAnim.copy();
	}
	
	
}
