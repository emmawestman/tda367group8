package se.chalmers.towerdefence.controller;

import se.chalmers.towerdefence.files.FileHandler;


public class WaveSplitController {
	private String [] allWavesSplit;
	
	public WaveSplitController () {
		FileHandler fh = new FileHandler();
		String allWaves = fh.getWavesFromFile("level1.txt");
		allWavesSplit = separateWaves(allWaves);
	}

	public String [] separateWaves (String allWaves) {
		String [] splitWaves = allWaves.split(":");
		return splitWaves;
	}

	
	
	public String [] getWaves() {
		return allWavesSplit;
	}
}