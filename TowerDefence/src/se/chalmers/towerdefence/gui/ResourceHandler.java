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
	private Image acorn;
	private Image victory;
	private Animation antFlipAnim;
	private SpriteSheet antFlipSheet;
	private Image defeat;
	private Image healthbar;
	private Image start;
	private Image options;
	private Image musicOff;
	private Image musicOn;
	private Image pause;
	private Image splash;
	private Animation scorpAnim;
	private SpriteSheet scorpSheet;
	private Animation scorpFlipAnim;
	private SpriteSheet scorpFlipSheet;
	private Animation birdAnim;
	private SpriteSheet birdSheet;
	private Animation birdFlipAnim;
	private SpriteSheet birdFlipSheet;
	private Image ball;
	private Image sign;
	private Image sell;
	private Image upgrade;
	private Image gameOverScreen;
	private SpriteSheet towerTrowSheet;
	private Animation towerTrowAnim;
	private Image backgroundLevelSelection;
	
	private ResourceHandler() {
		try{
			towerSheet = new SpriteSheet("res/TowerSpriteSheet.png", 30, 36);
			towerAnim = new Animation(towerSheet, 250);
			towerHandySheet = new SpriteSheet("res/TowerSpriteHandySheet.png", 25, 42);
			towerHandyAnim = new Animation(towerHandySheet, 250);
			towerTrowSheet = new SpriteSheet("res/TowerSpriteTrowSheet.png", 40, 49);
			towerTrowAnim = new Animation(towerTrowSheet, 250);
			
			splash = new Image("res/splash.gif");
			
			victory= new Image("res/victory.png");
			defeat= new Image("res/defeat.png");
			gameOverScreen = new Image("res/GameOverScreen.gif");
			
			acorn = new Image("res/Acorn.png");
			apple = new Image("res/Apple.gif");
			
			sell = new Image("res/sell.gif");
			upgrade = new Image("res/upgrade.gif");
			
			antSheet = new SpriteSheet("res/AntSpriteSheet.png", 32, 28);
			antAnim = new Animation(antSheet, 250);
			antFlipSheet = new SpriteSheet("res/AntSpriteSheetFlip.png", 32, 28);
			antFlipAnim = new Animation(antFlipSheet, 250);
			healthbar = new Image("res/Healthbar.png");
			
			birdFlipSheet = new SpriteSheet("res/BirdSpriteSheet.png", 31, 36);
			birdFlipAnim = new Animation(birdFlipSheet, 150);
				
			backgroundLevelSelection = new Image("res/LevelSelection.png");
			birdSheet = new SpriteSheet("res/BirdSpriteSheetFlip.png", 31, 36);
			birdAnim = new Animation(birdSheet, 150);
						
			scorpFlipSheet = new SpriteSheet("res/ScorpSpriteSheet.png", 40, 32);
			scorpFlipAnim = new Animation(scorpFlipSheet, 250);
					
			scorpSheet = new SpriteSheet("res/ScorpSpriteSheetFlip.png", 40, 32);
			scorpAnim = new Animation(scorpSheet, 250);

			pause = new Image("res/pauseBall.gif");
			musicOn= new Image("res/speakerBall.gif");
			musicOff= new Image("res/speakerOffBall.gif");
			
			options= new Image("res/options.gif");
			start= new Image("res/start.gif");

			ball= new Image("res/ball.gif");
			sign = new Image("res/sign.png");
			
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
	
	public Animation getTowerTrowAnimation(){
		return towerTrowAnim.copy();
	}
	
	public Image getVictoryImage(){
		return victory.copy();
	}
	
	public Image getPauseImage(){
		return pause.copy();
	}
	
	public Image getBackgroundLevelSelection(){
		return backgroundLevelSelection;
	}
	public Image getOptionsImage(){
		return options.copy();
	}
	
	public Image getStartImage(){
		return start.copy();
	}
	
	public Image getMusicONImage(){
		return musicOn.copy();
	}
	
	public Image getMusicOffImage(){
		return musicOff.copy();
	}
	
	public Image getSplash(){
		return splash.copy();
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
	
	public Image getAcorn(){
		return acorn.copy();
	}
	
	public Image getSign(){
		return sign.copy();
	}
	
	public Animation getBirdAnimation(){
			return birdAnim.copy();
	}
	public Animation getBirdFlipAnimation() {
		return birdFlipAnim.copy();
	}
	
	public Animation getScorpAnimation(){
		return scorpAnim.copy();
	}
	
	public Animation getScorpFlipAnimation() {
		return scorpFlipAnim.copy();
	}

	public Image getBallImage() {
		return ball.copy();
	}
	
	public Image getSellImage(){
		return sell.copy();
	}
	public Image getUpgradeImage(){
		return upgrade.copy();
	}

	public Image getGameOverScreen(){
		return gameOverScreen;
	}
	
}
