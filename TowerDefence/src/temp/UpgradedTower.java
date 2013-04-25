package temp;

import java.util.ArrayList;


public class UpgradedTower extends Tower {

	public UpgradedTower(float x, float y, int range,
			ArrayList<AbstractProjectile> projectiles, int timer, int cost, int damage) {
		super(x, y, range, projectiles, timer, cost, damage);
	}
	
	@Override
	public void upgradeTower() {
		//No upgrade available
	}
	

}