package se.chalmers.towerdefence.model;

import se.chalmers.towerdefence.model.interfaces.ISquare;

 /**
  * A class that holds all data representing an instance of a level.
  * @author Julia, Jonathan, Emma, Oskar
  *
  */

public class Level {


	private GameBoard gameBoard;
	private Road road;
	private Player player;
	private String mapName;


	public Level(ISquare[][] gB, int squareHeight, int squareWidth, String mapName) {
		gameBoard = new GameBoard(gB, squareHeight, squareWidth);
		road = new Road(gameBoard);
		player = new Player(20, 700);
		this.mapName = mapName;
	}

	public Player getPlayer(){
		return player;
	}

	public ISquare getSquare(int x, int y) {
		return gameBoard.getSquare(x, y);
	}

	public String getMapName() {
		return mapName;
	}
	
	public Road getRoad(){
		return road;
	}

	public GameBoard getGameBoard(){
		return gameBoard;
	}



}