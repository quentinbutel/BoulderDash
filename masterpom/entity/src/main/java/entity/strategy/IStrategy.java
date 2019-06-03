package entity.strategy;

import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;
/**
 * the interface IStrategy
 * @author All
 *
 */
public interface IStrategy {
	/**
	 * the Strategy for falling mEntities
	 * @param mEntity
	 * mobile Entity
	 * @param map
	 * our map
	 * @param y
	 * y
	 * @param x
	 * x
	 */
	public void strategy(IMobile mEntity, IMap map, int y, int x);
}
