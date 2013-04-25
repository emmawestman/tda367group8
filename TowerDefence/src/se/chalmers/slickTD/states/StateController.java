package se.chalmers.slickTD.states;

import se.chalmers.TowerDefence.Player;

public class StateController {
	private StateBasedMain sbm;
	private Player player;
	
	private static StateController instance = null;
	   
	private StateController() {
	      sbm=new StateBasedMain();
	 }
	   
	private StateController(StateBasedMain sbm) {
		this.sbm=sbm;
	}

	public static StateController getInstance() {
	      if(instance == null) {
	         instance = new StateController();
	      }
	      return instance;
	 }
	   
	 public static void setInstance(StateBasedMain sbm) {
	   if(instance == null) {
	      instance = new StateController(sbm);
	   }
	 }

	 public StateBasedMain getStateBasedMain(){
		 return sbm;
	 }

	public void setPlayer(Player player) {
		this.player=player;
	}
	public Player getPlayer() {
		return player;
	}
	
	 
}
