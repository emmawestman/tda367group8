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
	private Animation towerAnim;
	private Animation towerHandyAnim;
	private Animation antAnim;
	private Image apple;
	private Image acorn;
	private Image victory;
	private Animation antFlipAnim;
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
	private Animation scorpFlipAnim;
	private Animation birdAnim;
	private Animation birdFlipAnim;
	private Image ball;
	private Image sign;
	private Image sell;
	private Image upgrade;
	private Image upgradeDisabled;
	private Image gameOverScreen;
	private Image pausScreen;
	private Animation towerTrowAnim;
	private Image backgroundLevelSelection;
	private Animation towerPapaAnim;
	private Animation towerBrainyAnim;
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
	private Image back;
	private Image bannerHighScore;
	private Image play;
	private Image up;
	private Image down;
	private Image startOver;
	private Image pallete;
	private Animation gargamelAnim;
	private Animation gargamelFlipAnim;
	
	private ResourceHandler() {
		try{
			towerAnim = new Animation(new SpriteSheet("res/TowerSpriteSheet.png", 30, 36), 250);
			towerHandyAnim = new Animation(new SpriteSheet("res/TowerSpriteHandySheet.png", 40, 42), 250);
			towerTrowAnim = new Animation(new SpriteSheet("res/TowerSpriteTrowSheet.png", 40, 49), 250);
			towerPapaAnim = new Animation(new SpriteSheet("res/TowerSpritePapaSheet.png", 37, 49), 250);
			towerBrainyAnim = new Animation(new SpriteSheet("res/TowerSpriteBrainySheet.png", 55, 53), 250);
			towerSmurfetteAnim = new Animation(new SpriteSheet("res/TowerSpriteSmurfetteSheet.png", 39, 53), 250);
			
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
			
			sell = new Image("res/sell.png");
			upgrade = new Image("res/upgrade.png");
			upgradeDisabled = new Image("res/upgradeDisabled.png");
			
			appleTowerBall = new Image("res/appletower.png");
			bombTowerBall = new Image("res/bombtower.png");
			
			laserTowerBall = new Image("res/lasertower.png");
			flameTowerBall = new Image("res/flametower.png");
			
			iceTowerBall = new Image("res/icetower.png");
			poisonTowerBall = new Image("res/poisontower.png");
			
			appleTowerBallDisabled = new Image("res/appletowerdisabled.png");
			bombTowerBallDisabled = new Image("res/bombtowerdisabled.png");
			
			laserTowerBallDisabled = new Image("res/lasertowerdisabled.png");
			flameTowerBallDisabled = new Image("res/flametowerdisabled.png");
			
			iceTowerBallDisabled = new Image("res/icetowerdisabled.png");
			poisonTowerBallDisabled = new Image("res/poisontowerdisabled.png");
			
			antAnim = new Animation(new SpriteSheet("res/AntSpriteSheet.png", 32, 28), 250);
			antFlipAnim = new Animation(new SpriteSheet("res/AntSpriteSheetFlip.png", 32, 28), 250);
			healthbar = new Image("res/Healthbar.png");
			
			birdFlipAnim = new Animation(new SpriteSheet("res/BirdSpriteSheet.png", 31, 36), 150);
				
			backgroundLevelSelection = new Image("res/LevelSelection.png");

			birdAnim = new Animation(new SpriteSheet("res/BirdSpriteSheetFlip.png", 31, 36), 150);
			
			scorpFlipAnim = new Animation(new SpriteSheet("res/ScorpSpriteSheet.png", 40, 32), 250);
			scorpAnim = new Animation(new SpriteSheet("res/ScorpSpriteSheetFlip.png", 40, 32), 250);
			
			gargamelAnim = new Animation(new SpriteSheet("res/gargamelSpriteSheetFlip.png", 138, 129), 350);
			gargamelFlipAnim = new Animation(new SpriteSheet("res/gargamelSpriteSheet.png", 138, 129), 350);
			
			play = new Image("res/play.png");
			pause = new Image("res/pause.png");
			musicOn= new Image("res/soundon.png");
			musicOff= new Image("res/soundoff.png");
			startWave = new Image("res/startWave.png");
			
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
			
			back = new Image("res/back.png");
			bannerHighScore = new Image("res/bannerHighScore.png");
			
			up = new Image("res/up.png");
			down = new Image("res/down.png");
			startOver = new Image("res/startover.png");

			pallete=new Image("res/pallete.gif");
			
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
	
	public Image getBackImage() {
		return back.copy();
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
	
	public Image getBannerHighScore() {
		return bannerHighScore.copy();
	}
	
	public Image getPlayImage() {
		return play.copy();
	}
	
	public Image getUpImage() {
		return up.copy();
	}
	
	public Image getDownImage() {
		return down.copy();
	}
	
	public Image getStartOverImage() {
		return startOver.copy();
	}

	public Image getPalleteImage() {
		return pallete.copy();
	}
	
	public Animation getGargamelAnimation() {
		return gargamelAnim.copy();
	}
	
	public Animation getGargamelFlipAnimation(){
		return gargamelFlipAnim.copy();
	}
}
