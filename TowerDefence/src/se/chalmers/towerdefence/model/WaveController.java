package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class WaveController {
	
	private List<Wave> waves;
	private List <Wave> wavesOnGameBoard;
	private int timer;
	private boolean hasStarted;
	private Road road;
	private Player player;
	private int counter;
	
	public WaveController (Road road, Player player) {
		timer = 1000;
		this.road = road;
		this.player = player;
		counter = 0;
		
		
		//TODO get the waves from file
		waves = new ArrayList<Wave>();
		List<AbstractMonster> monsterList = new LinkedList<AbstractMonster>();
		monsterList.add(new Monster(road, player));
		monsterList.add(new Monster(road, player));
		monsterList.add(new Monster2(road, player));
		monsterList.add(new Monster2(road, player));
		monsterList.add(new Monster(road, player));
		monsterList.add(new Monster(road, player));
		monsterList.add(new Monster2(road, player));
		monsterList.add(new Monster2(road, player));
		monsterList.add(new Monster(road, player));
		monsterList.add(new Monster(road, player));
		monsterList.add(new Monster2(road, player));
		monsterList.add(new Monster2(road, player));
		
		List<AbstractMonster> monsterList2 = new LinkedList<AbstractMonster>();
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		monsterList2.add(new Monster(road, player));
		
		List<AbstractMonster> monsterList3 = new LinkedList<AbstractMonster>();
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		monsterList3.add(new Monster2(road, player));
		
		waves.add(new Wave(monsterList));
		waves.add(new Wave(monsterList2));
		waves.add(new Wave(monsterList3));
		
		wavesOnGameBoard = new LinkedList<Wave>();
//		Iterator<Wave> waveIteratorList = waves.iterator();
	}
	
	public void update(){
		if(!wavesOnGameBoard.isEmpty() && wavesOnGameBoard.get(wavesOnGameBoard.size()-1).hasSentAllMonsters() && hasStarted 
			|| hasStarted && wavesOnGameBoard.isEmpty()){
			timer--;
		}
		
		if(timer <= 0){
			timer = 1000;
			addNewWave();
		}
		for(Iterator<Wave> it = wavesOnGameBoard.iterator(); it.hasNext();){
			Wave w = it.next();
			if(w.isEmpty()){
				it.remove();
			}else{
				w.move();	
			}
		}
	}
	
	public void draw(){
		for(Wave w : wavesOnGameBoard){
			w.draw();
		}
	}
	
	private void addNewWave(){
		if(counter < waves.size()){
		wavesOnGameBoard.add(new Wave(waves.get(counter).getmonstersInWave()));
		counter++;
		}
	}
	
	public void startNewWave(){
		addNewWave();
		hasStarted = true;
	}
	
	public List<Wave> getWavesOnGameBoard(){
		return wavesOnGameBoard;
	}
	
	public boolean allWavesAreDone(){
		if(counter >= waves.size() && wavesOnGameBoard.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}