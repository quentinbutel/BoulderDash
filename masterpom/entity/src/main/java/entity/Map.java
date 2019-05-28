package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

import entity.mobile.Charact;
import entity.mobile.MobileEntity;
public class Map extends Observable implements IMap{

	
	private int diamondCount = 0;
	private IEntity[][] map;	
	private ArrayList<MobileEntity> mEntity;
	private Charact character;
	
	public Charact getCharacter() {
		return character;
	}
	public void setCharacter(Charact character) {
		this.character = character;
	}
	
	public int getDiamondCount() {
		return diamondCount;
	}
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	public Observable getObservable() {
		return this;
	}
	
	
	public Map(IEntity[][] map) {
	this.map = map;
	this.mEntity= new ArrayList<MobileEntity>();
	}
	
	
	public IEntity getOnTheMapXY(int x, int y) {
		// TODO Auto-generated method stub
		return this.map[x][y];
	}
	
	public void setOnTheMapXY(IEntity entity, int x, int y) {
		this.map[x][y] = entity;
	}
	
	
	public void setMobHasChanged() {
		this.notifyObservers();
		this.hasChanged();
	}
	
	public void add(MobileEntity mEntity) {
		this.mEntity.add(mEntity);
	}
	public ArrayList<MobileEntity> getmEntity() {
		return mEntity;
	}
	
	public void addDiamond() {
		this.diamondCount++;
	}
	
	public void decreaseDiamond() {
		this.diamondCount--;
	}
	 public PERMEABILITY getSquareIsOccupiedXY(final int x, final int y) {
		    Point point = new Point(x, y);
		    for(MobileEntity mEntity : this.getmEntity()) {
		      if (mEntity.getPosition().equals(point))
		        return mEntity.getPermeability();
		    }
		    
		    if(this.getCharacter().getPosition().equals(point))
		    	return this.getCharacter().getPermeability();
		    
		    return this.getOnTheMapXY(x, y).getPermeability();
		  }
	
}
