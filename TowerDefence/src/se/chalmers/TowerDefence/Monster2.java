package se.chalmers.TowerDefence;

import se.chalmers.slickTD.Monster2View;
import se.chalmers.slickTD.MonsterView;

//TODO Better name
public class Monster2 extends AbstractMonster{
	public Monster2(Road road, Player player){
		super(25, 1.15f, 70, 75,
				road, player, new Monster2View());
	}
}
