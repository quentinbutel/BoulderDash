package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Boulder;

import entity.mobile.MobileEntity;
import entity.motionless.MotionLessEntityFactory;
/**
 * the class MapTest
 * @author Quentin, Lorry
 *
 */
public class MapTest {
	private Map map;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(null);

		
		map.addDiamond();
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testGetCharacter() {
		assertNull(map.getCharacter());
	}

	@Test
	public void testGetDiamondCount() {
		final int expected = 1;
		assertEquals(expected, map.getDiamondCount());
	}

	
	@Test
	public void testAddDiamond() {
		final int expected = 2;
		map.addDiamond();
		assertEquals(expected, map.getDiamondCount());
	}

	@Test
	public void testDecreaseDiamond() {
		final int expected = 0 ;
		map.decreaseDiamond();
		assertEquals(expected, map.getDiamondCount());
	}


}
