package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * A class so that resources only have to be read from file one time
 * @author Jonathan, Julia, Emma, Oskar
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
	private Image lore;
	private Image instructions;
	private Image resume;
	private Image mainMenu;
	private Image continueImage;
	private Image restart;
	private Image exitLevel;
	private Image musicOff;
	private Image musicOn;
	private Image pause;
	private Image startScreen;
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
	private Image upgradeDisabled;
	private Image gameOverScreen;
	private Image pausScreen;
	private SpriteSheet towerTrowSheet;
	private Animation towerTrowAnim;
	private Image backgroundLevelSelection;
	private SpriteSheet towerPapaSheet;
	private Animation towerPapaAnim;
	private SpriteSheet towerBrainySheet;
	private Animation towerBrainyAnim;
	private SpriteSheet towerSmurfetteSheet;
	private Animation towerSmurfetteAnim;
	private Image appleTowerBall;
	private Image bombTowerBall;
	private Image laserTowerBall;
	private Image flameTowerBall;
	private Image iceTowerBall;
	private Image poisonTowerBall;
	private Image appleTowerBallDisabled;
	private Image bombTowerBallDisabled;
	private Image laserTowerBallDisabled;
	private Image flameTowerBallDisabled;
	private Image iceTowerBallDisabled;
	private Image poisonTowerBallDisabled;
	private Image startWave;
	private Image laser;
	private Image fire;
	private Image poison;
	private Image snowball;
	private Image backBall;
	
	private ResourceHandler() {
		try{
			towerSheet = new SpriteSheet("res/TowerSpriteSheet.png", 30, 36);
			towerAnim = new Animation(towerSheet, 250);
			towerHandySheet = new SpriteSheet("res/TowerSpriteHandySheet.png", 40, 42);
			towerHandyAnim = new Animation(towerHandySheet, 250);
			towerTrowSheet = new SpriteSheet("res/TowerSpriteTrowSheet.png", 40, 49);
			towerTrowAnim = new Animation(towerTrowSheet, 250);
			
			towerPapaSheet = new SpriteSheet("res/TowerSpritePapaSheet.png", 37, 49);
			towerPapaAnim = new Animation(towerPapaSheet, 250);
			towerBrainySheet = new SpriteSheet("res/TowerSpriteBrainySheet.png", 55, 53);
			towerBrainyAnim = new Animation(towerBrainySheet, 250);
			towerSmurfetteSheet = new SpriteSheet("res/TowerSpriteSmurfetteSheet.png", 39, 53);
			towerSmurfetteAnim = new Animation(towerSmurfetteSheet, 250);
			
			startScreen = new Image("res/startscreen.png");
			
			victory= new Image("res/victory.png");
			defeat= new Image("res/defeat.png");
			gameOverScreen = new Image("res/GameOverScreen.gif");
			pausScreen = new Image("res/PausScreen.png");
			
			acorn = new Image("res/Acorn.png");
			apple = new Image("res/Apple.gif");
			laser = new Image("res/LaserProjectile.png");
			fire = new Image("res/fire.png");
			snowball = new Image("res/snowball.png");
			poison = new Image("res/poison.png");
			
			sell = new Image("res/sell.gif");
			upgrade = new Image("res/upgrade.gif");
			upgradeDisabled = new Image("res/upgradeDisabled.gif");
			
			appleTowerBall = new Image("res/AppleTowerBall.gif");
			bombTowerBall = new Image("res/BombTowerBall.gif");
			
			laserTowerBall = new Image("res/LaserTowerBall.gif");
			flameTowerBall = new Image("res/FlameTowerBall.gif");
			
			iceTowerBall = new Image("res/IceTowerBall.gif");
			poisonTowerBall = new Image("res/PoisonTowerBall.gif");
			
			appleTowerBallDisabled = new Image("res/AppleTowerBallDisabled.gif");
			bombTowerBallDisabled = new Image("res/BombTowerBallDisabled.gif");
			
			laserTowerBallDisabled = new Image("res/LaserTowerBallDisabled.gif");
			flameTowerBallDisabled = new Image("res/FlameTowerBallDisabled.gif");
			
			iceTowerBallDisabled = new Image("res/IceTowerBallDisabled.gif");
			poisonTowerBallDisabled = new Image("res/PoisonTowerBallDisabled.gif");
			
			
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
			startWave = new Image("res/startWave.gif");
			
			options= new Image("res/options.png");
			start= new Image("res/start.png");
			lore = new Image("res/lore.png");
			instructions = new Image("res/instructions.png");
			mainMenu = new Image("res/mainmenu.png");
			restart = new Image("res/restart.png");
			resume = new Image("res/resume.png");
			exitLevel = new Image("res/exitlevel.png");
			continueImage = new Image("res/continue.png");

			ball= new Image("res/ball.gif");
			sign = new Image("res/sign.png");
			
			backBall = new Image("res/backBall.gif");

			
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
	
	public Animation getTowerBrainyAnimation(){
		return towerBrainyAnim.copy();
	}
	
	public Animation getTowerPapaAnimation(){
		return towerPapaAnim.copy();
	}
	
	public Animation getTowerSmurfetteAnimation(){
		return towerSmurfetteAnim.copy();
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
		return backgroundLevelSelection.copy();
	}
	public Image getGameOverScreen(){
		return gameOverScreen.copy();
	}
	public Image getOptionsImage(){
		return options.copy();
	}
	
	public Image getStartImage(){
		return start.copy();
	}
	
	public Image getLoreImage() {
		return lore.copy();
	}
	
	public Image getInstructionsImage() {
		return instructions.copy();
	}
	
	public Image getMusicONImage(){
		return musicOn.copy();
	}
	
	public Image getMusicOffImage(){
		return musicOff.copy();
	}
	
	public Image getStartScreen(){
		return startScreen.copy();
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
	
	public Image getUpgradeDisabledImage() {
		return upgradeDisabled.copy();
	}

	public Image getFlameTowerBallImage(){
		return flameTowerBall.copy();
	}
	
	public Image getIceTowerBallImage(){
		return iceTowerBall.copy();
	}	
	
	public Image getLaserTowerBallImage(){
		return laserTowerBall.copy();
	}
	
	public Image getAppleTowerBallImage(){
		return appleTowerBall.copy();
	}
	
	public Image getBombTowerBallImage(){
		return bombTowerBall.copy();
	}
	
	public Image getPoisonTowerBallImage(){
		return poisonTowerBall.copy();
	}

	public Image getFlameTowerBallDisabledImage(){
		return flameTowerBallDisabled.copy();
	}
	
	public Image getIceTowerBallDisabledImage(){
		return iceTowerBallDisabled.copy();
	}	
	
	public Image getLaserTowerBallDisabledImage(){
		return laserTowerBallDisabled.copy();
	}
	
	public Image getAppleTowerBallDisabledImage(){
		return appleTowerBallDisabled.copy();
	}
	
	public Image getBombTowerBallDisabledImage(){
		return bombTowerBallDisabled.copy();
	}
	
	public Image getPoisonTowerBallDisabledImage(){
		return poisonTowerBallDisabled.copy();
	}
	public Image getStartWaveImage(){
		return startWave.copy();
	}
	
	public Image getLaserProjectile() {
		return laser.copy();
	}
	
	public Image getFire() {
		return fire.copy();
	}
	
	public Image getSnowball() {
		return snowball.copy();
	}
	
	public Image getPoison(){
		return poison.copy();
	}	
	
	public Image getBackBall() {
		return backBall.copy();
	}
	
	public Image getPausScreen(){
		return pausScreen.copy();
	}
	
	public Image getMainMenuImage() {
		return mainMenu.copy();
	}
	
	public Image getRestartImage() {
		return restart.copy();
	}

	public Image getResumeImage() {
		return resume.copy();
	}
	
	public Image getExitLevelImage() {
		return exitLevel.copy();
	}
	
	public Image getContinueImage() {
		return continueImage.copy();
	}
}
