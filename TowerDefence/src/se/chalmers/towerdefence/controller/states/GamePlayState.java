package se.chalmers.towerdefence.controller.states;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
	private Button pauseMusicButton;
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



	private void startWave(){
		level.startWave();
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		ResourceHandler rH=ResourceHandler.getInstance();
		waveStartButton=new NextWaveButton(rH.getStartWaveImage(), 30, 30);
		sellButton =new Button(rH.getSellImage(),100,100,40,40);
		upgradeButton =new TowerButton(rH.getUpgradeImage(),100,100, 40,40,rH.getUpgradeDisabledImage());
		pauseButton=new Button(rH.getPauseImage(),750,0,40,40);
		pauseMusicButton=new Button(rH.getMusicONImage(),700,0,40,40);
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
		
		
		waveTimerImage = ResourceHandler.getInstance().getHealthbar();
		
		
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
				pauseMusicButton.draw();

				boolean temp=true;
				for(AbstractTower t : towers){
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
						t.draw();
					}else{
						it.remove();
					}
				}

				temp=true;
				for(AbstractProjectile p : projectiles){
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
				if(towerClicked){
					int cost = new Tower(0, 0, projectiles, 0, 0).getUpgradeCost();
					int resources = level.getPlayer().getResources();
					if(resources >= cost) {
						upgradeButton.canAfford(true);
					}else{
						upgradeButton.canAfford(false);
					}
					upgradeButton.draw();
					sellButton.draw();
				}

				if(buildableSquareClicked) {
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
					bombButton.draw();
					laserButton.draw();
					towerButton.draw();
					freezingButton.draw();
					poisonButton.draw();
					flameButton.draw();
				}
				try{
					
						if(counter >= 200) {
							List <Wave> wavesOnGameBoard = new LinkedList<Wave>();
							wavesOnGameBoard = level.getWavesOnGameBoard();
							Wave wave = new Wave(wavesOnGameBoard.get(0).getmonstersInWave());
							List <AbstractMonster> monstersOnGameBoard = new LinkedList<AbstractMonster>();
							monstersOnGameBoard = wave.getmonstersInWave();
							int monster = (int) (Math.random()*monstersOnGameBoard.size() -1);

							if(monstersOnGameBoard.get(monster) instanceof Monster) {
								SoundFX.getInstance().playAntSound();
							}else if(monstersOnGameBoard.get(monster) instanceof MonsterBurningImmune) {
								SoundFX.getInstance().playScorpionSound();
							}else if(monstersOnGameBoard.get(monster) instanceof MonsterFreezingImmune) {
								SoundFX.getInstance().playDuckSound();
							}else {
								SoundFX.getInstance().playGargamelSound();
							}
							counter = 0;

						}else {
							counter++;
						}
					
				}catch (IndexOutOfBoundsException e) {

				}

				g.drawString(level.getPlayer().toString(), 0, squareHeight-g.getFont().getLineHeight());
				g.drawString("Wave: " + level.getCounter() +"/" + level.getNbrOfWaves(), 0, 2*squareHeight-g.getFont().getLineHeight());

				if(level.wavesOnMapDoneSending()){
					waveStartButton.draw();
					waveTimerImage.draw(waveStartButton.getX(), waveStartButton.getY(), 50*(level.getTimer()/1000f), 10);
				}


			}else{
				gameOver(g);
			}
		}else{
			pauseGame(g, gc);	
		}		
	}


	private void gameOver(Graphics g) {
		if(level.getPlayer().getLives()==0){
			gameCondition=ResourceHandler.getInstance().getDefeatImage();
		}else{
			gameCondition=ResourceHandler.getInstance().getVictoryImage();			
		}

		gameOverScreen.draw(0, 0);
		gameCondition.draw(270,50);
		g.drawString("Points: "+level.getPlayer().getPoints(), 350, 170);
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
		if(!pause){
			if(!level.gameOver()){
				if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
					if(waveStartButton.inSpan(mouseX, mouseY) && level.wavesOnMapDoneSending()){
						startWave();				  
					}else if(level.getSquare(mouseX/squareWidth, mouseY/squareHeight) instanceof TowerSquare && !towerClicked && !buildableSquareClicked){
						towerClicked(mouseX, mouseY);
					}else if(towerClicked) {
						if(sellButton.inSpan(mouseX,mouseY)) {
							level.sellTower((sellButton.getX()-squareWidth/2)/squareWidth, (sellButton.getY()-squareHeight/2)/squareHeight);
						}else if(upgradeButton.inSpan(mouseX, mouseY)) {
							level.upgradeTower((upgradeButton.getX()+squareWidth)/squareWidth, (upgradeButton.getY()-squareHeight/2)/squareHeight);
						}
						towerClicked = false;
					}else if(pauseButton.inSpan(mouseX, mouseY)){
						pause=true;
					}else if(pauseMusicButton.inSpan(mouseX, mouseY)){
						BackgroundMusic.getInstance().pauseMusic();
						SoundFX.getInstance().toggleSounds();
						
					}else if(buildableSquareClicked) {
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
					}else if(level.getSquare(mouseX/squareWidth, mouseY/squareHeight) instanceof UnbuildableSquare){

					}else{
						buildableSquareClicked(mouseX, mouseY);
					}

				}
				level.update();		
			}else{
				if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
					if(exitLevelButton.inSpan(mouseX, mouseY)){
						fileHandler.saveHighScore(new HighScore(level.getPlayer().getPoints(), level.getMapName()));
						sbg.enterState(4);				  
					}
				}
			}
		}else{
			if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
				if(restartButton.inSpan(mouseX, mouseY)){
					startLevel(gc);
				}				
			}
		}
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if(pauseButton.inSpan(mouseX, mouseY)){
					pause=false;
			}
		}

	}

	@Override
	public int getID() {
		return ID;
	}

	public void towerClicked(int mouseX, int mouseY) {
		towerClicked = true;
		ISquare towerSquare = level.getSquare(mouseX/squareWidth, mouseY/squareHeight);
		sellButton.setPosition(towerSquare.getX()+squareWidth/2, towerSquare.getY()+squareHeight/2);
		upgradeButton.setPosition(towerSquare.getX()-squareWidth, towerSquare.getY()+squareHeight/2);
	}

	public void buildableSquareClicked(int mouseX, int mouseY) {
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

	public int getSquareSize(int gameBoardSize, int resolution) {
		return resolution/(gameBoardSize-1);
	}
	
	public void startLevel(GameContainer gc){
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
		waveStartButton.setResolution(50, 50);
		
	}

}