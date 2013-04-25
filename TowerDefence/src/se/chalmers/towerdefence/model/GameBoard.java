package se.chalmers.towerdefence.model;

import se.chalmers.towerdefence.gui.GameBoardController;

public class GameBoard {

	private final ISquare[][] gameBoard;
	
	public GameBoard(GameBoardController gbc){
		gameBoard=gbc.getGameBoard();		
	}
	
	public ISquare[][] getGameBoard(){
		//TODO;
		return gameBoard;
	}

	public int getTile(int mouseX) {		
		return mouseX/40;
	}
	public boolean isBlocked(int x, int y) {
		return gameBoard[x][y].isBlocked();
	}
	public void addTower(int x, int y) {
		if(!gameBoard[x][y].isBlocked()){
			BuildableSquare tempSquare = (BuildableSquare)gameBoard[x][y];
			tempSquare.toggleIsBlocked();
		}
		
	}

}
