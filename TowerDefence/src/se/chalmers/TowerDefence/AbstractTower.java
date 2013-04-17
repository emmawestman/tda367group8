package se.chalmers.TowerDefence;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AbstractTower {
	private float xPos;
	private float yPos;
	private Image image;
	private int range;
	private int timer=30;
	private ArrayList <Projectile> projectiles;

	public AbstractTower(float x, float y, int range, ArrayList <Projectile> projectiles) throws SlickException {
		this.xPos = x*40;
		this.yPos = y*40;
		this.range = range;
		this.projectiles = projectiles;
		image = new Image("res/tower.gif");
	}
	
	public void draw() {
		image.draw(xPos,yPos);
		if(!projectiles.isEmpty()){
			for(Projectile p : projectiles){
				p.draw();
			}
		}
	}
	
	public void tryShoot(ArrayList<Wave> waves) throws SlickException {
		if(timer==10){
			for(Wave w : waves){
				for(Monster m: w.getMonsterWave()){
					if(m.getX()>=xPos-range && m.getX()<=xPos+range && m.getY()>=yPos-range && m.getY()<=yPos+range){
						Projectile p=new Projectile(xPos,yPos,m);
						projectiles.add(p);
					}
				}
				
			}			
		}		
		timer--;
		if(timer<=0){
			timer=30;
		}
		
	}

}
