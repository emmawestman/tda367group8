package se.chalmers.TowerDefence;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class Tower extends AbstractTower{

	public Tower(float x, float y, int range, ArrayList <Projectile> projectiles) throws SlickException {
		super(x,y,range, projectiles);
	}

	
}
