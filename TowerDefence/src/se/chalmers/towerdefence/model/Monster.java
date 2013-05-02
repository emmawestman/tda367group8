package se.chalmers.towerdefence.model;

public class Monster extends AbstractMonster {

	public Monster(Road road, Player player){
		super(20, 1.35f, 50, 50,
				road, player, 1);
	}
}