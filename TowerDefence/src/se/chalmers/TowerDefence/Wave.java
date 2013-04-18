package se.chalmers.TowerDefence;

import java.util.Iterator;
import java.util.LinkedList;

import org.lwjgl.util.Timer;

public class Wave {
	private LinkedList <AbstractMonster> monsterWave = new LinkedList<AbstractMonster>();
	private Road road;
	private final int nbrOfMonsters;
	private int spawnedMonsters;
	private Timer timer; 
	private final float intervall;	
	private Player player;
	
	public Wave(int nbrOfMonsters, Road road, Player player){
		this.road = road;
		this.player = player;
		createMonsters();
		this.nbrOfMonsters = nbrOfMonsters;
		timer = new Timer();
		intervall = 0.5f;
	}
	
	public void move() {
		timer.tick();
		if(spawnedMonsters < nbrOfMonsters && timer.getTime() > intervall){
			
				createMonsters();
				spawnedMonsters++;
			
			timer.set(0);
		}
		if(!monsterWave.isEmpty()){
			for(Iterator<AbstractMonster> it = monsterWave.iterator(); it.hasNext();){
				AbstractMonster m = it.next();
				if(m.isAlive()){
					m.move();
				}else{
					it.remove();
				}
			}
		}
	}
	
	public void draw(){
		for (AbstractMonster m : monsterWave){
			m.draw();
		}
	}
	public void createMonsters(){
			monsterWave.add(new Monster(road, player));
	}
	
	public LinkedList<AbstractMonster> getMonsterWave(){
		return monsterWave;
	}

	
	public boolean isEmpty(){
		if(spawnedMonsters >= nbrOfMonsters){
			return monsterWave.isEmpty();
		}else{
			return false;
		}
	}
			
}