package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import se.chalmers.towerdefence.files.FileHandler;



public class WaveController {
	
	private List<Wave> waves;
	private List <Wave> wavesOnGameBoard;
	private int timer;
	private boolean hasStarted;
	private int counter;
	
	public WaveController (Road road, Player player) {
		timer = 1000;
		counter = 0;
		
		FileHandler fh = new FileHandler();
		String allWaves = fh.getWavesFromFile("level1.txt");
		int [] splitPoints = findSplitPoints(allWaves);
		String [] allWavesSplited = separateWaves(allWaves, splitPoints);
		waves = new ArrayList<Wave>();
		createWaves(allWavesSplited, road, player);
		wavesOnGameBoard = new LinkedList<Wave>();
	}
	public AbstractMonster createNewMonster (int monsterType, Road road, Player player) 
			throws NullPointerException{
		switch (monsterType) {
		case 49: 
			return new Monster(road, player);
		
		case 50: 
			return new Monster(road, player);
		
		case 51: 
			return new Monster(road, player);
		
		default:
			throw new NullPointerException();
		}
		
	}
	
	public String [] separateWaves (String allWaves, int [] splitPoints) {
		String [] splitedWaves = allWaves.split(":", splitPoints.length + 1);
		return splitedWaves;
	}
	
	public int [] findSplitPoints (String allWaves) {
		int [] splitPoints =  new int [3];
		for ( int i =0; i<allWaves.length(); i++) {
			if ((allWaves.charAt(i) + "").equals(":")) {
				int j = 0;
				splitPoints [j] = i;
				j++;
			}
		}
		return splitPoints;
	}

	public void createWaves (String [] allWaves, Road road, Player player) {
		
		for (int i = 0; i<allWaves.length; i++) {
			List<AbstractMonster> monsterList;
			monsterList = new LinkedList<AbstractMonster>();
			for (int j = 0; j<allWaves[i].length(); j++) {
				int monsterType = allWaves[i].charAt(j);
				Monster monster = (Monster) createNewMonster(monsterType, road, player);
				monsterList.add(monster);
			}
			waves.add(new Wave(monsterList));
		}
		

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
	
	public List <Wave> getWaves(){
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