package entity.motionless;

import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

class Exit extends MotionLessEntity{
	
	private boolean isOpened = false;
	private static final Sprite sprite = new Sprite('S', Sprite.world, 96, 0);

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	protected Exit() {
		super(sprite, PERMEABILITY.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
