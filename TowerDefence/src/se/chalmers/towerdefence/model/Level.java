package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
import se.chalmers.towerdefence.model.towers.AbstractTower;
import se.chalmers.towerdefence.model.towers.BombTower;
import se.chalmers.towerdefence.model.towers.FlameTower;
import se.chalmers.towerdefence.model.towers.FreezingTower;
import se.chalmers.towerdefence.model.towers.LaserTower;
import se.chalmers.towerdefence.model.towers.PoisonTower;
import se.chalmers.towerdefence.model.towers.Tower;
 /**
  * A class that holds all data representing an instance of a level.
  * @author Julia, Jonathan, Emma, Oskar
  *
  */

public class Level {


	private GameBoard gameBoard;
	private Road road;
	private WaveController waveController;
	private ArrayList <AbstractTower> towers = new ArrayList<AbstractTower>();
	private ArrayList <AbstractProjectile> projectiles = new ArrayList<AbstractProjectile>();
	private Player player;
	private boolean gameOver;
	private int squareHeight;
	private int squareWidth;
	private String mapName;


	public Level(ISquare[][] gB, String [] allWavesSplited, int squareHeight, int squareWidth, String mapName) {
		gameBoard = new GameBoard(gB, squareHeight, squareWidth);
		road = new Road(gameBoard);
		player = new Player(20, 500);
		waveController = new WaveController(road, player, allWavesSplited);
		gameOver=false;
		this.squareHeight = squareHeight;
		this.squareWidth = squareWidth;
		this.mapName = mapName;
	}

	public void startWave(){
		waveController.startNewWave();
	}

	public ArrayList<AbstractTower> getTowers(){
		return towers;
	}

	public ArrayList <AbstractProjectile> getProjectiles(){
		return projectiles;
	}

	public void update(){
		waveController.update();
		if(player.getLives()==0 || waveController.allWavesAreDone()){
			gameOver=true;
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

	public boolean gameOver(){
		return gameOver;
	}


	public void buildTower(int x, int y, int ID) {
		if(!gameBoard.isBlocked(x,y)){
			switch(ID) {
			case 1: 
				AbstractTower tower = new Tower(x,y,projectiles, squareHeight, squareWidth);
				if(tower.getCost()<=player.getResources()) {
					towers.add(tower);
					gameBoard.addTower(x,y,tower);
					player.useResources(tower.getCost());
				}
				break;
			case 2: 
				AbstractTower bombTower = new BombTower(x, y, projectiles, squareHeight, squareWidth);
				if(bombTower.getCost()<=player.getResources()) {
					towers.add(bombTower);
					gameBoard.addTower(x,y,bombTower);
					player.useResources(bombTower.getCost());
				}
				break;
			case 3:
				AbstractTower laserTower = new LaserTower(x, y, projectiles, squareHeight, squareWidth);
				if(laserTower.getCost()<=player.getResources()) {
					towers.add(laserTower);
					gameBoard.addTower(x,y,laserTower);
					player.useResources(laserTower.getCost());
				}
				break;
			case 4:
				AbstractTower freezingTower = new FreezingTower(x, y, projectiles, squareHeight, squareWidth);
				if(freezingTower.getCost()<=player.getResources()) {
					towers.add(freezingTower);
					gameBoard.addTower(x,y,freezingTower);
					player.useResources(freezingTower.getCost());
				}
				break;
			case 5:
				AbstractTower poisonTower = new PoisonTower(x, y, projectiles, squareHeight, squareWidth);
				if(poisonTower.getCost()<=player.getResources()) {
					towers.add(poisonTower);
					gameBoard.addTower(x,y,poisonTower);
					player.useResources(poisonTower.getCost());
				}
				break;
			case 6:
				AbstractTower flameTower = new FlameTower(x, y, projectiles, squareHeight, squareWidth);
				if(flameTower.getCost()<=player.getResources()) {
					towers.add(flameTower);
					gameBoard.addTower(x,y,flameTower);
					player.useResources(flameTower.getCost());
				}
				break;
			}
			
		}

	}

	public void sellTower(int x, int y) {
		TowerSquare tempSquare = (TowerSquare) gameBoard.getSquare(x,y);
		AbstractTower tower = tempSquare.getTower();
		player.addResources(tower.sellTower());
		towers.remove(tower);
		gameBoard.sellTower(x,y);

	}

	public void upgradeTower(int x, int y) {
		TowerSquare tempSquare = (TowerSquare) gameBoard.getSquare(x,y);
		AbstractTower currentTower = tempSquare.getTower();
		if(!(currentTower.getUpgrades() > 3) && currentTower.getUpgradeCost() <= player.getResources()){
			player.useResources(currentTower.getUpgradeCost());
			AbstractTower upgradedTower = currentTower.upgradeTower();
			towers.add(upgradedTower);
			towers.remove(currentTower);
			gameBoard.addTower(x,y,upgradedTower);
		}
	}

	public ISquare getSquare(int x, int y) {
		return gameBoard.getSquare(x, y);
	}


	public List<Wave> getWaves() {
		return waveController.getWavesOnGameBoard();
	}

	public ArrayList<AbstractMonster> getMonster() {
		ArrayList <AbstractMonster> monsters = new ArrayList<AbstractMonster>();
		for(Wave w: getWaves()){
			monsters.addAll(w.getmonstersInWave());
		}
		return monsters;
	}
	public String getMapName() {
		return mapName;
	}
	
	public Road getRoad(){
		return road;
	}
	
	public boolean wavesOnMapDoneSending(){
		return waveController.wavesOnGameboardHasSentAll();
	}
	
	public int getCounter() {
		return waveController.getCounter();
	}
	
	public int getNbrOfWaves() {
		return waveController.getNbrOfWaves();
	}
	 
	public int getTimer() {
		return waveController.getTimer();
	}
	
	public List<Wave> getWavesOnGameBoard() {
		return waveController.getWavesOnGameBoard();
	}
	


}