package se.chalmers.towerdefence.model;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.interfaces.ISquare;
import se.chalmers.towerdefence.model.squares.BuildableSquare;
import se.chalmers.towerdefence.model.squares.TowerSquare;

/**
 * A representation of the game board. Consists of squares.
 * @author Julia, Emma, Oskar, Jonathan
 *
 */
public class GameBoard {

	private final ISquare[][] gameBoard;
	private int squareHeight;
	private int squareWidth;
	
	public GameBoard(ISquare[][] gameBoard, int squareHeight, int squareWidth){
		this.gameBoard=gameBoard;	
		this.squareHeight = squareHeight;
		this.squareWidth = squareWidth;
	}
	
	public ISquare[][] getGameBoard(){
		//TODO;
		return gameBoard;
	}

	public int getTile(int mouseX) {		
		return mouseX/squareWidth;
	}
	public boolean isBlocked(int x, int y) {
		return gameBoard[x][y].isBlocked();
	}
	public void addTower(int x, int y, GameBoardObject tower) {
			gameBoard[x][y] = new TowerSquare(x, y, squareHeight, squareWidth, tower);
	}
	
	public ISquare getSquare(int x, int y) {
		return gameBoard[x][y];
	}

	public void sellTower(int x, int y) {
		gameBoard[x][y] = new BuildableSquare(x, y, squareHeight, squareWidth);
	}
	
	public int getSquareHeight() {
		return squareHeight;
	}
	
	public int getSquareWidth() {
		return squareWidth;
	}
	
}
