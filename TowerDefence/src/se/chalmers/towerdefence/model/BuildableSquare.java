package se.chalmers.towerdefence.model;

/**
 * A square where towers can be build.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public class BuildableSquare implements ISquare{

	private final int x;
	private final int y;
	private final int width;
	private boolean isBlocked = false;
	private final int height;
	
	public BuildableSquare(int x, int y, int squareHeight, int squareWidth){
		width = squareWidth;
		height = squareHeight;
		this.x = x * width;
		this.y = y * height;
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public void toggleIsBlocked(){
		isBlocked = !isBlocked;
	}
	
	public boolean isRoad(){
		return false;
	}

	@Override
	public boolean isBlocked() {
		return isBlocked;
	}
	@Override
	public int getWidth() {
		return width;
	}
	@Override
	public int getHeight() {
		return height;
	}

}