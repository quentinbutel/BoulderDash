package entity.motionless;



import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

class NotDugWall extends MotionLessEntity{
	
	private static final Sprite sprite = new Sprite('W',  Sprite.world, new Rectangle (16, 0, 16, 16));

	protected NotDugWall() {
		super(sprite, PERMEABILITY.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
