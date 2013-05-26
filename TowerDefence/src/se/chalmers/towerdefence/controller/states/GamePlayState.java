package se.chalmers.towerdefence.controller.states;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.controller.GameBoardUtil;
import se.chalmers.towerdefence.controller.LevelController;
import se.chalmers.towerdefence.controller.WaveSplitController;
import se.chalmers.towerdefence.files.FileHandler;
import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.gui.MonsterView;
import se.chalmers.towerdefence.gui.NextWaveButton;
import se.chalmers.towerdefence.gui.ProjectileView;
import se.chalmers.towerdefence.gui.ResourceHandler;
import se.chalmers.towerdefence.gui.TowerButton;
import se.chalmers.towerdefence.gui.TowerView;
import se.chalmers.towerdefence.model.HighScore;
import se.chalmers.towerdefence.model.ISquare;
import se.chalmers.towerdefence.model.Level;
import se.chalmers.towerdefence.model.RoadSquare;
import se.chalmers.towerdefence.model.TowerSquare;
import se.chalmers.towerdefence.model.UnbuildableSquare;
import se.chalmers.towerdefence.model.Wave;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.monsters.Monster;
import se.chalmers.towerdefence.model.monsters.MonsterBurningImmune;
import se.chalmers.towerdefence.model.monsters.MonsterFreezingImmune;
import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
import se.chalmers.towerdefence.model.towers.AbstractTower;
import se.chalmers.towerdefence.model.towers.BombTower;
import se.chalmers.towerdefence.model.towers.Tower;
import se.chalmers.towerdefence.sound.BackgroundMusic;
import se.chalmers.towerdefence.sound.SoundFX;

/**
 * The state where all the gameplay the is played
 * @author Jonathan
 *
 */


public class GamePlayState extends BasicGameState {

	private Level level;

	private TiledMap map;
	private final int ID=2;

	private NextWaveButton waveStartButton;

	private ArrayList <AbstractProjectile> projectiles;
	private ArrayList <ProjectileView> projectileViews;
	private ArrayList <AbstractTower> towers;
	private ArrayList <TowerView> towerViews;
	private ArrayList <MonsterView> monsterViews;
	private ArrayList <AbstractMonster> monsters;

	private Button sellButton;
	private TowerButton upgradeButton;

	private boolean towerClicked = false;
	private boolean buildableSquareClicked = false;


	private Button exitLevelButton;
	private Image gameOverScreen;

	private Image gameCondition;

	private boolean pause;

	private Button pauseButton;
	private Button playButton;
	private Button resumeButton;
	private Button mainMenuButton;
	private Button musicOnButton;
	private Button musicOffButton;
	private TowerButton bombButton;
	private TowerButton laserButton;
	private TowerButton towerButton;
	private TowerButton freezingButton;
	private TowerButton poisonButton;
	private TowerButton flameButton;
	private int squareHeight;

	private int squareWidth;
	private FileHandler fileHandler;
	private int counter = 1;

	private Button restartButton;
	private Button continueButton;

	private Image waveTimerImage;
	private boolean sound;



	private void startWave(){
		level.startWave();
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		ResourceHandler rH=ResourceHandler.getInstance();
		waveStartButton=new NextWaveButton(rH.getStartWaveImage(), 40, 40);
		sellButton =new Button(rH.getSellImage(),100,100,40,40);
		upgradeButton =new TowerButton(rH.getUpgradeImage(),100,100, 40,40,rH.getUpgradeDisabledImage());
		pauseButton=new Button(rH.getPauseImage(),750,0,40,40);
		musicOnButton=new Button(rH.getMusicONImage(),700,0,40,40);
		musicOffButton = new Button(rH.getMusicOffImage(),700,0,40,40);		
		bombButton = new TowerButton(rH.getBombTowerBallImage(),squareHeight,squareWidth,40,40, rH.getBombTowerBallDisabledImage());
		laserButton = new TowerButton(rH.getLaserTowerBallImage(),squareHeight,squareWidth,40,40, rH.getLaserTowerBallDisabledImage());
		towerButton = new TowerButton(rH.getAppleTowerBallImage(),squareHeight,squareWidth,40,40, rH.getAppleTowerBallDisabledImage());
		freezingButton = new TowerButton(rH.getIceTowerBallImage(),squareHeight,squareWidth,40,40, rH.getIceTowerBallDisabledImage());
		poisonButton = new TowerButton(rH.getPoisonTowerBallImage(),squareHeight,squareWidth,40,40, rH.getPoisonTowerBallDisabledImage());
		flameButton = new TowerButton(rH.getFlameTowerBallImage(),squareHeight,squareWidth,40,40, rH.getFlameTowerBallDisabledImage());
		exitLevelButton = new Button(rH.getExitLevelImage(),350,270, 130, 46);
		restartButton = new Button(rH.getRestartImage(),350,210, 130, 46);
		gameOverScreen = rH.getGameOverScreen();
		resumeButton = new Button(rH.getResumeImage(), 350, 150, 130, 46);
		mainMenuButton = new Button(rH.getMainMenuImage(), 350, 330, 130, 46);
		playButton = new Button(rH.getPlayImage(),750,0,40,40);
		continueButton = new Button(rH.getContinueImage(),350, 270, 130, 46);
		sound = BackgroundMusic.getInstance().playing();

		waveTimerImage = ResourceHandler.getInstance().getPalleteImage();


		fileHandler = new FileHandler();

		gc.setShowFPS(false);


	}

	public void enter(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		startLevel(container);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		if(g.getColor()!=org.newdawn.slick.Color.black){
			g.setColor(org.newdawn.slick.Color.black);
		}

		if(!pause){
			if(!level.gameOver()){

				map.render(0, 0, 0, 0,gc.getWidth(), gc.getHeight());
				pauseButton.draw();
				if(sound){
					musicOnButton.draw();
				}else{
					musicOffButton.draw();
				}

				for(AbstractTower t : towers){
					boolean temp = true;
					for(TowerView tV : towerViews){
						if(t==tV.getTower()){
							temp=false;
						}
					}
					if(temp){
						towerViews.add(new TowerView(t, squareWidth, squareHeight));
					}else{
						temp=true;	
					}
				}

				for(Iterator<TowerView> it = towerViews.iterator(); it.hasNext();){
					TowerView t = it.next();
					if(t.exists()){
						if(t.getTower().getClicked()){
							t.drawRange(g);
							playerAffordUpgrade();
							upgradeButton.draw();
							sellButton.draw();
						}
						t.draw();
					}else{
						it.remove();
					}
				}
				for(AbstractProjectile p : projectiles){
					boolean temp=true;
					for(ProjectileView pV : projectileViews){
						if(p==pV.getProjectile()){
							temp=false;
						}
					}
					if(temp){
						projectileViews.add(new ProjectileView(p, squareHeight/2, squareHeight/2));
					}else{
						temp=true;	
					}
				}
				for(Iterator<ProjectileView> it = projectileViews.iterator(); it.hasNext();){
					ProjectileView p = it.next();
					if(p.exists()){
						p.draw();
					}else{
						it.remove();
					}
				}
				monsters=level.getMonster();
				for(AbstractMonster m : monsters){
					boolean temp=true;
					for(MonsterView mV : monsterViews){
						if(m==mV.getMonster()){
							temp=false;
						}
					}	
					if(temp){
						monsterViews.add(new MonsterView(m, (int)(squareWidth*0.8), (int)(squareHeight*0.8)));
					}else{
						temp=true;	
					}
				}
				for(Iterator<MonsterView> it = monsterViews.iterator(); it.hasNext();){
					MonsterView m = it.next();
					if(m.exists()){
						m.draw();
					}else{
						it.remove();
					}
				}
				
				if(buildableSquareClicked) {
					playerAffordTowers();
					bombButton.draw();
					laserButton.draw();
					towerButton.draw();
					freezingButton.draw();
					poisonButton.draw();
					flameButton.draw();
				}

				g.drawString(level.getPlayer().toString(), 0, squareHeight-g.getFont().getLineHeight());
				g.drawString("Wave: " + level.getCounter() +"/" + level.getNbrOfWaves(), 0, 2*squareHeight-g.getFont().getLineHeight());

				if(level.wavesOnMapDoneSending()){
					waveStartButton.draw();
					waveTimerImage.draw(waveStartButton.getX(), waveStartButton.getY()-20, waveStartButton.getWidth()*(level.getTimer()/1000f), 10, Color.cyan);
				}
			}else{
				gameOver(g);
			}
		}else{
			pauseGame(g, gc);	
		}		
	}

	private void playerAffordUpgrade() {
		int cost = 0;
		int towerLevel = 0;
		for(AbstractTower t : towers){
			if(t.getClicked()){
				cost = t.getUpgradeCost();
				towerLevel = t.getUpgrades();
			}
		}
		int resources = level.getPlayer().getResources();
		if(resources >= cost && towerLevel < 4 ) {
			upgradeButton.canAfford(true);
		}else{
			upgradeButton.canAfford(false);
		}
	}

	private void playerAffordTowers() {
		int resources = level.getPlayer().getResources();
		int highestCost = new BombTower(0, 0, projectiles, 0, 0).getCost();
		int lowestCost = new Tower(0, 0, projectiles, 0, 0).getCost();
		if(resources >= highestCost){
			bombButton.canAfford(true);
			laserButton.canAfford(true);
			towerButton.canAfford(true);
			freezingButton.canAfford(true);
			poisonButton.canAfford(true);
			flameButton.canAfford(true);
		}else if(resources >= lowestCost) {
			bombButton.canAfford(false);
			laserButton.canAfford(false);
			towerButton.canAfford(true);
			freezingButton.canAfford(true);
			poisonButton.canAfford(true);
			flameButton.canAfford(true);
		}else{
			bombButton.canAfford(false);
			laserButton.canAfford(false);
			towerButton.canAfford(false);
			freezingButton.canAfford(false);
			poisonButton.canAfford(false);
			flameButton.canAfford(false);
		}
	}

	private void gameOver(Graphics g) {
		gameOverScreen.draw(0, 0);
		if(level.getPlayer().getLives()==0){
			gameCondition=ResourceHandler.getInstance().getDefeatImage();
		}else{
			g.drawString("Points: "+level.getPlayer().getPoints(), 355, 170);
			gameCondition=ResourceHandler.getInstance().getVictoryImage();	
			fileHandler.saveHighScore(new HighScore(level.getPlayer().getPoints(), level.getMapName()));
		}
		gameCondition.draw(270,50);
		continueButton.draw();
		restartButton.draw();
		mainMenuButton.draw();
	}

	private void pauseGame(Graphics g, GameContainer gc) {
		ResourceHandler.getInstance().getPausScreen().draw(0, 0, gc.getWidth(), gc.getHeight());
		playButton.draw();
		exitLevelButton.draw();
		restartButton.draw();
		mainMenuButton.draw();
		resumeButton.draw();
		g.drawString("Paused", 350, 50);			
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(!pause){
				if (!level.gameOver()){
					if(waveStartButton.inSpan(mouseX, mouseY) && level.wavesOnMapDoneSending()){
						startWave();				  
					}else if(level.getSquare(mouseX/squareWidth, mouseY/squareHeight) instanceof TowerSquare && !towerClicked && !buildableSquareClicked){
						towerClicked(mouseX, mouseY);
					}else if(towerClicked) {
						modifyTower(mouseX, mouseY);
					}else if(pauseButton.inSpan(mouseX, mouseY)){
						pause=true;
					}else if(musicOnButton.inSpan(mouseX, mouseY)){
						BackgroundMusic.getInstance().toggleMusic();
						SoundFX.getInstance().toggleSounds();
						fileHandler.saveSoundSettings();
						sound = BackgroundMusic.getInstance().playing();
					}else if(buildableSquareClicked) {
						buildTower(mouseX, mouseY);
					}else if(level.getSquare(mouseX/squareWidth, mouseY/squareHeight) instanceof UnbuildableSquare){
						//Do nothing
					}else{
						buildableSquareClicked(mouseX, mouseY);
					}
				}else{
					gameOverUpdate(gc, sbg, mouseX, mouseY);
				}
			}else{
				pauseGameUpdate(gc, sbg, mouseX, mouseY);
			}
		}
		level.update();
	}

	private void modifyTower(int mouseX, int mouseY) {
		if(sellButton.inSpan(mouseX,mouseY)) {
			level.sellTower((sellButton.getX()-squareWidth/2)/squareWidth, (sellButton.getY()-squareHeight/2)/squareHeight);
		}else if(upgradeButton.inSpan(mouseX, mouseY)) {
			level.upgradeTower((upgradeButton.getX()+squareWidth)/squareWidth, (upgradeButton.getY()-squareHeight/2)/squareHeight);
		}else{
			towerClicked = false;
			for(AbstractTower t : towers){
				t.setClicked(false);
			}
		}
	}

	private void buildTower(int mouseX, int mouseY) {
		if(bombButton.inSpan(mouseX, mouseY)) {
			level.buildTower((bombButton.getX()+squareWidth/2)/squareWidth, (bombButton.getY()+squareHeight)/squareHeight, 2);
		}else if(laserButton.inSpan(mouseX, mouseY)) {
			level.buildTower((laserButton.getX()-squareWidth/2)/squareWidth, (laserButton.getY()+squareHeight/2)/squareHeight, 3);
		}else if(towerButton.inSpan(mouseX, mouseY)) {
			level.buildTower((towerButton.getX()-squareWidth/2)/squareWidth,  (towerButton.getY()-squareHeight/2)/squareHeight, 1);
		}else if(freezingButton.inSpan(mouseX, mouseY)) {
			level.buildTower((freezingButton.getX()+squareWidth/2)/squareWidth,  (freezingButton.getY()-squareHeight)/squareHeight, 4);
		}else if(poisonButton.inSpan(mouseX, mouseY)) {
			level.buildTower((poisonButton.getX()+3*squareWidth/2)/squareWidth,  (poisonButton.getY()-squareHeight/2)/squareHeight, 5);
		}else if(flameButton.inSpan(mouseX, mouseY)) {
			level.buildTower((flameButton.getX()+3*squareWidth/2)/squareWidth,  (flameButton.getY()+squareHeight/2)/squareHeight, 6);
		}
		buildableSquareClicked = false;
	}

	private void gameOverUpdate(GameContainer gc, StateBasedGame sbg, int mouseX, int mouseY) {
		if(continueButton.inSpan(mouseX, mouseY)){
			sbg.enterState(4);				  
		}else if(restartButton.inSpan(mouseX, mouseY)){
			startLevel(gc);
		}else if(mainMenuButton.inSpan(mouseX, mouseY)){
			sbg.enterState(1);
		}

	}

	private void pauseGameUpdate(GameContainer gc, StateBasedGame sbg,
			int mouseX, int mouseY) {
		if(restartButton.inSpan(mouseX, mouseY)){
			startLevel(gc);
		}else if(mainMenuButton.inSpan(mouseX, mouseY)){
			sbg.enterState(1);
		}else if(resumeButton.inSpan(mouseX, mouseY)) {
			pause = false;
		}else if(exitLevelButton.inSpan(mouseX, mouseY)){
			sbg.enterState(4);
		}

	}

	@Override
	public int getID() {
		return ID;
	}

	private void towerClicked(int mouseX, int mouseY) {
		towerClicked = true;
		//since the check whether it was a towersquare or not happened before this method, i can do this.
		//however, if we are to use this method in another place, we have to do the same check again.
		TowerSquare towerSquare = (TowerSquare)(level.getSquare(mouseX/squareWidth, mouseY/squareHeight));
		towerSquare.getTower().setClicked(true);
		sellButton.setPosition(towerSquare.getX()+squareWidth/2, towerSquare.getY()+squareHeight/2);
		upgradeButton.setPosition(towerSquare.getX()-squareWidth, towerSquare.getY()+squareHeight/2);
	}

	private void buildableSquareClicked(int mouseX, int mouseY) {
		if(!(level.getSquare(mouseX/squareWidth, mouseY/squareHeight) instanceof RoadSquare )){
			buildableSquareClicked = true;
			ISquare buildableSquare = level.getSquare(mouseX/squareWidth, mouseY/squareHeight);
			bombButton.setPosition(buildableSquare.getX() - squareWidth/2, buildableSquare.getY() - squareHeight);
			laserButton.setPosition(buildableSquare.getX() + squareWidth/2, buildableSquare.getY() - squareHeight/2);
			towerButton.setPosition(buildableSquare.getX() + squareWidth/2,buildableSquare.getY() + squareHeight/2);
			freezingButton.setPosition(buildableSquare.getX() - squareWidth/2, buildableSquare.getY() + squareHeight);
			poisonButton.setPosition(buildableSquare.getX() - 3*squareWidth/2, buildableSquare.getY() + squareHeight/2);
			flameButton.setPosition(buildableSquare.getX() - 3*squareWidth/2, buildableSquare.getY() - squareHeight/2);
		}
	}

	private int getSquareSize(int gameBoardSize, int resolution) {
		return resolution/(gameBoardSize-1);
	}

	private void startLevel(GameContainer gc){
		map=LevelController.getInstance().getMap();
		String textFileName = LevelController.getInstance().getMapName() + ".txt";
		WaveSplitController wu = new WaveSplitController(textFileName);
		String[] waves = wu.getWaves();
		ISquare[][] gameBoard = GameBoardUtil.convertTiledMap(map, gc.getHeight(), gc.getWidth());
		squareHeight = getSquareSize(gameBoard[0].length, gc.getHeight());
		squareWidth = getSquareSize(gameBoard.length, gc.getWidth());
		level=new Level(gameBoard, waves, squareHeight, squareWidth, LevelController.getInstance().getMapName());	

		towerViews = new ArrayList<TowerView>();
		projectileViews = new ArrayList<ProjectileView>();
		monsterViews = new ArrayList<MonsterView>();

		projectiles=level.getProjectiles();
		towers=level.getTowers();
		monsters=level.getMonster();
		pause=false;

		waveStartButton.setNewPosition(level.getRoad().getFirst());

	}

}