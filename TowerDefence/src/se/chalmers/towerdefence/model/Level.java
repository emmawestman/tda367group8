package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

import se.chalmers.towerdefence.gui.GameBoardController;
import se.chalmers.towerdefence.gui.states.StateBasedMain;
import se.chalmers.towerdefence.gui.states.StateController;
import temp.HighScore;


public class Level {
	
	
	private GameBoard gameBoard;
	private Road road;
	private WaveController waveController;
//	private ArrayList <Wave> waves = new ArrayList<Wave>();
	private ArrayList <AbstractTower> towers = new ArrayList<AbstractTower>();
	private ArrayList <AbstractProjectile> projectiles = new ArrayList<AbstractProjectile>();
	private Player player;
	public static HighScore highScore;
	private StateController stateController;
	private StateBasedMain sbm;
	

	public Level(GameBoardController gbc){
		gameBoard = new GameBoard(gbc);
		road = new Road(gameBoard);
		player = new Player(20, 500);
		waveController = new WaveController(road, player);
		highScore = new HighScore(100, "level1");
		stateController=stateController.getInstance();
		sbm=stateController.getStateBasedMain();
	}
	
	public void startWave(){
		waveController.startNewWave();
//		waves.add(new Wave(5,road,player));
	}
	
	public void draw(){
		waveController.draw();
		for(AbstractTower t : towers){
			t.draw();
		}
		for(AbstractProjectile p : projectiles){
			p.draw();
		}
	}
	
	public void update(){
		waveController.update();
		if(player.getLives()==0 || waveController.allWavesAreDone()){
			stateController.setPlayer(player);
			sbm.enterState(2);
		}
		
		for(AbstractTower t : towers){
			t.tryShoot(waveController.getWavesOnGameBoard());
		}
		for(Iterator<AbstractProjectile> it = projectiles.iterator(); it.hasNext();){
			AbstractProjectile p = it.next();
			if(p.exists()){
				p.move();
			}else{
				it.remove();
			}
		}
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public static HighScore getHS() {
		return highScore;
	
	}
	

	public void buildTower(int mouseX, int mouseY) {
		int x = gameBoard.getTile(mouseX);
		int y = gameBoard.getTile(mouseY);
		AbstractTower tower = new Tower(x,y,150,projectiles, 30, 200, 5);
		if(!gameBoard.isBlocked(x,y) && tower.getCost()<=player.getResources()){
			towers.add(tower);
			gameBoard.addTower(x,y);
			player.useResources(tower.getCost());
		}
			
		
	}
}