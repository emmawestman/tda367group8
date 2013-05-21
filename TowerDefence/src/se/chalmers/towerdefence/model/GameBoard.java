package se.chalmers.towerdefence.model;


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
	public void addTower(int x, int y, AbstractTower tower) {
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
