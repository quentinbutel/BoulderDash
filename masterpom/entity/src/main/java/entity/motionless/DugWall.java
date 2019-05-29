package entity.motionless;

import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

class DugWall extends MotionLessEntity{
	
	private static final Sprite sprite = new Sprite('O', Sprite.world, 32, 16);

	protected DugWall() {
		super(sprite, PERMEABILITY.PENETRABLE);
		
	}

}
