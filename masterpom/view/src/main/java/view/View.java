package view;

import java.awt.Dimension;
import java.awt.Rectangle;

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
import showboard.BoardFrame;




/**
 * The Class View.
 *
 * @author Quentin, Lorry
 */
public  class View implements IView, Runnable, KeyListener {
	
	/**The boardFrame	 */
	private BoardFrame boardFrame;
	/**A constant squareSize	 */
	private static final int squareSize = 50;
	/**The list of mEntities	 */
	private ArrayList<IMobile> mEntity = null;
	/**The closeView */
	private Rectangle closeView = null;
	/**The map	 */
	private  IMap map = null;
	/**The player	 */
	private  IMobile character = null;
	/**The controller	 */
	private IController controller;
	/**
	 * gets controller
	 * @return controller 
	 * our controller
	 */
	public IController getController() {
		return controller;
	}
	/**
	 * sets controller
	 * @param controller
	 * a new controller
	 */
	public void setController(IController controller) {
		this.controller = controller;
	}

	/** The frame. +
	 * @return map
	 * our map
	 */
	public IMap getMap() {
		return map;
	}
	/**
	 * sets map
	 * @param map
	 * a new map
	 * @throws IOException
	 * Signal an IOexception
	 */
	public void setMap(IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < Map.getWidth(); x++) {
			for(int y = 0; y < Map.getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();;
			}
		}
	}
	/**
	 * gets character
	 * @return character
	 * our player
	 */
	public IMobile getCharacter() {
		return character;
	}
	/**
	 * sets character
	 * @param character
	 * a new player
	 */
	public void setCharacter(IMobile character) {
		this.character = character;
	}
	/**
	 * gets mEntities
	 * @return mEntities
	 * mobile Entities on the map
	 */
	public ArrayList<IMobile> getmEntity() {
		return mEntity;
	}

	/**
	 * sets mEntity
	 * @param mEntity
	 * a new mobile Entity on the map
	 */
	public void setmEntity(ArrayList<IMobile> mEntity) {
		this.mEntity = mEntity;
	}
	/**
	 * gets close view
	 * @return closeView
	 * closeView
	 */
	public Rectangle getCloseView() {
		return closeView;
	}
	/**
	 * sets closeView
	 * @param closeView
	 * a new rectangle for the view
	 */
	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	
	/**
	 * Instantiates a new view
	 * @param map
	 * our map
	 * @param character
	 * our player
	 * @param mEntity
	 * our mobile Entities
	 * @throws IOException
	 * Signal an IOexception
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
	 * 
	 * @param keyCode
	 * the keyCode
	 * @return ControllerOrder
	 * controllerOrder of a person
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

	/**
	 * Print the message in the board.
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	
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
