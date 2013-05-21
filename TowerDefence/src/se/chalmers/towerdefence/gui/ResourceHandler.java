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
	private SpriteSheet towerHandySheet;
	private Animation towerHandyAnim;
	private SpriteSheet antSheet;
	private Animation antAnim;
	private Image apple;
	private Image victory;
	private Animation antFlipAnim;
	private SpriteSheet antFlipSheet;
	private Image defeat;
	private Image healthbar;
	
	private ResourceHandler() {
		try{
			towerSheet = new SpriteSheet("res/TowerSpriteSheet.png", 30, 36);
			towerAnim = new Animation(towerSheet, 250);
			towerHandySheet = new SpriteSheet("res/TowerSpriteHandySheet.png", 25, 42);
			towerHandyAnim = new Animation(towerSheet, 250);
			
			victory= new Image("res/victory.png");
			defeat= new Image("res/defeat.png");
			
			apple = new Image("res/Apple.gif");
			antSheet = new SpriteSheet("res/AntSpriteSheet.png", 32, 28);
			antAnim = new Animation(antSheet, 250);
			antFlipSheet = new SpriteSheet("res/AntSpriteSheetFlip.png", 32, 28);
			antFlipAnim = new Animation(antFlipSheet, 250);
			healthbar = new Image("res/Healthbar.png");
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
	
	public Animation getTowerHandyAnimation(){
		return towerHandyAnim.copy();
	}
	
	public Image getVictoryImage(){
		return victory.copy();
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

	public Image getDefeatImage() {
		return defeat.copy();
	}
	
	public Image getHealthbar(){
		return healthbar.copy();
	}
	
}
