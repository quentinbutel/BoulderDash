package entity.mobile;

import java.util.Map;

import entity.PERMEABILITY;
import entity.Sprite;

class Boulder extends MobileEntity{
	public Boulder(int x, int y, Map map) {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		// TODO Auto-generated constructor stub
	}

	private static  final Sprite sprite = new Sprite('P', "boulder.png");
}
