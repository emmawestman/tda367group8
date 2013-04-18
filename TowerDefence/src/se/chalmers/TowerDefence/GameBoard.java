package se.chalmers.TowerDefence;

import se.chalmers.slickTD.GameBoardController;

public class GameBoard {

	private final ISquare[][] gameBoard;
	
	/*
	public GameBoard(){
	 gameBoard = new int[][]{
				new int[]{1,0,0,0,0},
				new int[]{1,1,1,1,0},
				new int[]{1,1,0,1,0},
				new int[]{1,1,0,1,0},
				new int[]{1,1,0,1,0},
				new int[]{0,0,0,0,0}};

	}//*/
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
	
//	public int[] getFirstRoadSquare(){
//		return null;
//	}
	
	/*
	@Override
	public String toString(){
		String temp=new String();
		for(int i=0; i<gameBoard.length;i++){
			for(int j=0; j<gameBoard.length;j++){
				temp+=gameBoard[i][j]+" ";
			}
			temp+="\n";
		}
		
		return temp;	
	}
	*/
}
