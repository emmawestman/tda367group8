package se.chalmers.towerdefence.controller.states;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.controller.GameBoardController;
import se.chalmers.towerdefence.controller.LevelController;
import se.chalmers.towerdefence.gui.MonsterView;
import se.chalmers.towerdefence.gui.ProjectileView;
import se.chalmers.towerdefence.gui.TowerView;
import se.chalmers.towerdefence.model.AbstractMonster;
import se.chalmers.towerdefence.model.AbstractProjectile;
import se.chalmers.towerdefence.model.AbstractTower;
import se.chalmers.towerdefence.model.Level;
import se.chalmers.towerdefence.model.TowerSquare;
import se.chalmers.towerdefence.model.Wave;

public class GamePlayState extends BasicGameState {
	private Level level;
	private Image ball;
	private int menuX=100;
	private int menuY=100;
	private TiledMap map;
	private GameBoardController gbc;
	private final int ID=2;
	private ArrayList <AbstractProjectile> projectiles;
	private ArrayList <ProjectileView> projectileViews;
	private ArrayList <AbstractTower> towers;
	private ArrayList <TowerView> towerViews;
	private MonsterView mV;
	private List <Wave> waves;
	private Image sell;
	private Image upgrade;
	private boolean towerClicked = false;
	private int sellPosX;
	private int sellPosY;
	private int upgradePosX;
	private int upgradePosY;
	private Music music;
	private String stringCondition;
	private Image start;
	private Image gameOverScreen;


	private void startWave(){
		level.startWave();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame sbg)
			throws SlickException {
		ball= new Image("res/ball.gif");
		towerViews = new ArrayList<TowerView>();
		projectileViews = new ArrayList<ProjectileView>();
		mV=new MonsterView();
//		sell = new Image("res/sell.gif");
//		upgrade = new Image("res/upgrade.gif");
		music = new Music("res/TheSmurfsThemeSong.wav");	
		start= new Image("res/start.gif");
		gameOverScreen= new Image("res/GameOverScreen.gif");


	}

	public void enter(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		map=LevelController.getInstance().getMap();
		gbc=new GameBoardController(map);
		level=new Level(gbc.getGameBoard());
		LevelController.getInstance().setLevel(level);	

		towerViews = new ArrayList<TowerView>();
		projectileViews = new ArrayList<ProjectileView>();

		projectiles=level.getProjectiles();
		towers=level.getTowers();
		waves=level.getWaves();
		music.loop();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		if(!level.gameOver()){
		map.render(0, 0); 
		ball.draw(menuX, menuY);
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

		for(Wave w : waves){
			for (AbstractMonster m : w.getmonstersOnGameBoard()){
				mV.draw(m.getX(),m.getY(),m.getID());				
			}
		}
		
		if(towerClicked){
			g.drawOval(upgradePosX, upgradePosY, 50, 50);
			g.drawOval(sellPosX, sellPosY, 50, 50);
//			upgrade.draw(upgradePosX, upgradePosY);
//			sell.draw(sellPosX, sellPosY);
		}

		g.drawString(level.getPlayer().toString(), 0, 30);
		
		}else{
			if(level.getPlayer().getLives()==0){
				stringCondition="DEFEAT";
			}else{
				stringCondition="VICTORY";			
			}
			
			gameOverScreen.draw(0, 0);
			g.drawString(stringCondition, 350, 200);
			start.draw(menuX,menuY);
			
		}
		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		if(!level.gameOver()){
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if( ( mouseX >= menuX && mouseX <= menuX + ball.getWidth()) &&
					( mouseY >= menuY && mouseY <= menuY + ball.getHeight()) ){
				startWave();				  
			}else if(gbc.getSquare(mouseX/40, mouseY/40) instanceof TowerSquare){
				towerClicked(mouseX, mouseY);
			}else if(towerClicked) {
				if((mouseX >= sellPosX && mouseX <= sellPosX + 50) && mouseY >= sellPosY && mouseY <=sellPosY + 50) {
					level.sellTower((sellPosX-40)/40, (sellPosY-20)/40);
				}else if(mouseX >= upgradePosX && mouseX <= upgradePosX + 50 && mouseY >= upgradePosY && mouseY <=upgradePosY + 50) {
					level.upgradeTower((upgradePosX+40)/40, (upgradePosY-20)/40);
				}
				towerClicked = false;
			}else{
				level.buildTower(mouseX/40, mouseY/40);
			}

		}
		level.update();		
		}else{
			if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
				if( ( mouseX >= menuX && mouseX <= menuX + start.getWidth()) &&
				  ( mouseY >= menuY && mouseY <= menuY + start.getHeight()) ){
					  sbg.enterState(4);				  
				  }
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