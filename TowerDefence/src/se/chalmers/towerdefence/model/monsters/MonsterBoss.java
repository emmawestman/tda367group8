package se.chalmers.towerdefence.model.monsters;

import se.chalmers.towerdefence.model.Player;
import se.chalmers.towerdefence.model.Road;

public class MonsterBoss extends AbstractMonster {
	private static int ID = 4;

	public MonsterBoss(Road road, Player player) {
		super(1000, 1f, 300, 300, road, player, ID);
	}

}
