package se.chalmers.towerdefence.controller;

import se.chalmers.towerdefence.files.FileHandler;


public class WaveSplitController {
	private String [] allWavesSplited;
	
	public WaveSplitController () {
		FileHandler fh = new FileHandler();
		String allWaves = fh.getWavesFromFile("level1.txt");
		int [] splitPoints = findSplitPoints(allWaves);
		allWavesSplited = separateWaves(allWaves, splitPoints);
		
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
	
	public String [] getWaves() {
		return allWavesSplited;
	}
}