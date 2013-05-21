package se.chalmers.towerdefence.controller;

import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.model.Level;

/**
 * A singelton class to handle data between states
 * @author Jonathan
 *
 */
public class LevelController {
	//private Level level=null;
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
	 
//	public void setLevel(Level lvl){
//		 level=lvl;
//	 }

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
	
	

	
//	 public Level getLevel(){
//		 return level;
//	 }

	
	 
}