package se.chalmers.towerdefence.controller.states;

import java.util.ArrayList;
import java.util.Iterator;
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
import se.chalmers.towerdefence.gui.BackgroundMusic;
import se.chalmers.towerdefence.gui.Button;
import se.chalmers.towerdefence.gui.MonsterView;
import se.chalmers.towerdefence.gui.ProjectileView;
import se.chalmers.towerdefence.gui.ResourceHandler;
import se.chalmers.towerdefence.gui.TowerView;
import se.chalmers.towerdefence.model.AbstractMonster;
import se.chalmers.towerdefence.model.AbstractProjectile;
import se.chalmers.towerdefence.model.AbstractTower;
import se.chalmers.towerdefence.model.Level;
import se.chalmers.towerdefence.model.TowerSquare;

/**
 * The state where all the gameplay the is played
 * @author Jonathan
 *
 */


public class GamePlayState extends BasicGameState {
	
	private Level level;
	
	private TiledMap map;
	private final int ID=2;
	
	private Button waveStartButton;
	
	private ArrayList <AbstractProjectile> projectiles;
	private ArrayList <ProjectileView> projectileViews;
	private ArrayList <AbstractTower> towers;
	private ArrayList <TowerView> towerViews;
	private ArrayList <MonsterView> monsterViews;
	private ArrayList <AbstractMonster> monsters;
	
	private Button sellButton;
	private Button upgradeButton;
	
	private boolean towerClicked = false;
	private int sellPosX;
	private int sellPosY;
	private int upgradePosX;
	private int upgradePosY;
	
	private Button startOverButton;
	private Image gameOverScreen;

	private Image gameCondition;
	
	private boolean pause;

	private Button pauseButton;

	private Button pauseMusicButton;


	private void startWave(){
		level.startWave();
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		waveStartButton=new Button(new Image("res/ball.gif"),100,100);
		sellButton =new Button(new Image("res/sell.gif"),100,100);
		upgradeButton =new Button(new Image("res/upgrade.gif"),100,100);
		pauseButton=new Button(new Image("res/ball.gif"),750,0);
		pauseMusicButton=new Button(new Image("res/ball.gif"),700,0);
		
			
		startOverButton= new Button(new Image("res/start.gif"),300,400);
		gameOverScreen= new Image("res/GameOverScreen.gif");
		
		gc.setShowFPS(false);


	}

	public void enter(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		map=LevelController.getInstance().getMap();
		WaveSplitController wu = new WaveSplitController();
		String[] waves = wu.getWaves();
		System.out.println(waves + "game play state");
		level=new Level(GameBoardUtil.convertTiledMap(map), waves);
//		LevelController.getInstance().setLevel(level);	

		towerViews = new ArrayList<TowerView>();
		projectileViews = new ArrayList<ProjectileView>();
		monsterViews = new ArrayList<MonsterView>();

		projectiles=level.getProjectiles();
		towers=level.getTowers();
		monsters=level.getMonster();
		
		BackgroundMusic.getInstance().loopMusic();
		pause=false;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		if(!pause){
			if(!level.gameOver()){
				map.render(0, 0); 
				waveStartButton.draw();
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
						towerViews.add(new TowerView(t));
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
						projectileViews.add(new ProjectileView(p));
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
					monsterViews.add(new MonsterView(m));
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
					upgradeButton.draw(upgradePosX, upgradePosY);
					sellButton.draw(sellPosX, sellPosY);
				}
		
				g.drawString(level.getPlayer().toString(), 0, 0);
				
				}else{
					if(level.getPlayer().getLives()==0){
						gameCondition=ResourceHandler.getInstance().getDefeatImage();
					}else{
						gameCondition=ResourceHandler.getInstance().getVictoryImage();			
					}
					
					gameOverScreen.draw(0, 0);
					gameCondition.draw(250,200);
					g.drawString("Points: "+level.getPlayer().getPoints(), 300, 350);
					startOverButton.draw();
					
				}
				
			}else{
				pauseButton.draw();
				g.drawString("Paused", 300, 300);	
			}		
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
					if(waveStartButton.inSpan(mouseX, mouseY)){
						startWave();				  
					}else if(level.getSquare(mouseX/40, mouseY/40) instanceof TowerSquare){
						towerClicked(mouseX, mouseY);
					}else if(towerClicked) {
						if(sellButton.inSpan(mouseX,mouseY)) {
							level.sellTower((sellPosX-40)/40, (sellPosY-20)/40);
						}else if(upgradeButton.inSpan(mouseX, mouseY)) {
							level.upgradeTower((upgradePosX+40)/40, (upgradePosY-20)/40);
						}
						towerClicked = false;
					}else if(pauseButton.inSpan(mouseX, mouseY)){
						pause=true;
					}else if(pauseMusicButton.inSpan(mouseX, mouseY)){
						BackgroundMusic.getInstance().pauseMusic();
					}else{
						level.buildTower(mouseX/40, mouseY/40);
					}
			
				}
				level.update();		
			}else{
				if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
					if(startOverButton.inSpan(mouseX, mouseY)){
						  sbg.enterState(4);				  
					  }
				}
			}
		}if(pauseButton.inSpan(mouseX, mouseY)){
			if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
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
		sellPosX = mouseX+40;
		sellPosY = mouseY+20;
		upgradePosX = mouseX-40;
		upgradePosY = mouseY+20;
	}

}