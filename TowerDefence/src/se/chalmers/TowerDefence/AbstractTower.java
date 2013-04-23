package se.chalmers.TowerDefence;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.slickTD.TowerView;

public class AbstractTower {
	private float xPos;
	private float yPos;
	private TowerView tV;
	private int range;
	private int timer;
	private ArrayList <Projectile> projectiles;
	private int cost;

	public AbstractTower(float x, float y, int range, ArrayList <Projectile> projectiles, int timer, int cost) {
		this.xPos = x*40;
		this.yPos = y*40;
		this.range = range;
		this.projectiles = projectiles;
		tV=new TowerView();
		this.timer = timer;
		this.cost = cost;
	}
	
	public void draw() {
		tV.draw(xPos,yPos);
	}
	
	public void tryShoot(List<Wave> waves) {
		if(timer==20){
			outerloop:
			for(Wave w : waves){
				for(AbstractMonster m: w.getmonstersOnGameBoard()){
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
	
	public int getCost() {
		return cost;
	}
	
	public boolean monsterInRange(AbstractMonster m) {
		return (m.getX()>=xPos-range && m.getX()<=xPos+range && m.getY()>=yPos-range && m.getY()<=yPos+range);
	}

}
