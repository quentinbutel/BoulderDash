/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;


import java.io.IOException;

import contract.IController;
import contract.IModel;
import contract.IView;
import controller.Controller;
import entity.ControllerOrder;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     * Signal an IOexception
     * @throws InterruptedException
     * the interrupted exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IModel model = new Model(1);
       final View view = new View(model.getMap(), model.getCharacter(), model.getMap().getmEntity());
        final IController controller = new Controller(view, model);
        view.setController(controller);
       try {
        	controller.control();
            controller.play();
        } catch (InterruptedException e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

    }
}
