package entity.strategy;

import entity.IMap;
import entity.mobile.MobileEntity;

public interface IStrategy {
	public void strategy(MobileEntity mEntity, IMap map);
}
