package se.chalmers.towerdefence.model.monsters;
/**
 * A class to represent a monster of the type boss which is a super monster 
 * meaning a monster that is harder to kill then the other monsters.
 * @author Emma, Julia, Oskar, Jonathan
 */

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
		super(5000, 1f, 300, 300, road, player, ID);
	}
	
	@Override
	public void playerLooseLife() {
		for(int i = 0; i < 6; i++) {
			getPlayer().looseLife();
		}
	}

}
