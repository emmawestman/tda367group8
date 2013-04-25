package temp;

import java.io.Serializable;

public class HighScore implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int points;
	private String levelName;
	
	public HighScore (int points, String levelName) {
		this.points = points;
		this.levelName = levelName;
	}
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getLevelName() {
		return levelName;
	}
	
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

}