package se.chalmers.TowerDefence;

import java.util.ArrayList;
import java.util.Iterator;

import se.chalmers.slickTD.GameBoardController;


public class Level {
	
	
	private GameBoard gameBoard;
	private Road road;
	private ArrayList <Wave> waves = new ArrayList<Wave>();
	private ArrayList <Tower> towers = new ArrayList<Tower>();
	private ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
	private Player player;
	
	public Level(GameBoardController gbc){
		gameBoard = new GameBoard(gbc);
		road = new Road(gameBoard);
		player = new Player(20, 1000);
	}
	
	public void startWave(){
			waves.add(new Wave(5,road));
	}
	
	public void draw(){
		if(!waves.isEmpty()){
			for(Wave w : waves){
				w.draw();
			}
		}
		if(!towers.isEmpty()){
			for(Tower t : towers){
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
			for(Wave w : waves){
				w.move();
			}
		}
		if(!towers.isEmpty()){
			for(Tower t : towers){
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


	public void buildTower(int mouseX, int mouseY){
		int x = gameBoard.getTile(mouseX);
		int y = gameBoard.getTile(mouseY);
		if(!gameBoard.isBlocked(x,y)){
			towers.add(new Tower(x,y,150,projectiles));
			gameBoard.addTower(x,y);
		}
			
		
	}
}
