package se.chalmers.towerdefence.model;
/**
 * A class to handle the lives, points and recourses a user has during a level. 
 * @author Emma, Julia, Oskar, Jonathan
 *
 */

public class Player {
	
	private int lives;
	private int points = 0;
	private int resources;
	
	public Player(int lives, int resources) {
		this.lives = lives;
		this.resources = resources;
	}
	
	public void looseLife() {
		lives--;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public void addResources(int resources) {
		this.resources += resources;
	}
	
	public void useResources(int cost) {
		resources -= cost ;
	}
	
	public int getLives() {
		return lives;
	}
	
	public int getResources() {
		return resources;
	}
	
	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString(){
		return ("Lives: "+lives+" Resources:"+ resources+" Points:"+points);
	}

}