package se.chalmers.towerdefence.controller;

import se.chalmers.towerdefence.files.FileHandler;


public class WaveSplitController {
	private String [] allWavesSplit;
	
	public WaveSplitController (String textFileName) {
		FileHandler fh = new FileHandler();
		String allWaves = fh.getWavesFromFile(textFileName);
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