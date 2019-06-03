package contract;




import entity.IMap;

import entity.mobile.Charact;
import entity.mobile.IMobile;


/**
 * The Interface IModel.
 *
 * @author Quentin
 */
public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return the map with all of the elements
	 */
	public IMap getMap();
	
	/**
	 * Gets our character
	 * @return the character
	 */
	public IMobile getCharacter();
	
	/**
	 * MobileEntity and their strategy.
	 * @param y
	 * x
	 * @param x
	 * y
	 */
	public void moveEntity(int y, int x);

}
