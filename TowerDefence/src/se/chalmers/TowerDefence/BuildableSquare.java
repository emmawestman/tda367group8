package se.chalmers.TowerDefence;

public class BuildableSquare implements ISquare{

	private final int x;
	private final int y;
	private final int length;
	private boolean isBlocked = false;
	
	public BuildableSquare(int x, int y){
		length = 40;
		this.x = x * length;
		this.y = y * length;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return isBlocked;
	}
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return length;
	}

}
