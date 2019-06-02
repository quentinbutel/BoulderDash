package entity;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {
	private Sprite sprite;
	private PERMEABILITY permeability = PERMEABILITY.BLOCKING;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sprite = new Sprite('P', Sprite.Chara, new Rectangle(48, 0 , 16, 16));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPermeability() {
		assertNotNull(permeability);
		
	}

	@Test
	public void testGetSprite() {
		assertNotNull(sprite);
		assertNotNull(sprite.getCharImage());
	}

	//we don't load the spriteSheet.
	@Test
	public void testGetImage() {
		assertNull(sprite.getImage());
	}

}
