package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * the class ModelTest
 * @author Quentin, Lorry
 *
 */
public class ModelTest {
	
	private Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {	
	Model test = new Model(1);
	model = test;
	}

	@After
	public void tearDown() throws Exception {
	}


	/**
	 * we check if GetCharacter works correctly
	 */
	@Test
	public void testGetCharacter() {
		assertNotNull(model.getCharacter());
	}

}
