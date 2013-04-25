package se.chalmers.TowerDefence;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.slickTD.TowerView;

public abstract class AbstractTower {
	private float xPos;
	private float yPos;
	private TowerView tV;
	private int range;
	private int timer;
	private ArrayList <AbstractProjectile> projectiles;
	private int cost;
	private int damage;

	public AbstractTower(float x, float y, int range, ArrayList <AbstractProjectile> projectiles, int timer, int cost, int damage) {
		this.xPos = x*40;
		this.yPos = y*40;
		this.range = range;
		this.projectiles = projectiles;
		tV=new TowerView();
		this.timer = timer;
		this.cost = cost;
		this.damage = damage;
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
						Projectile p=new Projectile(xPos, yPos, m, damage);
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
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public int getRange() {
		return range;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public ArrayList<AbstractProjectile> getProjectiles() {
		return projectiles;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public boolean monsterInRange(AbstractMonster m) {
		return (m.getX()>=xPos-range && m.getX()<=xPos+range && m.getY()>=yPos-range && m.getY()<=yPos+range);
	}
	
	public int sellTower() {
		return (int) (this.getCost()*0.5);
	}
	
	public abstract void upgradeTower();

}
