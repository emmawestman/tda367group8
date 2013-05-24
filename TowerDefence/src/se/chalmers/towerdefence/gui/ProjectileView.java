package se.chalmers.towerdefence.gui;

import org.newdawn.slick.Image;

import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
/**
 * A class with the responsibility to draw a projectile
 * @author Jonathan
 *
 */
public class ProjectileView implements IView{
	private Image image;
	private AbstractProjectile projectile;
	private int height;
	private int width;
	
	public ProjectileView(AbstractProjectile projectile, int width, int height){
		this.projectile = projectile;
		this.width = width;
		this.height = height;
		int ID = projectile.getID();
		ResourceHandler rH = ResourceHandler.getInstance();
		switch (ID) {
		case 1: image=rH.getAppleImage();
		break;
		case 2: image=rH.getAcorn();
		break;
		case 3: image=rH.getLaserProjectile();
		break;		
		case 4: image=rH.getSnowball();
		break;
		case 5: image=rH.getPoison();
		break;
		case 6: image=rH.getFire();
		break;
		}
	}
	
	public void draw(){
		image.draw(projectile.getX(),projectile.getY(), width, height);
		image.rotate(1f);
	}

	public AbstractProjectile getProjectile() {
		return projectile;
	}
	public boolean exists(){
		return projectile.exists();
	}
	
	public void setResolution(int width, int height){
		this.height = height;
		this.width = width;
	}

}