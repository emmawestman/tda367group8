package se.chalmers.towerdefence.controller;

import se.chalmers.towerdefence.files.FileHandler;
/**
 * A class to read a string from file. The string represents all waves on a level.
 * This class splits the string around : and puts the waves into a filed of strings, 
 * each string representing one wave.
 * @author Jonatham, Oskar, Julia, Emma
 *
 */


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