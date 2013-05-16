package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

import se.chalmers.towerdefence.model.AbstractProjectile;
/**
 * A class with the responsibility to draw a projectile
 * @author Jonathan
 *
 */
public class ProjectileView implements IView{
	private Image image;
	private AbstractProjectile projectile;
	public ProjectileView(AbstractProjectile projectile){
		image = ResourceHandler.getInstance().getAppleImage();
		this.projectile=projectile;
	}
	
	public void draw(){
		image.draw(projectile.getX(),projectile.getY());
		image.rotate(1f);
	}

	public AbstractProjectile getProjectile() {
		return projectile;
	}
	public boolean exists(){
		return projectile.exists();
	}
}