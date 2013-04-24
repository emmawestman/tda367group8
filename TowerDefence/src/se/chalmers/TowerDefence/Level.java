package se.chalmers.TowerDefence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

import se.chalmers.slickTD.GameBoardController;


public class Level {
	
	
	private GameBoard gameBoard;
	private Road road;
	private WaveController waveController;
//	private ArrayList <Wave> waves = new ArrayList<Wave>();
	private ArrayList <AbstractTower> towers = new ArrayList<AbstractTower>();
	private ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
	private Player player;
	public static HighScore highScore;
	

	public Level(GameBoardController gbc){
		gameBoard = new GameBoard(gbc);
		road = new Road(gameBoard);
		player = new Player(20, 500);
		waveController = new WaveController(road, player);
		highScore = new HighScore(100, "level1");
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
		for(Projectile p : projectiles){
			p.draw();
		}
	}
	
	public void update(){
		waveController.update();
		
		for(AbstractTower t : towers){
			t.tryShoot(waveController.getWavesOnGameBoard());
		}
		for(Iterator<Projectile> it = projectiles.iterator(); it.hasNext();){
			Projectile p = it.next();
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
		AbstractTower tower = new Tower(x,y,150,projectiles, 30, 200);
		if(!gameBoard.isBlocked(x,y) && tower.getCost()<=player.getResources()){
			towers.add(tower);
			gameBoard.addTower(x,y);
			player.useResources(tower.getCost());
		}
			
		
	}
}