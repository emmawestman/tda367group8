package se.chalmers.towerdefence.model;

//TODO Better name
public class Monster2 extends AbstractMonster{
	public Monster2(Road road, Player player){
		super(25, 1.15f, 70, 75,
				road, player, 2);
	}
}