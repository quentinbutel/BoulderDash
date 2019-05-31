package contract;




import entity.IMap;

import entity.mobile.Charact;
import entity.mobile.IMobile;


/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	public IMap getMap();
	public IMobile getCharacter();
	public void moveEntity(int y, int x) throws InterruptedException;

}
