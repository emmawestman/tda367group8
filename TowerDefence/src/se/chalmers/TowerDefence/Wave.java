package se.chalmers.TowerDefence;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.lwjgl.util.Timer;

public class Wave {
	private List <AbstractMonster> monstersOnGameBoard;
	private List <AbstractMonster> monstersInWave;
	private Road road;
	private final int nbrOfMonsters;
	private int spawnedMonsters;
	private Timer timer; 
	private final float intervall;	
	private Player player;
	
	public Wave(int nbrOfMonsters, Road road, Player player){
		this.road = road;
		this.player = player;
		this.nbrOfMonsters = nbrOfMonsters;
		timer = new Timer();
		intervall = 0.5f;
		monstersOnGameBoard = new LinkedList<AbstractMonster>();
		monstersInWave = new LinkedList<AbstractMonster>();
		for(int i = 0; i < nbrOfMonsters; i++){
			monstersInWave.add(new Monster(road, player));
		}
	}
	
	public Wave(List<AbstractMonster> monsterList, Road road, Player player){
		this.road = road;
		this.player = player;
		timer = new Timer();
		intervall = 0.5f;
		nbrOfMonsters = monsterList.size();
		monstersOnGameBoard = new LinkedList<AbstractMonster>();
		monstersInWave = new LinkedList<>(monsterList);
		
	}
	
	
	public void move() {
		Timer.tick();
		if(spawnedMonsters < nbrOfMonsters && timer.getTime() > intervall){
			createMonsters();
			spawnedMonsters++;
			timer.set(0);
		}
			for(Iterator<AbstractMonster> it = monstersOnGameBoard.iterator(); it.hasNext();){
				AbstractMonster m = it.next();
				if(m.isAlive()){
					m.move();
				}else{
					it.remove();
				}
			}
	}
	
	public void draw(){
		for (AbstractMonster m : monstersOnGameBoard){
			m.draw();
		}
	}
	
	public void createMonsters(){
			AbstractMonster tempoMonster = monstersInWave.get(spawnedMonsters);
			monstersOnGameBoard.add(tempoMonster);
	}
	
	public List<AbstractMonster> getmonstersOnGameBoard(){
		return monstersOnGameBoard;
	}
	
	public List<AbstractMonster> getmonstersInWave(){
		return monstersInWave;
	}
	
	public boolean isEmpty(){
		if(spawnedMonsters >= nbrOfMonsters){
			return monstersOnGameBoard.isEmpty();
		}else{
			return false;
		}
	}
			
}