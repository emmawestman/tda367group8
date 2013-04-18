package se.chalmers.slickTD;

import org.newdawn.slick.Font;

import se.chalmers.TowerDefence.Player;

public class PlayerView {
	Player player;
	Font font;
	
	public PlayerView(Player player) {
		this.player=player;
	}

	public void draw(){
		font.drawString(100f, 100f, player.toString());		
	}

}
