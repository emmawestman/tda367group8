package se.chalmers.TowerDefence;

import java.awt.List;
import java.util.Observable;
import java.util.Observer;

public class Wave implements Observer{
	private List<AbstractMonster> monsterWave;
	private Road road;
	
	public Wave(int nbrOfMonsters, Road road) {
		createMonsters(nbrOfMonsters);
	}
	
	public void move() {
		for (int i=0; i>monsterWave.size(); i++) {
			if(monsterWave != null){
				monsterWave.get(i).move();
			}
			
		}
	}
	public void createMonsters(int nbrOfMonsters) {
		for (int i=0; i<nbrOfMonsters; i++) {
			monsterWave.add(i, new AbstractMonster(road, this));
		}
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
	
