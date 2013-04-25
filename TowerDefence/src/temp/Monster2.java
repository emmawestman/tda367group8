package temp;

import se.chalmers.towerdefence.gui.Monster2View;
import se.chalmers.towerdefence.gui.MonsterView;
import se.chalmers.towerdefence.model.AbstractMonster;

//TODO Better name
public class Monster2 extends AbstractMonster{
	public Monster2(Road road, Player player){
		super(25, 1.15f, 70, 75,
				road, player, new Monster2View());
	}
}