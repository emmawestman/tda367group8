package se.chalmers.towerdefence.model.monsters;

import se.chalmers.towerdefence.model.Player;
import se.chalmers.towerdefence.model.Road;

/** 
 * A class used to create a enemy of the type Monster.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */

public class Monster extends AbstractMonster {

	public Monster(Road road, Player player){
		super(20, 1.35f, 50, 50,
				road, player, 1);
	}
}