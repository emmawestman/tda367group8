package se.chalmers.towerdefence.model;

import java.io.Serializable;
/**
 * A class used to save a point as a high score. The levelName is used to determined which 
 * level the high score belongs to.
 * @auther Emma, Julia, Oskar, Jonathan
 * 
 */

public class HighScore implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private final int points;
	private final String levelName;
	
	public HighScore (int points, String levelName) {
		this.points = points;
		this.levelName = levelName;
	}
	public int getPoints() {
		return points;
	}
	
	public String getLevelName() {
		return levelName;
	}
	

}