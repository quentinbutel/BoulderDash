package entity.motionless;

public class MotionLessEntityFactory {
	/**
	 * creates a new NotDugWall
	 */
	private static NotDugWall notdugwall =  new NotDugWall();
	/**
	 * creates a new DugWall
	 */
	private static DugWall dugwall = new DugWall();
	/**
	 * creates a new unbreakablewall
	 */
	private static UnbreakableWall unbreakablewall = new UnbreakableWall();
	/**
	 * creates a board gathering motionless elements
	 */
	private static MotionLessEntity[] motionlessEntity = {notdugwall, dugwall, unbreakablewall};
	
	/**
	 * factory of notdugwall creation
	 * @return notdugwall
	 * returns the created notdugwall
	 * 
	 */
	//We create a factory for our motionLessElement
	public static MotionLessEntity createNotDugWall() {
		return notdugwall;
	}
	
	/**
	 * factory of dugwall creation
	 * @return dugwall
	 * returns the created dugwall
	 * 
	 */
	public static MotionLessEntity createDugWall() {
		return dugwall;
	}
	
	
	/**
	 * factory of unbreakable creation
	 * @return unbreakablewall
	 * returns the created unbreakable
	 */
	public static MotionLessEntity createUnbreakableWall() {
		return unbreakablewall;
	}
	
	
	/**
	 * returns an entity following the symbol
	 * @param symbol
	 * @return Motionlessentity
	 * the entity associate to its symbol
	 */
	public static  MotionLessEntity getFromDBSymbol(char symbol) {
		 for (final MotionLessEntity motionlessEntity : motionlessEntity) {
	            if (motionlessEntity.getSprite().getCharImage() == symbol) {
	                return motionlessEntity;
	       }
		 }
		 // If the symbols do not match, we create by default a dugWall
		return dugwall;
	}
}
