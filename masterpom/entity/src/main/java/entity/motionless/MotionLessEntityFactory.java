package entity.motionless;

public class MotionLessEntityFactory {
	private Exit exit = new Exit();
	private NotDugWall notdugwall =  new NotDugWall();
	private DugWall dugwall = new DugWall();
	private UnbreakableWall unbreakablewall = new UnbreakableWall();
	
	public MotionLessEntity createExit() {
		return exit;
	}
	
	public MotionLessEntity createNotDugWall() {
		return notdugwall;
	}
	
	public MotionLessEntity createDugWall() {
		return dugwall;
	}
	
	public MotionLessEntity createUnbreakableWall() {
		return unbreakablewall;
	}
	
	public MotionLessEntity[] motionlessEntity = {notdugwall, dugwall, unbreakablewall, exit};
	
	public MotionLessEntity getFromBddSymbol(char symbol) {
		 for (final MotionLessEntity motionlessEntity : motionlessEntity) {
	            if (motionlessEntity.getSprite().getCharImage() == symbol) {
	                return motionlessEntity;
	       }
		 }
		return notdugwall;
	}
}
