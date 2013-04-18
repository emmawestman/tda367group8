package se.chalmers.TowerDefence;

import org.newdawn.slick.tiled.TiledMap;

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
	public GameBoard(TiledMap map){
		gameBoard = new ISquare[map.getWidth() + 1 ][map.getHeight() + 1 ];
		
		for(int i = 0; i < gameBoard.length; i++){
			for(int j = 0; j<gameBoard[i].length; j++){
					 gameBoard[i][j] = new BuildableSquare(i, j);
			}
		}
		for (int xAxis = 0; xAxis < map.getWidth(); xAxis++){
		             for (int yAxis = 0; yAxis < map.getHeight(); yAxis++){
		                 int tileID = map.getTileId(xAxis, yAxis, 0);
		                 String value = map.getTileProperty(tileID, "road", "false");
		                 if ("true".equals(value)){
		                     gameBoard[xAxis][yAxis] = new RoadSquare(xAxis, yAxis);
		                 }
		             }
		 }
		
	}
	
	private int[][] findGameBoard(){
		//TODO
		//Get a gameBoard from a file
		return null;
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
			System.out.println("GameBoard: addTower");
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
