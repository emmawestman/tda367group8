package se.chalmers.TowerDefence;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.lwjgl.util.Timer;
import org.newdawn.slick.SlickException;

public class Wave implements Observer{
	private ArrayList <Monster> monsterWave = new ArrayList<Monster>();
	private Road road;
	private final int nbrOfMonsters;
	private int spawnedMonsters;
	private Timer timer; 
	private final float intervall;	
	
	public Wave(int nbrOfMonsters, Road road) throws SlickException {
		this.road = road;
		createMonsters();
		this.nbrOfMonsters = nbrOfMonsters;
		timer = new Timer();
		intervall = 0.5f;
	}
	
	public void move() {
		timer.tick();
		if(spawnedMonsters < nbrOfMonsters && timer.getTime() > intervall){
			try{
				createMonsters();
				spawnedMonsters++;
			}catch(SlickException e){System.out.println(e);}
			timer.set(0);
		}
		for (Monster m : monsterWave) {
			if(!monsterWave.isEmpty()){
				m.move();
				
			}
		}
	}
	
	public void draw(){
		for (Monster m : monsterWave){
			m.draw();
		}
	}
	public void createMonsters() throws SlickException {
		for (int i=0; i<nbrOfMonsters; i++) {
//			Monster monster = new Monster(road);
			monsterWave.add(new Monster(road));
			monsterWave.get(0).addObserver(this);
		}
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Monster> getMonsterWave(){
		return monsterWave;
	}

//	public void update(Observable o, Object arg) {
//		if(arg == false) {
//			for (int i=0; i<monsterWave.size(); i++) {
//				if (o.equals(monsteWave.get(i)) {
// 					remove(monsterWave.get(i));
//				}
//			}
//			
//		}else {
//			
//			
//			
//		}
		
		
}
	
