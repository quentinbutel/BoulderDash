package entity.motionless;

import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

/**
 * the class UnbreakableWall
 * @author Quentin
 *
 */
class UnbreakableWall extends MotionLessEntity{
	private static final Sprite sprite = new Sprite('X',  Sprite.world, new Rectangle (0, 0, 16, 16));

	/**
	 * change the permeability to blocking
	 */
	protected UnbreakableWall() {
		super(sprite, PERMEABILITY.BLOCKING);
		// TODO Auto-generated constructor stub
	}

}
