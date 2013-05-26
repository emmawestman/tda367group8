package se.chalmers.towerdefence.model.squares;

import se.chalmers.towerdefence.model.interfaces.ISquare;

/**
 * A square where nothing can be built.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public class UnbuildableSquare  implements ISquare{

	private final int x;
	private final int y;
	private final int width;
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
		return true;
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