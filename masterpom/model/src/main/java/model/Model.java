package model;

import java.io.IOException;

import java.util.ArrayList;


import contract.IModel;
import entity.IMap;
import entity.Sprite;
import entity.mobile.Charact;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;



/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model implements IModel {

	/** The helloWorld. */
	private IMap map;
	
	private Charact character;

	/**
	 * Instantiates a new model.
	 * @throws IOException 
	 */
	public Model(int Level) throws IOException {
		super();
		Sprite.loadSpriteSheet();
		this.setMap(DAOMap.find(Level));
		this.setCharacter(new Charact(1, 1, map));
		this.getMap().toString();
		
	}

	
	

	public IMap getMap() {
		return map;
	}




	public void setMap(IMap map) {
		this.map = map;
	}


	public Charact getCharacter() {
		return character;
	}

	public void setCharacter(Charact character) {
		this.character = character;
	}

	

	public void moveEntity() {
		ArrayList<IMobile> mEntity = new ArrayList<>(this.getMap().getmEntity());
		
		for (IMobile Mentity : mEntity) {
			Mentity.strategy();
		}

		if (this.getCharacter().isCrashed())
			this.getCharacter().die();
	}

}	
