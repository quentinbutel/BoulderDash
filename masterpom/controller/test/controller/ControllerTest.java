package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Controller;
import entity.ControllerOrder;
/**
 * the class ControllerTest
 * @author Quentin, Lorry
 *
 */
public class ControllerTest {

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
	 * we check if GetOrder works correctly
	 */
	@Test
	public void testGetOrder() {
		Controller test = new Controller(null, null);
		test.setOrder(ControllerOrder.Right);
		if (test.getOrder() != ControllerOrder.Right) {
			fail("Wrong type");
		}
	}
	/**
	 * we check if getView works correctly
	 */
	@Test
	public void testGetView() {
		Controller test = new Controller(null, null);
		assertNull(test.getView());
	}
	/**
	 * we check if GetModel works correctly
	 */
	@Test
	public void testGetModel() {
		Controller test = new Controller(null, null);
		assertNull(test.getModel());
	}

}
