package se.chalmers.towerdefence.model;

public class TowerSquare implements ISquare {
	private AbstractTower tower;
	private int x;
	private int y;
	private int length;
	
	public TowerSquare(int x, int y, AbstractTower tower){
		length = 40;
		this.x = x*length;
		this.y = y*length;
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
	public int getLength() {
		return length;
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

}
