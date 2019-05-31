package entity;

import java.util.ArrayList;
import java.util.Observable;

import entity.mobile.Charact;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;

public interface IMap {
	public IEntity getOnTheMapXY(int x, int y);
	public int getDiamondCount();
	public void add(IMobile mEntity);
	public IMobile getCharacter();
	public ArrayList<IMobile> getmEntity();
	public Observable getObservable();
	public void addDiamond();
	public void decreaseDiamond();
	public void setMobHasChanged();
	public void setOnTheMapXY(IEntity entity, int x, int y);
	public PERMEABILITY getMapElementXY(final int x, final int y);
	public void setCharacter(IMobile character);
	
	
}
