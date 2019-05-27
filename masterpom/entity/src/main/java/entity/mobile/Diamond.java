package entity.mobile;

import java.util.Map;

import entity.PERMEABILITY;
import entity.Sprite;

class Diamond extends MobileEntity{
	public Diamond(int x, int y, Map map) {
		super(x, y, sprite, map, PERMEABILITY.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

	private static final Sprite sprite = new Sprite('A', "diamond.png");
}
