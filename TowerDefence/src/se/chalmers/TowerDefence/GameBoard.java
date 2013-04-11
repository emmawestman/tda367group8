package se.chalmers.TowerDefence;

public class GameBoard {

	private final int[][] gameBoard=new int[][]{
			new int[]{0,0,0,0,0,0},
			new int[]{1,1,1,0,0,0},
			new int[]{0,0,1,0,0,0},
			new int[]{0,0,1,1,1,0},
			new int[]{0,0,0,0,0,0}};
	public GameBoard(){}
	
	private int[][] findGameBoard(){
		//TODO
		//Get a gameBoard from a file
		return null;
	}
	public int[][] getGameBoard(){
		//TODO;
		return gameBoard;
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
