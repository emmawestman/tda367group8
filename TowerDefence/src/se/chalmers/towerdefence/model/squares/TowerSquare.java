package se.chalmers.towerdefence.model.squares;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.interfaces.ISquare;

/**
 * A square that has a tower on it.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public class TowerSquare implements ISquare {
	private GameBoardObject tower;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public TowerSquare(int x, int y, int squareHeight, int squareWidth, GameBoardObject tower){
		width = squareWidth;
		height = squareHeight;
		this.x = x*width;
		this.y = y*height;
		this.tower =tower;
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
	
	public GameBoardObject getTower() {
		return tower;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
