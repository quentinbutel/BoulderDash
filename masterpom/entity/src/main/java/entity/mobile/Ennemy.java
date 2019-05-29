package entity.mobile;




import entity.IMap;
import entity.PERMEABILITY;
import entity.Sprite;

public class Ennemy extends MobileEntity{
	private static final Sprite sprite = new Sprite('M', Sprite.world, 144, 0);

	public Ennemy(int x, int y, IMap map) {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void removeEntity() {
		// TODO Auto-generated method stub
		
	}

}
