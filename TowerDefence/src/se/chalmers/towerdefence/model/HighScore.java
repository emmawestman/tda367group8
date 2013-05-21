package se.chalmers.towerdefence.model;

import java.io.Serializable;

public class HighScore implements Serializable {
	
	/**
	 * 
	 */
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