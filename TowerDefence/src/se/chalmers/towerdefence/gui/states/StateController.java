package se.chalmers.towerdefence.gui.states;

import se.chalmers.towerdefence.model.Level;

public class StateController {
	private Level level=null;
	private static StateController instance = null;
	
	private StateController() {
		//TODO fix this so that you can create with out a level
	}
	      
	
	private StateController(Level lvl) {
		this.level=lvl;
	}

	public static StateController getInstance() {
	      if(instance == null) {
	         instance = new StateController();
	      }
	      return instance;
	 }
	   
	 public static StateController getInstance(Level lvl) {
	   if(instance == null) {
	      instance = new StateController(lvl);
	   }
	   return instance;
	 }
	 
	 public Level getLevel(){
		 return level;
	 }

	
	 
}