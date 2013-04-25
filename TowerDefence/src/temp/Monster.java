package temp;

import se.chalmers.towerdefence.gui.IMonsterView;
import se.chalmers.towerdefence.gui.Monster2View;
import se.chalmers.towerdefence.gui.MonsterView;
import se.chalmers.towerdefence.model.AbstractMonster;

public class Monster extends AbstractMonster {

	public Monster(Road road, Player player){
		super(20, 1.35f, 50, 50,
				road, player, new MonsterView());
	}
}