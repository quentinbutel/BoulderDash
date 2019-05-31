package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


import contract.IController;


import contract.IView;
import entity.ControllerOrder;
import entity.IMap;
import entity.Map;
import entity.mobile.IMobile;
import test.BoardFrame;




/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public  class View implements IView, Runnable, KeyListener {
	private BoardFrame boardFrame;
	private static final int squareSize = 50;
	private ArrayList<IMobile> mEntity = null;
	private Rectangle closeView = null;
	private  IMap map = null;
	private  IMobile character = null;
	
	private IController controller;
	public IController getController() {
		return controller;
	}

	public void setController(IController controller) {
		this.controller = controller;
	}

	/** The frame. */
	

	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < Map.getWidth(); x++) {
			for(int y = 0; y < Map.getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();;
			}
		}
	}

	public IMobile getCharacter() {
		return character;
	}

	public void setCharacter(IMobile character) {
		this.character = character;
	}

	public ArrayList<IMobile> getmEntity() {
		return mEntity;
	}

	public void setmEntity(ArrayList<IMobile> mEntity) {
		this.mEntity = mEntity;
	}

	public Rectangle getCloseView() {
		return closeView;
	}

	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	
	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 * @throws IOException 
	 */
	public View(final IMap map, final IMobile character, final ArrayList<IMobile> mEntity) throws IOException {
		
		this.setMap(map);
		this.setCharacter(character);
		this.getCharacter().getSprite().loadImage();
		this.setmEntity(mEntity);
		this.setCloseView(new Rectangle(0,0, Map.getWidth(), Map.getHeight()));
		
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		//ControllerOrder control;
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.Up;
				
			case KeyEvent.VK_DOWN:
				return ControllerOrder.Down;
				
			case KeyEvent.VK_RIGHT:
				return  ControllerOrder.Right;
				
			case KeyEvent.VK_LEFT:
				return  ControllerOrder.Left;
			
			default:
				return  ControllerOrder.None;
		}
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		boardFrame = new BoardFrame("Boulderdash");
		boardFrame.setDimension(new Dimension(Map.getWidth(), Map.getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width*squareSize , this.closeView.height*squareSize);
		//boardFrame.setSize(512, 256);
		boardFrame.setLocationRelativeTo(null);
		boardFrame.setHeightLooped(true);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);
		
		for (int x = 0; x < Map.getWidth(); x++) {
			for (int y = 0 ; y < Map.getHeight(); y++) {
				boardFrame.addSquare(this.getMap().getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getCharacter());
		for (IMobile mEntities : mEntity) {
			boardFrame.addPawn(mEntities);
		}
		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		
	
		boardFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	

	

	@Override
	public void keyPressed( final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void updateBoard() {
		for (int x = 0; x < Map.getWidth(); x++) {
			for (int y = 0; y < Map.getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
