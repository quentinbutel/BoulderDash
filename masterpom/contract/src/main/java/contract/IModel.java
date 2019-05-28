package contract;




import entity.IMap;

import entity.mobile.Charact;


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
	IMap getMap();
	public Charact getCharacter();
	

}
