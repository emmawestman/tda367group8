package se.chalmers.towerdefence.controller;

import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.model.interfaces.ISquare;
import se.chalmers.towerdefence.model.squares.BuildableSquare;
import se.chalmers.towerdefence.model.squares.RoadSquare;
import se.chalmers.towerdefence.model.squares.UnbuildableSquare;

/**
 * A Class to convert a TiledMap to a ISquare[][]
 * @author Jonathan, Oskar, Julia, Emma
 *
 */

public class GameBoardUtil {
	
	public static ISquare[][] convertTiledMap(TiledMap map, int resolutionHeight, int resolutionWidth){
		ISquare[][] gameBoard;
		gameBoard = new ISquare[map.getWidth() + 1 ][map.getHeight() + 1 ];
		int squareHeight = resolutionHeight/(gameBoard[0].length-1);
		int squareWidth = resolutionWidth/(gameBoard.length-1);
		for(int i = 0; i < gameBoard.length; i++){
			for(int j = 0; j<gameBoard[i].length; j++){
				 gameBoard[i][j] = new BuildableSquare(i, j, squareHeight, squareWidth);
			}
		}
		for (int xAxis = 0; xAxis < map.getWidth(); xAxis++){
	             for (int yAxis = 0; yAxis < map.getHeight(); yAxis++){
	                 int tileID = map.getTileId(xAxis, yAxis, 0);
	                 String value = map.getTileProperty(tileID, "road", "false");
	                 if ("true".equals(value)){
	                     gameBoard[xAxis][yAxis] = new RoadSquare(xAxis, yAxis, squareHeight, squareWidth);
	                 }
	                 value = map.getTileProperty(tileID, "unbuildable", "false");
	                 if ("true".equals(value)){
	                     gameBoard[xAxis][yAxis] = new UnbuildableSquare(xAxis, yAxis, squareHeight, squareWidth);
	                 }
	             }
		}
	
		return gameBoard;			
	}
	
}