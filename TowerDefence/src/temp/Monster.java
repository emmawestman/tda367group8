package temp;

import se.chalmers.slickTD.IMonsterView;
import se.chalmers.slickTD.Monster2View;
import se.chalmers.slickTD.MonsterView;

public class Monster extends AbstractMonster {

	public Monster(Road road, Player player){
		super(20, 1.35f, 50, 50,
				road, player, new MonsterView());
	}
}