package se.chalmers.towerdefence.model;

public interface ISquare {
	
//	public int[] getPosition();
	
	public int getX();
	
	public int getY();
	
	public int getWidth();
	
	public int getHeight();
	
	public boolean isBlocked();
	
	public boolean isRoad();
}