package se.chalmers.towerdefence.controller;

import org.newdawn.slick.tiled.TiledMap;

/**
 * A singelton class to handle data between states
 * @author Jonathan, Oskar, Julia, Emma
 *
 */
public class LevelController {
	private static LevelController instance = null;
	private TiledMap map=null;
	private String mapName = null;
	
	private LevelController() {
		
	}
	
	public static LevelController getInstance() {
	      if(instance == null) {
	         instance = new LevelController();
	      }
	      return instance;
	 }


	public TiledMap getMap(){
		 return map;
	 }
	
	public void setMap(TiledMap map){
		this.map=map;
	 }
	
	public String getMapName(){
		 return mapName;
	 }
	
	public void setMapName(String mapName){
		this.mapName=mapName;
	 }
	 
}