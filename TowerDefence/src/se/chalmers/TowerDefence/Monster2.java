package se.chalmers.TowerDefence;

import se.chalmers.slickTD.Monster2View;

//TODO Better name
public class Monster2 extends AbstractMonster{
	public Monster2(Road road, Player player){
		super(road, player, new Monster2View());
	}
}
