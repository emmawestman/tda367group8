package se.chalmers.towerdefence.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A class to control all waves in a level.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */
public class WaveController {

	private List<Wave> waves;
	private List <Wave> wavesOnGameBoard;
	private int timer;
	private boolean hasStarted;
	private int counter;


	public WaveController (Road road, Player player, String [] allWavesSplited) {
		timer = 1000;
		counter = 0;
		waves = new LinkedList<Wave>();
		waves = createWaves(road, player, allWavesSplited);
		wavesOnGameBoard = new LinkedList<Wave>();
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
	
	public boolean wavesOnGameboardHasSentAll(){
		boolean hasSentAll = true;
		for(Wave w : wavesOnGameBoard){
			if(!w.hasSentAllMonsters()){
				hasSentAll = false;
			}
		}
		if(counter < waves.size()){
			return hasSentAll;
		}else{
			return false;
		}
	}

	
	public boolean allWavesAreDone(){
		if(counter >= waves.size() && wavesOnGameBoard.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	public List<Wave> createWaves (Road road, Player player, String [] allWaves) {

		for (int i = 0; i<allWaves.length; i++) {
			List<AbstractMonster> monsterList;
			monsterList = new LinkedList<AbstractMonster>();
			for (int j = 0; j<allWaves[i].length(); j++) {
				int monsterType = allWaves[i].charAt(j);
				AbstractMonster monster = (AbstractMonster) createNewMonster(monsterType, road, player);
				monsterList.add(monster);
			}
			waves.add(new Wave(monsterList));
		}
		return waves;
	}

	public AbstractMonster createNewMonster (int monsterType, Road road, Player player) 
			throws NullPointerException{
		switch (monsterType) {
		case 49: 
			return new Monster(road, player);

		case 50: 
			return new MonsterFreezingImmune(road, player);

		case 51: 
			return new MonsterBurningImmune(road, player);

		default:
			throw new NullPointerException();
		}

	}
	public int getCounter() {
		return counter;
	}
	
	public int getNbrOfWaves() {
		return waves.size();
	}
	
	public int getTimer() {
		return timer;
	}
}