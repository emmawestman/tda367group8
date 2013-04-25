package se.chalmers.towerdefence.model;

public interface ISquare {
	
//	public int[] getPosition();
	
	public int getX();
	
	public int getY();
	
	public int getLength();
	
	public boolean isBlocked();
	
	public boolean isRoad();
}