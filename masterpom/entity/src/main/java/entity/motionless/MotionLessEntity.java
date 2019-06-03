package entity.motionless;

import entity.Entity;
import entity.PERMEABILITY;
import entity.Sprite;

 abstract class MotionLessEntity extends Entity{
	 /**
	  * instatiate a new montionless entity
	  * @param sprite
	  * associate the entity to its sprite
	  * @param permeability
	  * associate the entity to its permeability
	  */
	protected MotionLessEntity(Sprite sprite, PERMEABILITY permeability) {
		super(sprite, permeability);
	}
}
