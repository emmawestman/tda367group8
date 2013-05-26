package se.chalmers.towerdefence.model.monsters;

import se.chalmers.towerdefence.model.Player;
import se.chalmers.towerdefence.model.Road;

/**
 * A monster that has more lives than the others. It also makes the player
 * loose five lives instead of one.
 * @author Julia, Oskar, Emma, Jonathan
 *
 */
public class MonsterBoss extends AbstractMonster {
	private static int ID = 4;

	public MonsterBoss(Road road, Player player) {
		super(1000, 1f, 300, 300, road, player, ID);
	}
	
	@Override
	public void die() {
		for(int i = 0; i < 6; i++) {
			getPlayer().looseLife();
		}
		setAlive(false);
	}

}
