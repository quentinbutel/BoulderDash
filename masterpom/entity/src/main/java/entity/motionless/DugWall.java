package entity.motionless;

import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;
/**
 * the class DugWall
 * @author Quentin
 *
 */
class DugWall extends MotionLessEntity{
	
	/**
	 * creates a new dugwall
	 */
	private static final Sprite sprite = new Sprite('O', Sprite.world, new Rectangle (32, 0, 16, 16));

	/**
	 * change the permeability to penetrable
	 */
	protected DugWall() {
		super(sprite, PERMEABILITY.PENETRABLE);
		
	}

}
