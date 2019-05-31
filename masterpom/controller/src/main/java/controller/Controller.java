package controller;


import contract.IController;
import contract.IModel;

import contract.IView;
import entity.ControllerOrder;

/**
 * The Class Controller.
 */
public final class Controller implements IController{

	/** The view. */
	private int y;
	private int x;
	private IView		view;
	private static final int thread = 200;

	/** The model. */
	private IModel	model;
	private ControllerOrder order = ControllerOrder.None;

	public ControllerOrder getOrder() {
		return this.order;
	}

	public void setOrder(ControllerOrder order) {
		this.order = order;
	}

	public IView getView() {
		return view;
	}

	public IModel getModel() {
		return model;
	}

	
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearOrder();
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les flèches directionnelles pour vous déplacer dans le jeu.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	@Override
	public void orderPerform(ControllerOrder controllerOrder) {
		// TODO Auto-generated method stub
		this.setOrder(controllerOrder);
		
	}
	
	private void clearOrder() {
		this.order=ControllerOrder.None;
	}
	
	public final void play() throws InterruptedException{
		this.getModel().getMap().setCharacter(this.getModel().getCharacter());
		
		while (this.getModel().getCharacter().isAlive()) {
			Thread.sleep(thread);
			if (this.getModel().getCharacter().canMove(this.getOrder())) {
			switch (this.getOrder()) {
				case Right :
					this.getModel().getCharacter().moveRight();
					
					break;
				case Left : 
					this.getModel().getCharacter().moveLeft();
					
					break;
				case Up : 
					this.getModel().getCharacter().moveUp();
					
					break;
				case Down : 
					this.getModel().getCharacter().moveDown();
					
					break;
				case None : 
					default : this.getModel().getCharacter().immobile();
					
					break;
				}
		}
			
			
		this.getModel().moveEntity(y, x);
		y = this.getModel().getMap().getCharacter().getY();
		x = this.getModel().getMap().getCharacter().getX();
	System.out.println(this.getModel().getMap().getDiamondCount());
			this.clearOrder();
			this.getView().updateBoard();
	
			if (this.getModel().getMap().getDiamondCount() <= 0) {
				this.getView().printMessage("You have won!");
				System.exit(0);
			}
		}
		
		this.getView().printMessage("Game Over");
		System.exit(0);
	}

	




	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	

}
