package entity.motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MotionLessEntityFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNotDugWall() {
		assertNotNull(MotionLessEntityFactory.createNotDugWall());
		assertEquals(MotionLessEntityFactory.createNotDugWall().getSprite().getCharImage(), 'W');
	}

	@Test
	public void testCreateDugWall() {
		assertNotNull(MotionLessEntityFactory.createDugWall());
		assertEquals(MotionLessEntityFactory.createDugWall().getSprite().getCharImage(), 'O');
	}

	@Test
	public void testCreateUnbreakableWall() {
		assertNotNull(MotionLessEntityFactory.createUnbreakableWall());
		assertEquals(MotionLessEntityFactory.createUnbreakableWall().getSprite().getCharImage(), 'X');
	}
	
	@Test
	public void testgetFromDBSymbol() {
		assertNotNull(MotionLessEntityFactory.getFromDBSymbol('W'));
		assertEquals(MotionLessEntityFactory.getFromDBSymbol('W').getSprite().getImage(), 
				MotionLessEntityFactory.createNotDugWall().getSprite().getImage() );
	}

}
