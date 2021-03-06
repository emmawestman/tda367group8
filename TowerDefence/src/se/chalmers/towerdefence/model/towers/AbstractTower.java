package se.chalmers.towerdefence.model.towers;

import java.util.List;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.wave.Wave;
 /**
  * An abstract class that represents a tower.
  * @author Julia, Jonathan, Emma, Oskar
  *
  */

public abstract class AbstractTower implements GameBoardObject{
	private float xPos;
	private float yPos;
	private int range;
	private int timer;
	private int reloadTime;
	private List <GameBoardObject> projectiles;
	private int cost;
	private int damage;
	protected enum Priorities {FIRST, WEAKEST, ALL};
	private Priorities priority;
	private boolean isShooting;
	private boolean exists = true;
	private int ID = 0;
	private int width;
	private int height;
	
	private boolean isClicked;

	public AbstractTower(float x, float y, List <GameBoardObject> projectiles, int squareHeight, int squareWidth) {
		this.xPos = x*squareWidth;
		this.yPos = y*squareHeight;
		this.projectiles = projectiles;
		this.timer = 0;
		this.isShooting = false;
		this.width = squareWidth;
		this.height = squareHeight;
		this.isClicked = false;
	}


	public void tryShoot(List<Wave> waves) {
		if(timer<=0){
			if(priority == Priorities.FIRST){
				shootFirst(waves);
			}else if(priority == Priorities.WEAKEST){
				shootWeakest(waves);
			}else if(priority == Priorities.ALL) {
				shootAll(waves);
			}
		}		
		timer--;
		if(timer >= reloadTime - 5){
			isShooting = true;
		}else{
			isShooting = false;
		}
	}

	private void shootFirst(List<Wave> waves){
		outerloop:
			for(Wave w : waves){
				for(AbstractMonster m: w.getMonstersOnGameBoard()){
					if(monsterInRange(m)){
						addProjectile(xPos, yPos, m, damage, projectiles, waves);
						timer = reloadTime;
						break outerloop;
					}
				}
			}			
	}

	private void shootWeakest(List<Wave> waves) {
		AbstractMonster targetMonster = null;
		for(Wave w : waves){
			for(AbstractMonster m: w.getMonstersOnGameBoard()){
				if(monsterInRange(m)){
					if(targetMonster == null){
						targetMonster = m;
					}else if(m.getLife() < targetMonster.getLife()){
						targetMonster = m;
					}
				}
			}
		}
		if(targetMonster != null){
			addProjectile(xPos, yPos, targetMonster, damage, projectiles, waves);
			timer = reloadTime;
		}
	}

	private void shootAll(List<Wave> waves) {
		outerloop:
			for(Wave w : waves){
				for(AbstractMonster m: w.getMonstersOnGameBoard()){
					if(monsterInRange(m)){
						addProjectile(xPos, yPos, m, damage, projectiles, waves);
						timer = reloadTime;
						break outerloop;
					}
				}
			}
		
	}

	public abstract void addProjectile(float xPos, float yPos, AbstractMonster monster, int damage, List<GameBoardObject> projectiles, List<Wave> waves);

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

	public int getReloadTime() {
		return reloadTime;
	}

	public boolean isShooting(){
		return isShooting;
	}

	public List<GameBoardObject> getProjectiles() {
		return projectiles;
	}

	public int getDamage() {
		return damage;
	}

	public void addRange(int range) {
		this.range += range;
	}

	public void addDamage(int damage) {
		this.damage += damage;
	}

	public void addCost(int cost) {
		this.cost += cost;
	}

	public void decreaseReloadTime(int reloadTime) {
		this.reloadTime -= reloadTime;
	}

	public boolean monsterInRange(AbstractMonster m) {
		int xDistance = (int)((m.getX() + width/2) - (xPos + width/2));
		int yDistance = (int)((m.getY() + height/2) - (yPos + height/2));
		
		return range > Math.sqrt( Math.pow(xDistance, 2) +  Math.pow(yDistance, 2));
	}

	public int sellTower() {
		exists = false;
		return (int) (this.getCost()*0.5);

	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	public boolean exists() {
		return exists;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setPriority(Priorities priority) {
		this.priority = priority;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setClicked(boolean isClicked){
		this.isClicked = isClicked;
	}
	
	public boolean getClicked(){
		return isClicked;
	}
	public abstract void upgradeTower();

	public abstract int getUpgradeCost();
	
	public abstract int getUpgrades();
}