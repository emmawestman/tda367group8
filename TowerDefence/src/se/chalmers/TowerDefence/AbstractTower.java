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
	}
	
	public void tryShoot(ArrayList<Wave> waves) throws SlickException {
		if(timer==20){
			outerloop:
			for(Wave w : waves){
				for(AbstractMonster m: w.getMonsterWave()){
					if(monsterInRange(m)){
						Projectile p=new Projectile(xPos,yPos,m);
						projectiles.add(p);
						break outerloop;
					}
				}
			}			
		}		
		timer--;
		if(timer<=0){
			timer=60;
		}
		
	}
	
	public boolean monsterInRange(AbstractMonster m) throws SlickException {
		return (m.getX()>=xPos-range && m.getX()<=xPos+range && m.getY()>=yPos-range && m.getY()<=yPos+range);
	}

}
