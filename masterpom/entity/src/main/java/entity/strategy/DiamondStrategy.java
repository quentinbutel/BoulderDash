package entity.strategy;

import entity.IMap;
import entity.mobile.MobileEntity;

public class DiamondStrategy extends FallingStrategy{
	public void strategy(MobileEntity mEntity, IMap map) {
		// if the currentPawn is above the player
		if ((mEntity.getPosition().y == map.getCharacter().getPosition().y - 1
				&& mEntity.getPosition().x == map.getCharacter().getPosition().x)
				|| mEntity.getPosition().equals(map.getCharacter().getPosition())) {
			mEntity.removemEntity();;
			map.decreaseDiamond();
			return;
		}
		super.strategy(mEntity, map);
	}
}
