package entity.motionless;

public class MotionLessEntityFactory {
	
	private static NotDugWall notdugwall =  new NotDugWall();
	private static DugWall dugwall = new DugWall();
	private static UnbreakableWall unbreakablewall = new UnbreakableWall();
	private static MotionLessEntity[] motionlessEntity = {notdugwall, dugwall, unbreakablewall};
	
	//We create a factory for our motionLessElement
	public static MotionLessEntity createNotDugWall() {
		return notdugwall;
	}
	
	public static MotionLessEntity createDugWall() {
		return dugwall;
	}
	
	public static MotionLessEntity createUnbreakableWall() {
		return unbreakablewall;
	}
	
	
	
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
