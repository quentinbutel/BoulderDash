package view;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.ControllerOrder;
/**
 * the class ViewTest
 * @author Quentin, Lorry
 *
 */
public class ViewTest {

	Rectangle closeView;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		closeView = new Rectangle(10, 20, 15, 12);
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * we check if GetCloseView works correctly
	 */
	@Test
	public void testGetCloseView() {
		final int width = 15;
		final int height = 12;
		assertEquals(width, closeView.width);
		assertEquals(height, closeView.height);
		
	}
	/**
	 * we check if KeyCodeToControllerOrder works correctly
	 */
	@Test
	public void testKeyCodeToControllerOrder() {
		ControllerOrder expected = ControllerOrder.None;
		ControllerOrder obtained = View.keyCodeToControllerOrder(0);
		assertEquals(expected, obtained);
	}
	
}
