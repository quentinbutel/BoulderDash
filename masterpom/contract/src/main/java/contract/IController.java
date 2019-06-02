package contract;

import entity.ControllerOrder;


/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public  void control();
	
	/**
	 * Play
	 * @throws InterruptedException
	 * the interrupted exception
	 */
	public void play() throws InterruptedException;
	
	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder) ;
}
