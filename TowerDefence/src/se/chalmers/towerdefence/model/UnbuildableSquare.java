package se.chalmers.towerdefence.model;

public class UnbuildableSquare  implements ISquare{

	private final int x;
	private final int y;
	private final int width;
	private boolean isBlocked = true;
	private final int height;
	
	public UnbuildableSquare(int x, int y, int squareHeight, int squareWidth){
		width = squareWidth;
		height = squareHeight;
		this.x = x * width;
		this.y = y * width;
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
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