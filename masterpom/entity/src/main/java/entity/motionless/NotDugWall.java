package entity.motionless;



import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

class NotDugWall extends MotionLessEntity{
	/**
	 * creates a new notdugwall
	 */
	private static final Sprite sprite = new Sprite('W',  Sprite.world, new Rectangle (16, 0, 16, 16));

	/**
	 * change the permeability to mineable
	 */
	protected NotDugWall() {
		super(sprite, PERMEABILITY.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
