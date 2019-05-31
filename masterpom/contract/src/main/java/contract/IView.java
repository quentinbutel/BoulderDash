package contract;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import entity.IMap;
import entity.mobile.IMobile;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	public void updateBoard();
	
}
