package se.chalmers.towerdefence.gui;

import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.model.BuildableSquare;
import se.chalmers.towerdefence.model.ISquare;
import se.chalmers.towerdefence.model.RoadSquare;

public class GameBoardController {
	
	private final ISquare[][] gameBoard;
	
	public GameBoardController(TiledMap map){
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
	
	public ISquare getSquare(int x, int y) {
		return gameBoard[x][y];
	}
	
	public ISquare[][] getGameBoard(){
		return gameBoard;			
	}
	
}