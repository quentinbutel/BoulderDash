package entity.strategy;

import entity.ControllerOrder;
import entity.IMap;
import entity.PERMEABILITY;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;

public abstract class FallingStrategy implements IStrategy{
	public void strategy(MobileEntity mEntity, IMap map) {
		if (mEntity.canMove(ControllerOrder.Down)) {
			mEntity.moveDown();
		} else {

			// if not, check if he can fall on the sides
			for (IMobile mEntities : map.getmEntity()) {

				// if there is a mobile under mobile
				if (mEntity.getPosition().y == mEntities.getPosition().y - 1 && mEntity.getPosition().x == mEntities.getPosition().x) {

					// if the current mobile can go to left
					if (mEntity.canMove(ControllerOrder.Left)) {

						// if the current mobile can go slide to the left to fall
						if (map.getSquareIsOccupiedXY(mEntities.getPosition().x - 1, mEntities.getPosition().y) == PERMEABILITY.PENETRABLE) {
							mEntity.moveLeft();
							return;
						}
					}

					// if the current mobile can go to right
					if (mEntity.canMove(ControllerOrder.Right)) {

						// if the current mobile can go slide to the right to fall
						if (map.getSquareIsOccupiedXY(mEntities.getPosition().x + 1,
								mEntities.getPosition().y) == PERMEABILITY.PENETRABLE) {
							mEntity.moveRight();
							return;
						}
					}
				}
			}
			mEntity.immobile();;
		}
	}
}
