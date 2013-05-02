package se.chalmers.towerdefence.gui.states;

import java.util.ArrayList;
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
	  private final int ID=1;
	  private ArrayList <AbstractProjectile> projectiles;
	  private ProjectileView pV;
	  private ArrayList <AbstractTower> towers;
      private TowerView tV;
      private List <AbstractMonster> monsters;
      private MonsterView mV;
      private List <Wave> waves;

	  
	 private void startWave(){
		 level.startWave();
	 }

	@Override
	public void init(GameContainer arg0, StateBasedGame sbg)
			throws SlickException {
		ball= new Image("res/ball.gif");
		map = new TiledMap("res/Thirdmap.tmx");
		gbc=new GameBoardController(map);
		level=new Level(gbc.getGameBoard());
		StateController.getInstance(level);
		pV=new ProjectileView();
		tV=new TowerView();
		mV=new MonsterView();
		projectiles=level.getProjectiles();
		towers=level.getTowers();
		waves=level.getWaves();
		
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		
		map.render(0, 0); 
		ball.draw(menuX, menuY);
		
		for(AbstractTower t : towers){
			tV.draw(t.getX(),t.getY());
		}
		
		for(AbstractProjectile p : projectiles){
			pV.draw(p.getX(), p.getY());
		}
		
		for(Wave w : waves){
			monsters=w.getmonstersOnGameBoard();
			for (AbstractMonster m : monsters){
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
			sbg.enterState(2);
		}
	}

	@Override
	public int getID() {
		return ID;
	}

}