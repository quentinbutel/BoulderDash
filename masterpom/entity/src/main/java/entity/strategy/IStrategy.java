package entity.strategy;

import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;

public interface IStrategy {
	public void strategy(IMobile mEntity, IMap map);
}
