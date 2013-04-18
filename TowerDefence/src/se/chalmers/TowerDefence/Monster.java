package se.chalmers.TowerDefence;

import se.chalmers.slickTD.MonsterView;

public class Monster extends AbstractMonster {

	public Monster(Road road, Player player){
		super(road, player, new MonsterView());
	}
}
