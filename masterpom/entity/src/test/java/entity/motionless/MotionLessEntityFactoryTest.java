package entity.motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * the class MotionLessEntityFactoryTest
 * @author Quentin, Lorry
 *
 */
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

	/**
	 * this test checks that this method doesn't return null and 
	 * we check that an entity has been correctly initialized
	 */
	@Test
	public void testCreateNotDugWall() {
		assertNotNull(MotionLessEntityFactory.createNotDugWall());
		assertEquals(MotionLessEntityFactory.createNotDugWall().getSprite().getCharImage(), 'W');
	}
	/**
	 * this test checks that this method doesn't return null and 
	 * we check that an entity has been correctly initialized
	 */
	@Test
	public void testCreateDugWall() {
		assertNotNull(MotionLessEntityFactory.createDugWall());
		assertEquals(MotionLessEntityFactory.createDugWall().getSprite().getCharImage(), 'O');
	}
	/**
	 * this test checks that this method doesn't return null and 
	 * we check that an entity has been correctly initialized
	 */
	@Test
	public void testCreateUnbreakableWall() {
		assertNotNull(MotionLessEntityFactory.createUnbreakableWall());
		assertEquals(MotionLessEntityFactory.createUnbreakableWall().getSprite().getCharImage(), 'X');
	}
	/**
	 * this test checks that this method doesn't return null and 
	 * we check that an entity has been correctly initialized
	 */
	@Test
	public void testgetFromDBSymbol() {
		assertNotNull(MotionLessEntityFactory.getFromDBSymbol('W'));
		assertEquals(MotionLessEntityFactory.getFromDBSymbol('W').getSprite().getImage(), 
				MotionLessEntityFactory.createNotDugWall().getSprite().getImage() );
	}

}
