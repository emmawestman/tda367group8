package se.chalmers.TowerDefence;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level {
	
	
	private GameBoard gameBoard;
	private Road road;
	private ArrayList <Wave> waves = new ArrayList<Wave>();
	private ArrayList <Tower> towers = new ArrayList<Tower>();
	private ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
//	private Wave wave;
	
	public Level(TiledMap map){
		gameBoard = new GameBoard(map);
		road = new Road(gameBoard);
	}
	
	public void startWave(){
		try{
			waves.add(new Wave(5,road));
		}catch(SlickException e){
			System.out.println("Message: " + e);
		}
	}
	
	public void X(){
		
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
	
	public void update() throws SlickException{
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
			for(Projectile p : projectiles){
				p.move();
			}
		}
	}
//	public int[][] getRoad(){
//		return road;
//		return null;
//	}

	public void buildTower(int mouseX, int mouseY) throws SlickException {
		int x = gameBoard.getTile(mouseX);
		int y = gameBoard.getTile(mouseY);
		if(!gameBoard.isBlocked(x,y)){
			towers.add(new Tower(x,y,150,projectiles));
			gameBoard.addTower(x,y);
		}
			
		
	}
}
