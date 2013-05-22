package se.chalmers.towerdefence.model;

/**
 * An interface for squares.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public interface ISquare {
	
	public int getX();
	
	public int getY();
	
	public int getWidth();
	
	public int getHeight();
	
	public boolean isBlocked();
	
	public boolean isRoad();
}