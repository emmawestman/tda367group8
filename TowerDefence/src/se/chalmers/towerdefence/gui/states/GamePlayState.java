package se.chalmers.towerdefence.gui.states;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.gui.GameBoardController;
import se.chalmers.towerdefence.gui.MonsterView;
import se.chalmers.towerdefence.gui.ProjectileView;
import se.chalmers.towerdefence.gui.TowerView;
import se.chalmers.towerdefence.model.AbstractMonster;
import se.chalmers.towerdefence.model.AbstractProjectile;
import se.chalmers.towerdefence.model.AbstractTower;
import se.chalmers.towerdefence.model.Level;
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
	
				
	}
	
	public void enter(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		map=StateController.getInstance().getMap();
		gbc=new GameBoardController(map);
		level=new Level(gbc.getGameBoard());
		StateController.getInstance().setLevel(level);	
		
		projectiles=level.getProjectiles();
		towers=level.getTowers();
		waves=level.getWaves();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		
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
		for(TowerView tV : towerViews){
			tV.draw();
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
		
		g.drawString(level.getPlayer().toString(), 0, 30);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		  
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		  
		if (input.isMousePressed((Input.MOUSE_LEFT_BUTTON))){
			if( ( mouseX >= menuX && mouseX <= menuX + ball.getWidth()) &&
			  ( mouseY >= menuY && mouseY <= menuY + ball.getHeight()) ){
				  startWave();				  
			  }else{
				  level.buildTower(mouseX,mouseY);
			  }
			  
		 }
		level.update();		
		if(level.gameOver()){
			sbg.enterState(3);
		}
	}

	@Override
	public int getID() {
		return ID;
	}

}