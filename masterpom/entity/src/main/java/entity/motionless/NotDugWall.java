package entity.motionless;

import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

class NotDugWall extends MotionLessEntity{
	
	private static final Sprite sprite = new Sprite('D',  Sprite.world, new Rectangle(16, 0, 16, 16));

	protected NotDugWall() {
		super(sprite, PERMEABILITY.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
