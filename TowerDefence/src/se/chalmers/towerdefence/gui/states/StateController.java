package se.chalmers.towerdefence.gui.states;

import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.towerdefence.model.Level;

public class StateController {
	private Level level=null;
	private static StateController instance = null;
	private TiledMap map=null;
	
	private StateController() {
		
	}
	
	public static StateController getInstance() {
	      if(instance == null) {
	         instance = new StateController();
	      }
	      return instance;
	 }
	 
	public void setLevel(Level lvl){
		 level=lvl;
	 }

	public TiledMap getMap(){
		 return map;
	 }
	
	public void setMap(TiledMap map){
		this.map=map;
	 }

	
	 public Level getLevel(){
		 return level;
	 }

	
	 
}