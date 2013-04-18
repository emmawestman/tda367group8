package se.chalmers.TowerDefence;

import java.util.ArrayList;
import java.util.Iterator;

import se.chalmers.slickTD.GameBoardController;


public class Level {
	
	
	private GameBoard gameBoard;
	private Road road;
	private ArrayList <Wave> waves = new ArrayList<Wave>();
	private ArrayList <AbstractTower> towers = new ArrayList<AbstractTower>();
	private ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
	private Player player;
	
	public Level(GameBoardController gbc){
		gameBoard = new GameBoard(gbc);
		road = new Road(gameBoard);
		player = new Player(20, 1000);
	}
	
	public void startWave(){
			waves.add(new Wave(5,road,player));
	}
	
	public void draw(){
		if(!waves.isEmpty()){
			for(Wave w : waves){
				w.draw();
			}
		}
		if(!towers.isEmpty()){
			for(AbstractTower t : towers){
				t.draw();
			}
		}
		if(!projectiles.isEmpty()){
			for(Projectile p : projectiles){
				p.draw();
			}
		}
	}
	
	public void update(){
		if(!waves.isEmpty()){
			for(Iterator<Wave> it = waves.iterator(); it.hasNext();){
				Wave w = it.next();
				if(w.isEmpty()){
					it.remove();
				}else{
					w.move();	
				}
			}
		}
		if(!towers.isEmpty()){
			for(AbstractTower t : towers){
				t.tryShoot(waves);
			}
		}
		if(!projectiles.isEmpty()){
			for(Iterator<Projectile> it = projectiles.iterator(); it.hasNext();){
				Projectile p = it.next();
				if(p.exists()){
					p.move();
				}else{
					it.remove();
				}
			}
		}
	}
	
	public Player getPlayer(){
		return player;
	}


	public void buildTower(int mouseX, int mouseY) {
		int x = gameBoard.getTile(mouseX);
		int y = gameBoard.getTile(mouseY);
		AbstractTower tower = new Tower(x,y,150,projectiles);
		if(!gameBoard.isBlocked(x,y) && tower.getCost()<=player.getResources()){
			towers.add(tower);
			gameBoard.addTower(x,y);
			player.useResources(tower.getCost());
		}
			
		
	}
}