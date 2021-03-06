package entity.strategy;

import java.awt.Point;

import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;
/**
 * the class DiamondStrategy
 * @author All
 *
 */
public class DiamondStrategy extends FallingStrategy{
	
	/**
	 * the Strategy for falling diamond
	 * @param mEntity
	 * mobile Entity
	 * @param map
	 * our map
	 * @param y
	 * y
	 * @param x
	 * x
	 */
	public void strategy(IMobile mEntity, IMap map, int y, int x) {
		//if a diamond is just above our character, then he recovers a diamond.
		if ((mEntity.getPosition().y == map.getCharacter().getPosition().y - 1
				&& mEntity.getPosition().x == map.getCharacter().getPosition().x)
				|| mEntity.getPosition().equals(map.getCharacter().getPosition())) {
			mEntity.setPosition(new Point(-1, -1));
			map.getmEntity().remove(mEntity);
			
			map.decreaseDiamond();
			map.addCompteur(200);
		}
		super.strategy(mEntity, map, y, x);
	}
}
