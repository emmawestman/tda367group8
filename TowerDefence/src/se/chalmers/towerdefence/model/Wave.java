package se.chalmers.towerdefence.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.lwjgl.util.Timer;

import temp.Monster;
import temp.Player;
import temp.Road;

public class Wave {
	private List <AbstractMonster> monstersOnGameBoard;
	private List <AbstractMonster> monstersInWave;
	private int spawnedMonsters;
	private Timer timer; 
	private final float intervall;	
	
	public Wave(int nbrOfMonsters, Road road, Player player){
		timer = new Timer();
		intervall = 0.5f;
		monstersOnGameBoard = new LinkedList<AbstractMonster>();
		monstersInWave = new LinkedList<AbstractMonster>();
		for(int i = 0; i < nbrOfMonsters; i++){
			monstersInWave.add(new Monster(road, player));
		}
	}
	
	public Wave(List<AbstractMonster> monsterList){
		timer = new Timer();
		intervall = 0.5f;
		monstersOnGameBoard = new LinkedList<AbstractMonster>();
		monstersInWave = new LinkedList<AbstractMonster>(monsterList);
		
	}
	
	
	public void move() {
		Timer.tick();
		if(spawnedMonsters < monstersInWave.size() && timer.getTime() > intervall){
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
		if(spawnedMonsters >= monstersInWave.size()){
			return monstersOnGameBoard.isEmpty();
		}else{
			return false;
		}
	}
	
	public boolean hasSentAllMonsters(){
		return spawnedMonsters >= monstersInWave.size();
	}
		
			
}