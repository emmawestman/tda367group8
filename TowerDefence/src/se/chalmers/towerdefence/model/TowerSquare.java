package se.chalmers.towerdefence.model;

public class TowerSquare implements ISquare {
	private AbstractTower tower;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public TowerSquare(int x, int y, int squareHeight, int squareWidth, AbstractTower tower){
		width = squareWidth;
		height = squareHeight;
		this.x = x*width;
		this.y = y*height;
		this.tower = tower;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public boolean isBlocked() {
		return true;
	}

	@Override
	public boolean isRoad() {
		return false;
	}
	
	public AbstractTower getTower() {
		return tower;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
